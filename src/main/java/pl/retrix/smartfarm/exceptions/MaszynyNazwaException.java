package pl.retrix.smartfarm.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MaszynyNazwaException extends RuntimeException{
    public MaszynyNazwaException(String message) { super(message);}
}
