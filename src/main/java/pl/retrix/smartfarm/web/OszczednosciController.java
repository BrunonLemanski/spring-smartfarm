package pl.retrix.smartfarm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.retrix.smartfarm.domain.finanse.Oszczednosci;
import pl.retrix.smartfarm.services.MapValidationErrorService;
import pl.retrix.smartfarm.services.OszczednosciService;

import javax.validation.Valid;

@RestController
@RequestMapping("api/oszczednosci")
public class OszczednosciController {

    @Autowired
    private OszczednosciService oszczednosciService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> dodajNoweOszczednosci(@Valid @RequestBody Oszczednosci oszczednosci, BindingResult result){
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidatonService(result);
        if(errorMap != null) return errorMap;

        Oszczednosci oszczednosci1 = oszczednosciService.saveOrUpdateOszczednosci(oszczednosci);

        return new ResponseEntity<Oszczednosci>(oszczednosci, HttpStatus.CREATED);
    }

    //Wyszukiwanie rekordu w bazie
    @GetMapping("/{idOszczednosci}")
    public ResponseEntity<?> getOszczednosciByIdOszczednosci(@PathVariable String idOszczednosci){

        Oszczednosci oszczednosci = oszczednosciService.findOszczednosciByIdOszczednosci(idOszczednosci);

        return new ResponseEntity<Oszczednosci>(oszczednosci, HttpStatus.OK);
    }

    //Wyszukiwanie wszystkich rekordow w bazie
    @GetMapping("/all")
    public Iterable<Oszczednosci> getAllOszczednosci(){return oszczednosciService.findAllOszczednosci();}

    //Usuwanie rekordu z bazy
    @DeleteMapping("/{idOszczednosci}")
    public ResponseEntity<?> deleteOszczednosci(@PathVariable String idOszczednosci){
        oszczednosciService.deleteOszczednosciByIdOszczednosci(idOszczednosci);

        return new ResponseEntity<String>("Wpis  " + idOszczednosci + " został usunięty z bazy danych", HttpStatus.OK);
    }
}