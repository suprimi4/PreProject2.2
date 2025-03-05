package starter.service.income_client_starter;


import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpMethod;
import org.springframework.core.ParameterizedTypeReference;

import java.util.List;

@RequiredArgsConstructor
public class IncomeClient {

    private final RestTemplate restTemplate;

    @Setter
    private String url;


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
