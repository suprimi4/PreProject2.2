package com.suprimi4.boot.service;


import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Service;

@Service
public class LoanCalculationService {
    @Value("${loan.minimalincome}")
    private  int minimalIncome;
    @Value("${loan.minumalcarcost}")
    private  int minimalCarCost;



    public Double calculateMaxLoan(int userIncome, int carCost) {
        double maxLoanByIncome = userIncome > minimalIncome ? (double) (userIncome * 12) / 2 : 0;
        double maxLoanByCar = carCost > minimalCarCost ? carCost * 0.3 : 0;

        return Math.max(maxLoanByCar, maxLoanByIncome);
    }
}