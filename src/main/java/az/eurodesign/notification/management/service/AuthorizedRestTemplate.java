package az.eurodesign.notification.management.service;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

public interface AuthorizedRestTemplate {
    <T> ResponseEntity<T> exchange(String url, HttpMethod httpMethod, Class<T> response);
}
