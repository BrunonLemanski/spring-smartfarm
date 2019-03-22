package pl.retrix.smartfarm.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NawozenieIdNawozeniaException extends RuntimeException{
    public NawozenieIdNawozeniaException(String message){super(message);}
}
