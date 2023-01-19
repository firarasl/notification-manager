package az.eurodesign.notification.management.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends ApiException {

    public BadRequestException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.CONFLICT;
    }
}
