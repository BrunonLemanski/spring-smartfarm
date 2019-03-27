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
    public final ResponseEntity<Object> handleNazwaPolaPolaUprawneException(PolaUprawneException ex, WebRequest request)
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

    @ExceptionHandler
    public final ResponseEntity<Object> handleUsernameAlreadyExistException(UsernameAlreadyExistException ex, WebRequest request)
    {
        UsernameAlreadyExistResponse exceptionResponse = new UsernameAlreadyExistResponse((ex.getMessage()));
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleIdPolaPlonyException(PlonyIdUprawyException ex, WebRequest request)
    {
        PlonyIdUprawyExceptionResponse exceptionResponse = new PlonyIdUprawyExceptionResponse(ex.getMessage());
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleIdOszczednosciException(OszczednosciIdException ex, WebRequest request)
    {
        OszczednosciIdExceptionResponse exceptionResponse = new OszczednosciIdExceptionResponse(ex.getMessage());
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleTytulPozyczkiException(PozyczkiTytulException ex, WebRequest request)
    {
        PozyczkiTytulExceptionRespone exceptionResponse = new PozyczkiTytulExceptionRespone(ex.getMessage());
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleTytulWyplatyException(WyplatyTytulException ex, WebRequest request)
    {
        WyplatyTytulExceptionResponse exceptionResponse = new WyplatyTytulExceptionResponse(ex.getMessage());
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleTytulWydatkiException(WydatkiTytulException ex, WebRequest request)
    {
        WydatkiTytulExceptionResponse exceptionResponse = new WydatkiTytulExceptionResponse(ex.getMessage());
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleTytulZobowiazaniaException(ZobowiazaniaTytulException ex, WebRequest request)
    {
        ZobowiazaniaTytulExceptionResponse exceptionResponse = new ZobowiazaniaTytulExceptionResponse(ex.getMessage());
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleTytulPrzychodyException(PrzychodyTytulException ex, WebRequest request)
    {
        PrzychodyTytulExceptionResponse exceptionResponse = new PrzychodyTytulExceptionResponse(ex.getMessage());
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleTypUprawyLacznyPlonException(LacznyPlonTypUprawyException ex, WebRequest request)
    {
        LacznyPlonTypUprawyExceptionResponse exceptionResponse = new LacznyPlonTypUprawyExceptionResponse(ex.getMessage());
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleNazwaMagazynException(MagazynNazwaException ex, WebRequest request)
    {
        MagazynNazwaExceptionResponse exceptionResponse = new MagazynNazwaExceptionResponse(ex.getMessage());
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleIdNawozeniaNawozenieException(NawozenieIdNawozeniaException ex, WebRequest request)
    {
        NawozenieIdNawozeniaExceptionResponse exceptionResponse = new NawozenieIdNawozeniaExceptionResponse(ex.getMessage());
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}