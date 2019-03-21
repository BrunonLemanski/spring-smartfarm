package pl.retrix.smartfarm.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class LacznyPlonTypUprawyException extends RuntimeException{
    public LacznyPlonTypUprawyException(String message){super(message);}
}
