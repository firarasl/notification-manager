package az.eurodesign.notification.management.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public class ApiError {

    private final String message;

    private Map<String, List<String>> description;

    public ApiError(ApiException exception) {
        this.message = exception.getMessage();
        this.description = exception.getDescription();
    }
}
