package com.suprimi4.boot.controller;


import com.suprimi4.boot.repsonse.LoanApprovalResponse;
import com.suprimi4.boot.service.LoanApprovalServiceImpl;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loan")
public class LoanApprovalController {
    private LoanApprovalServiceImpl loanApprovalServiceImpl;

    public LoanApprovalController(LoanApprovalServiceImpl loanApprovalServiceImpl) {
        this.loanApprovalServiceImpl = loanApprovalServiceImpl;
    }

    @GetMapping
    public LoanApprovalResponse getLoanResponse(@RequestParam("userId") Integer id, HttpServletResponse response) {
        LoanApprovalResponse loanResponse = loanApprovalServiceImpl.loanApprove(id);

        if (loanResponse.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        return loanResponse;
    }


}
