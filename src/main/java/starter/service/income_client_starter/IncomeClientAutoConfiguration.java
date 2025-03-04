package starter.service.income_client_starter;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import org.springframework.web.client.RestTemplate;

@AutoConfiguration
@EnableConfigurationProperties(IncomeClientProperties.class)

public class IncomeClientAutoConfiguration {


    @Bean
    @ConditionalOnMissingBean(RestTemplate.class)
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    private IncomeClientProperties properties;

    @Bean
    @ConditionalOnMissingBean(IncomeClient.class)
    public IncomeClient incomeClient(RestTemplate restTemplate, IncomeClientProperties properties) {
        IncomeClient incomeClient = new IncomeClient(restTemplate);
        incomeClient.setUrl(properties.getUrl());
        return incomeClient;
    }
}
