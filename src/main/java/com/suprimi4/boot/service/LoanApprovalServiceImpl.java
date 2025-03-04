package com.suprimi4.boot.service;


import com.suprimi4.boot.mapper.UserMapper;
import com.suprimi4.boot.model.Car;
import com.suprimi4.boot.repository.UserRepository;
import com.suprimi4.boot.repsonse.LoanApprovalResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.suprimi4.boot.model.User;
import starter.service.income_client_starter.IncomeClient;

import java.util.List;
import java.util.Optional;

@Service
public class LoanApprovalServiceImpl implements LoanApprovalService {
    private final UserRepository userRepository;
    private final LoanCalculationService calculationService;
    private final IncomeClient incomeClient;


    public LoanApprovalServiceImpl(UserRepository userRepository, LoanCalculationService calculationService, IncomeClient incomeClient) {
        this.userRepository = userRepository;
        this.calculationService = calculationService;
        this.incomeClient = incomeClient;
    }

    @PostConstruct
    public void init() {
        List<User> users = UserMapper.map(incomeClient.fetch());
        userRepository.saveAll(users);
        Car car = new Car("Tesla", "Model X", 2022, 20000000);
        User user = userRepository.findById(5).get();
        user.setCar(car);
        userRepository.save(user);
    }


    public LoanApprovalResponse loanApprove(int userId) {
        List<User> users = UserMapper.map(incomeClient.fetch());
        Optional<User> optionalUser = users.stream().filter(user -> user.getId() == userId).findFirst();
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            Optional<User> userInstanceWithCar = userRepository.findById(userId);
            Car car = userInstanceWithCar.map(User::getCar).orElse(null);

            int userIncome = user.getIncome() == null ? 0 : user.getIncome();
            int carCost = car == null ? 0 : car.getCost();

            double maxLoan = calculationService.calculateMaxLoan(userIncome, carCost);

            return new LoanApprovalResponse(user.getId(), maxLoan);
        }

        return new LoanApprovalResponse();
    }


}
