package com.suprimi4.boot.service;

import com.suprimi4.boot.repsonse.LoanApprovalResponse;

public interface LoanApprovalService {
    LoanApprovalResponse loanApprove(int userId);
}
