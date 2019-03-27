package pl.retrix.smartfarm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.retrix.smartfarm.domain.finanse.Pozyczki;
import pl.retrix.smartfarm.services.MapValidationErrorService;
import pl.retrix.smartfarm.services.PozyczkiService;

import javax.validation.Valid;

@RestController
@RequestMapping("api/pozyczki")
public class PozyczkiController {

    @Autowired
    private PozyczkiService pozyczkiService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    private ResponseEntity<?> dodajNowaPozyczke(@Valid @RequestBody Pozyczki pozyczki, BindingResult result){
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidatonService(result);

        if(errorMap != null) return errorMap;

        Pozyczki pozyczki1 = pozyczkiService.saveOrUpdatePozyczki(pozyczki);

        return new ResponseEntity<Pozyczki>(pozyczki, HttpStatus.CREATED);
    }

    //Wyszukiwanie rekordu w bazie
    @GetMapping("/{tytul}")
    public ResponseEntity<?> getPozyczkeByTytul(@PathVariable String tytul){

        Pozyczki pozyczki = pozyczkiService.findPozyczkiByTytul(tytul);

        return new ResponseEntity<Pozyczki>(pozyczki, HttpStatus.OK);
    }

    @GetMapping("/all")
    public Iterable<Pozyczki> getAllPozyczki(){return pozyczkiService.findAllPozyczki();}

    //Usuwanie rekordu z bazy
    @DeleteMapping("/{tytul}")
    public ResponseEntity<?> deletePozyczke(@PathVariable String tytul){
        pozyczkiService.deletePozyczkiByTytul(tytul);

        return new ResponseEntity<String>("Wpis " + tytul + " został usunięty z bazy danych", HttpStatus.OK);
    }
}
