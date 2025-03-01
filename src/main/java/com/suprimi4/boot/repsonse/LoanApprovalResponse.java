package com.suprimi4.boot.repsonse;


import com.fasterxml.jackson.annotation.JsonIgnore;

public class LoanApprovalResponse {
    private Integer userId;
    private double maxLoan;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public double getMaxLoan() {
        return maxLoan;
    }

    public void setMaxLoan(double maxLoan) {
        this.maxLoan = maxLoan;
    }

    public LoanApprovalResponse() {
    }

    public LoanApprovalResponse(int userId, double maxLoan) {
        this.userId = userId;
        this.maxLoan = maxLoan;
    }

    @JsonIgnore
    public boolean isEmpty() {
        return userId == null;
    }
}
