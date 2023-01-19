package az.eurodesign.notification.management.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class ApiException extends RuntimeException {

    private final String message;

    public ApiException(String message) {
        this.message = message;
    }

    @Getter @Setter
    protected Map<String, List<String>> description = new HashMap<>();

    public String getMessage() {
        return message;
    }

    public abstract HttpStatus getHttpStatus();
}
