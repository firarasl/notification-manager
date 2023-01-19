package az.eurodesign.notification.management.exception;

import org.springframework.http.HttpStatus;

public class RemoteServerException extends ApiException {

    public RemoteServerException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.FAILED_DEPENDENCY;
    }
}
