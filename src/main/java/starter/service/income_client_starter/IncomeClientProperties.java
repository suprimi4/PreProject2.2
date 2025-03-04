package starter.service.income_client_starter;


import org.springframework.boot.context.properties.ConfigurationProperties;




@ConfigurationProperties(prefix = "income.client")
public class IncomeClientProperties {

    private final String url = "https://66055cd12ca9478ea1801f2e.mockapi.io/api/users/income";

    public String getUrl() {
        return url;
    }
}

