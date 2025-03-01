package com.suprimi4.boot.service;


import com.suprimi4.boot.model.Car;
import com.suprimi4.boot.repository.CarRepository;
import com.suprimi4.boot.repository.UserRepository;
import com.suprimi4.boot.repsonse.LoanApprovalResponse;
import org.springframework.stereotype.Service;
import com.suprimi4.boot.model.User;

import java.util.Optional;


@Service
public class LoanApprovalServiceImpl implements LoanApprovalService{
    private final UserRepository userRepository;
    private final CarRepository carRepository;
    private final LoanCalculationService calculationService;


    public LoanApprovalServiceImpl(UserRepository userRepository, CarRepository carRepository, LoanCalculationService calculationService) {
        this.userRepository = userRepository;
        this.carRepository = carRepository;
        this.calculationService = calculationService;
    }


    public LoanApprovalResponse loanApprove(int userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            Car car = carRepository.findByUserId(userId);

            int userIncome = user.getIncome() == null? 0 : user.getIncome();
            int carCost = car != null ? car.getCost() : 0;

            double maxLoan = calculationService.calculateMaxLoan(userIncome, carCost);

            return new LoanApprovalResponse(user.getId(), maxLoan);
        }

        return new LoanApprovalResponse();
    }

}
