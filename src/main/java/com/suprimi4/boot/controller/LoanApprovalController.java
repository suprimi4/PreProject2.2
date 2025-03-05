package com.suprimi4.boot.controller;


import com.suprimi4.boot.repsonse.LoanApprovalResponse;
import com.suprimi4.boot.service.LoanApprovalServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loan")
public class LoanApprovalController {
    private final LoanApprovalServiceImpl loanApprovalServiceImpl;

    public LoanApprovalController(LoanApprovalServiceImpl loanApprovalServiceImpl) {
        this.loanApprovalServiceImpl = loanApprovalServiceImpl;
    }

    @GetMapping
    public ResponseEntity<Double> getLoanResponse(@RequestParam("userId") Integer id) {
        LoanApprovalResponse loanResponse = loanApprovalServiceImpl.loanApprove(id);

        if (loanResponse.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(loanResponse.getMaxLoan(), HttpStatus.OK);
    }


}
