package pl.retrix.smartfarm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.retrix.smartfarm.domain.Maszyny;
import pl.retrix.smartfarm.services.MapValidationErrorService;
import pl.retrix.smartfarm.services.MaszynyService;

import javax.validation.Valid;

@RestController
@RequestMapping("api/maszyny")
public class MaszynyController {

    @Autowired
    private MaszynyService maszynyService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> dodajNowaMaszyne(@Valid @RequestBody Maszyny maszyny, BindingResult result){
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidatonService(result);
        if(errorMap!=null) return errorMap;

        Maszyny maszyny1 = maszynyService.saveOrUpdateMaszyny(maszyny);

        return new ResponseEntity<Maszyny>(maszyny, HttpStatus.CREATED);
    }

    //Wyszukiwanie rekordu w bazie
    @GetMapping("/{nazwaMaszyny}")
    public ResponseEntity<?> getMaszynaByNazwaMaszyny(@PathVariable String nazwaMaszyny){

        Maszyny maszyna = maszynyService.findMaszynaByNazwaMaszyny(nazwaMaszyny);

        return new ResponseEntity<Maszyny>(maszyna, HttpStatus.OK);
    }

    //Wyszukiwanie wszystkich rekordow w bazie
    @GetMapping("/all")
    public Iterable<Maszyny> getAllMaszyny(){return maszynyService.findAllMaszyny();}

    //Usuwanie rekordu z bazy
    @DeleteMapping("/{nazwaMaszyny}")
    public ResponseEntity<?> deleteMaszyny(@PathVariable String nazwaMaszyny){
        maszynyService.deleteMaszynaByNazwaMaszyny(nazwaMaszyny);

        return new ResponseEntity<String>("Maszyna " + nazwaMaszyny + " została usunięta z bazy", HttpStatus.OK);
    }
}
