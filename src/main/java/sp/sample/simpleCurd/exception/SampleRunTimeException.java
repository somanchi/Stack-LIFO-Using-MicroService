package sp.sample.simpleCurd.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class SampleRunTimeException extends RuntimeException{
    private HttpStatus errorCode;
    private String errorMessage;

    public SampleRunTimeException(HttpStatus errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

}
