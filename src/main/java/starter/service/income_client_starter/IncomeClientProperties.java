package starter.service.income_client_starter;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;


@Setter
@Getter
@ConfigurationProperties(prefix = "income.client")
public class IncomeClientProperties {

    private String url;

}

