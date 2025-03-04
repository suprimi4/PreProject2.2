package starter.service.income_client_starter;


import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "income.client")
public class IncomeClientProperties {

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

