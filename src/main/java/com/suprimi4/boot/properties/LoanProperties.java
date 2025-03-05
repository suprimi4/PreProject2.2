package com.suprimi4.boot.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "loan")
public class LoanProperties {

    private int minimalIncome;
    private int minimalCarCost;

}
