package com.suprimi4.boot.repsonse;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Getter
@Setter
public class LoanApprovalResponse {
    private final Integer userId;
    private final double maxLoan;


    public LoanApprovalResponse(int userId, double maxLoan) {
        this.userId = userId;
        this.maxLoan = maxLoan;
    }

    @JsonIgnore
    public boolean isEmpty() {
        return userId == null;
    }
}
