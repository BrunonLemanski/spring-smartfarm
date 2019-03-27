package pl.retrix.smartfarm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.retrix.smartfarm.domain.finanse.Przychody;
import pl.retrix.smartfarm.services.MapValidationErrorService;
import pl.retrix.smartfarm.services.PrzychodyService;

import javax.validation.Valid;

@RequestMapping("api/przychody")
public class PrzychodyController {

    @Autowired
    private PrzychodyService przychodyService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> dodajNowePrzychody(@Valid @RequestBody Przychody przychody, BindingResult result){
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidatonService(result);
        if(errorMap!= null) return errorMap;

        Przychody przychody1 = przychodyService.saveOrUpdatePrzychody(przychody);

        return new ResponseEntity<Przychody>(przychody, HttpStatus.CREATED);
    }

    //Wyszukiwanie rekordu w bazie
    @GetMapping("/{tytul}")
    public ResponseEntity<?> getPrzychodyByTytul(@PathVariable String tytul){

        Przychody przychody = przychodyService.findPrzychodyByTytul(tytul);

        return new ResponseEntity<Przychody>(przychody, HttpStatus.OK);
    }

    //Wyszukiwanie wszystkich rekordow w bazie
    @GetMapping("/all")
    public Iterable<Przychody> getAllInwentarz(){return przychodyService.findAllPrzychody();}

    //Usuwanie rekordu z bazy
    @DeleteMapping("/{tytul}")
    public ResponseEntity<?> deletePrzychody(@PathVariable String tytul){
        przychodyService.deletePrzychodyByTytul(tytul);

        return new ResponseEntity<String>("Wpis " + tytul + " został usunięty z bazy danych", HttpStatus.OK);
    }
}
