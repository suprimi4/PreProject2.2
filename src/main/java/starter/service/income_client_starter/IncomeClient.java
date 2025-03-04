package starter.service.income_client_starter;


import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpMethod;
import org.springframework.core.ParameterizedTypeReference;

import java.util.List;



public class IncomeClient {

    private final RestTemplate restTemplate;

    private String url;

    public IncomeClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<FetchUser> fetch() {
        ResponseEntity<List<FetchUser>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );

        return response.getBody();
    }


}
