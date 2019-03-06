package pl.retrix.smartfarm.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestController
@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<Object> handleNazwaTowaruException(MagazynNazwaException ex, WebRequest request)
    {
        MagazynNazwaExceptionResponse exceptionResponse = new MagazynNazwaExceptionResponse(ex.getMessage());
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleNazwaMaszynyException(MaszynyNazwaException ex, WebRequest request)
    {
        MaszynyNazwaExceptionResponse exceptionResponse = new MaszynyNazwaExceptionResponse(ex.getMessage());
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleDateMlekoException(MlekoIloscException ex, WebRequest request)
    {
        MlekoIloscExceptionResponse exceptionResponse = new MlekoIloscExceptionResponse(ex.getMessage());
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleNazwaPolaException(PolaUprawneException ex, WebRequest request)
    {
        PolaUprawneExceptionResponse exceptionResponse = new PolaUprawneExceptionResponse(ex.getMessage());
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleInwentarzNrIdException(InwentarzNrIdException ex, WebRequest request)
    {
        InwentarzNrIdExceptionResponse exceptionResponse = new InwentarzNrIdExceptionResponse(ex.getMessage());
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}