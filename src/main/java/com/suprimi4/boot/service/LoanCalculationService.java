package com.suprimi4.boot.service;

import com.suprimi4.boot.properties.LoanProperties;

import org.springframework.stereotype.Service;

@Service
public class LoanCalculationService {

    private final LoanProperties loanProperties;

    public LoanCalculationService(LoanProperties loanProperties) {
        this.loanProperties = loanProperties;
    }

    public Double calculateMaxLoan(int userIncome, int carCost) {
        double maxLoanByIncome = userIncome > loanProperties.getMinimalIncome() ? (double) (userIncome * 12) / 2 : 0;
        double maxLoanByCar = carCost > loanProperties.getMinimalCarCost() ? carCost * 0.3 : 0;

        return Math.max(maxLoanByCar, maxLoanByIncome);
    }
}