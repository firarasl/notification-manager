package az.eurodesign.notification.management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public final ResponseEntity<ApiError> handleException(ApiException exception) {
        return new ResponseEntity<>(new ApiError(exception), exception.getHttpStatus());
    }

    @ExceptionHandler({MethodArgumentNotValidException.class}) //TODO: make better view
    public final ResponseEntity<ApiError> handleException(MethodArgumentNotValidException exception) {
        Map<String, List<String>> description = exception.getBindingResult()
                .getAllErrors()
                .stream()
                .collect(Collectors.groupingBy(ObjectError::getObjectName))
                .entrySet()
                .stream()
                .collect(
                        Collectors.toMap(
                                Map.Entry::getKey,
                                x -> x.getValue().stream()
                                        .map(y -> y.getDefaultMessage() == null
                                                ? "Not available part of description"
                                                : y.getDefaultMessage()
                                        )
                                        .collect(Collectors.toList())
                        )
                );

        return new ResponseEntity<>(new ApiError("Validation failed", description), HttpStatus.BAD_REQUEST);
    }
}
