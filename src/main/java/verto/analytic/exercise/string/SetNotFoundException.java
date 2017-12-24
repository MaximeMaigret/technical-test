package verto.analytic.exercise.string;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class SetNotFoundException  extends IllegalArgumentException {
}
