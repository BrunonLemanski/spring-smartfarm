package pl.retrix.smartfarm.exceptions;

import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.retrix.smartfarm.domain.finanse.Wyplaty;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class WyplatyTytulException extends RuntimeException{
    public WyplatyTytulException(String message){super(message);}
}
