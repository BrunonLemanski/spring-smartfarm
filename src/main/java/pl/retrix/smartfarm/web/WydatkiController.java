package pl.retrix.smartfarm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.retrix.smartfarm.domain.finanse.Wydatki;
import pl.retrix.smartfarm.services.MapValidationErrorService;
import pl.retrix.smartfarm.services.WydatkiService;

import javax.validation.Valid;

@RequestMapping("api/wydatki")
public class WydatkiController {

    @Autowired
    private WydatkiService wydatkiService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> dodajNoweWydatki(@Valid @RequestBody Wydatki wydatki, BindingResult result){
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidatonService(result);
        if(errorMap!= null) return errorMap;

        Wydatki wydatki1 = wydatkiService.saveOrUpdateWydatki(wydatki);

        return new ResponseEntity<Wydatki>(wydatki, HttpStatus.CREATED);
    }

    //Wyszukiwanie rekordu w bazie
    @GetMapping("/{tytul}")
    public ResponseEntity<?> getWydatkiByTytul(@PathVariable String tytul){

        Wydatki wydatki = wydatkiService.findWydatkiByTytul(tytul);

        return new ResponseEntity<Wydatki>(wydatki, HttpStatus.OK);
    }

    //Wyszukiwanie wszystkich rekordow w bazie
    @GetMapping("/all")
    public Iterable<Wydatki> getAllWydatki(){return wydatkiService.findAllWydatki();}

    //Usuwanie rekordu z bazy
    @DeleteMapping("/{tytul}")
    public ResponseEntity<?> deleteWydatki(@PathVariable String tytul){
        wydatkiService.deleteWydatkiByTytul(tytul);

        return new ResponseEntity<String>("Wpis " + tytul + " został usunięty z bazy danych", HttpStatus.OK);
    }
}
