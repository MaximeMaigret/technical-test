package verto.analytic.exercise.string;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST)
public class DuplicateStringException extends IllegalArgumentException {

    public DuplicateStringException(String message){
        super(message);
    }

}
