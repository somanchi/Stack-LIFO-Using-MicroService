package sp.sample.simpleCurd.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import sp.sample.simpleCurd.exception.SampleRunTimeException;

@ControllerAdvice
@Slf4j
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(SampleRunTimeException.class)
    public ResponseEntity<String> handleTrustedTokenException(SampleRunTimeException ex) {
        log.error("Error",ex);
        return new ResponseEntity(ex.getErrorMessage(), ex.getErrorCode());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> genericExceptionHandler(Exception ex) {
        log.error("Error",ex);
        return new ResponseEntity(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
