package com.suprimi4.boot.service;


import com.suprimi4.boot.datareciever.UserFetcher;
import com.suprimi4.boot.model.Car;
import com.suprimi4.boot.repository.UserRepository;
import com.suprimi4.boot.repsonse.LoanApprovalResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import com.suprimi4.boot.model.User;

import java.util.List;
import java.util.Optional;


@Service
public class LoanApprovalServiceImpl implements LoanApprovalService {
    private final UserRepository userRepository;
    private final LoanCalculationService calculationService;
    private final UserFetcher userFetcher;


    public LoanApprovalServiceImpl(UserRepository userRepository, LoanCalculationService calculationService, UserFetcher userFetcher) {
        this.userRepository = userRepository;
        this.calculationService = calculationService;
        this.userFetcher = userFetcher;
    }

    @PostConstruct
    public void init() {
        userRepository.saveAll(userFetcher.fetch());
        Car car = new Car("Tesla", "Model X", 2022, 20000000);
        User user = userRepository.findById(5).get();
        user.setCar(car);
        userRepository.save(user);
    }


    public LoanApprovalResponse loanApprove(int userId) {
        List<User> userList = userFetcher.fetch();
        Optional<User> optionalUser = userList.stream().filter(user -> user.getId() == userId).findFirst();
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            Car car;
            Optional<User> userInstanceWithCar = userRepository.findById(userId);
            car = userInstanceWithCar.map(User::getCar).orElse(null);

            int userIncome = user.getIncome() == null ? 0 : user.getIncome();
            int carCost = car == null ? 0 : car.getCost();

            double maxLoan = calculationService.calculateMaxLoan(userIncome, carCost);

            return new LoanApprovalResponse(user.getId(), maxLoan);
        }

        return new LoanApprovalResponse();
    }


}
