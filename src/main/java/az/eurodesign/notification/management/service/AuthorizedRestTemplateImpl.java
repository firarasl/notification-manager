package az.eurodesign.notification.management.service;

import az.eurodesign.notification.management.exception.RestTemplateResponseErrorHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.function.Function;

@Service
public class AuthorizedRestTemplateImpl implements AuthorizedRestTemplate {

    private final RestTemplate restTemplate;

    private final TokenStorage tokenStorage;

    @Autowired
    public AuthorizedRestTemplateImpl(RestTemplateBuilder restTemplateBuilder,
                                      TokenStorage tokenStorage) {
        restTemplate = restTemplateBuilder.errorHandler(new RestTemplateResponseErrorHandler()).build();
        this.tokenStorage = tokenStorage;
    }

    @Override
    public <T> ResponseEntity<T> exchange(String url, HttpMethod httpMethod, Class<T> responseClass) {

        Function<HttpHeaders,ResponseEntity<T>> function =  (headers) -> restTemplate.exchange(
                url,
                httpMethod,
                new HttpEntity<>(headers),
                responseClass
        );

        ResponseEntity<T> responseEntity = function.apply(getHeadersWithToken());

        if (responseEntity.getStatusCode() == HttpStatus.UNAUTHORIZED) {

            tokenStorage.update();
            responseEntity = function.apply(getHeadersWithToken());
        }

        return responseEntity;
    }

    private HttpHeaders getHeadersWithToken() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + tokenStorage.get().getAccessValue());
        return headers;
    }

}
