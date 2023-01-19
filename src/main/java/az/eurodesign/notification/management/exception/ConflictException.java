package az.eurodesign.notification.management.exception;

import org.springframework.http.HttpStatus;

public class ConflictException extends ApiException {

    public ConflictException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.CONFLICT;
    }
}
