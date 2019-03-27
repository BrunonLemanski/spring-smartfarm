package pl.retrix.smartfarm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.retrix.smartfarm.domain.finanse.Zobowiazania;
import pl.retrix.smartfarm.services.MapValidationErrorService;
import pl.retrix.smartfarm.services.ZobowiazaniaService;

import javax.validation.Valid;

@RestController
@RequestMapping("api/zobowiazania")
public class ZobowiazaniaController {

    @Autowired
    private ZobowiazaniaService zobowiazaniaService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> dodajNoweZobowiazania(@Valid @RequestBody Zobowiazania zobowiazania, BindingResult result){
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidatonService(result);
        if(errorMap!= null) return errorMap;

        Zobowiazania zobowiazania1 = zobowiazaniaService.saveOrUpdateZobowiazania(zobowiazania);

        return new ResponseEntity<Zobowiazania>(zobowiazania, HttpStatus.CREATED);
    }

    //Wyszukiwanie rekordu w bazie
    @GetMapping("/{tytul}")
    public ResponseEntity<?> getZobowiazanieByTytul(@PathVariable String tytul){

        Zobowiazania zobowiazania = zobowiazaniaService.findZobowiazaniaByTytul(tytul);

        return new ResponseEntity<Zobowiazania>(zobowiazania, HttpStatus.OK);
    }

    //Wyszukiwanie wszystkich rekordow w bazie
    @GetMapping("/all")
    public Iterable<Zobowiazania> getAllZobowiazania(){return zobowiazaniaService.findAllZobowiazania();}

    //Usuwanie rekordu z bazy
    @DeleteMapping("/{tytul}")
    public ResponseEntity<?> deleteZobowiazania(@PathVariable String tytul){
        zobowiazaniaService.deleteZobowiazaniaByTytul(tytul);

        return new ResponseEntity<String>("Wpis  " + tytul+ " został usunięty z bazy danych", HttpStatus.OK);
    }
}
