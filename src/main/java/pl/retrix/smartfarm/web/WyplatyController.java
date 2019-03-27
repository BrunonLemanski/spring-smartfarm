package pl.retrix.smartfarm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.retrix.smartfarm.domain.finanse.Wyplaty;
import pl.retrix.smartfarm.services.MapValidationErrorService;
import pl.retrix.smartfarm.services.WyplatyService;

import javax.validation.Valid;

@RestController
@RequestMapping("api/wyplaty")
public class WyplatyController {

    @Autowired
    private WyplatyService wyplatyService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> dodajNowaWyplate(@Valid @RequestBody Wyplaty wyplaty, BindingResult result){
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidatonService(result);
        if(errorMap!= null) return errorMap;

        Wyplaty wyplaty1 = wyplatyService.saveOrUpdateWyplaty(wyplaty);

        return new ResponseEntity<Wyplaty>(wyplaty, HttpStatus.CREATED);
    }

    //Wyszukiwanie rekordu w bazie
    @GetMapping("/{tytul}")
    public ResponseEntity<?> getWyplateByTytul(@PathVariable String tytul){

        Wyplaty wyplaty = wyplatyService.findWyplateByTytul(tytul);

        return new ResponseEntity<Wyplaty>(wyplaty, HttpStatus.OK);
    }

    //Wyszukiwanie wszystkich rekordow w bazie
    @GetMapping("/all")
    public Iterable<Wyplaty> getAllWyplaty(){return wyplatyService.findAllWyplaty();}

    //Usuwanie rekordu z bazy
    @DeleteMapping("/{tytul}")
    public ResponseEntity<?> deleteWyplaty(@PathVariable String tytul){
        wyplatyService.deleteWyplatyByTytul(tytul);

        return new ResponseEntity<String>("Wpis " + tytul + " został usunięty z bazy danych", HttpStatus.OK);
    }
}
