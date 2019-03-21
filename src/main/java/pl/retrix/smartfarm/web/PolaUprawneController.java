package pl.retrix.smartfarm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.retrix.smartfarm.domain.PolaUprawne;
import pl.retrix.smartfarm.services.MapValidationErrorService;
import pl.retrix.smartfarm.services.PolaUprawneService;

import javax.validation.Valid;

@RestController
@RequestMapping("api/pola")
public class PolaUprawneController {

    @Autowired
    private PolaUprawneService polaUprawneService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> dodajNowePole(@Valid @RequestBody PolaUprawne pole, BindingResult result)
    {
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidatonService(result);
        if(errorMap!= null) return errorMap;

        PolaUprawne polaUprawne1 = polaUprawneService.saveOrUpdatePola(pole);

        return new ResponseEntity<PolaUprawne>(pole, HttpStatus.CREATED);
    }

    @GetMapping("/{nazwaPola}")
    private ResponseEntity<?> findPoleByNazwaPola(@PathVariable String nazwaPola){

        PolaUprawne polaUprawne = polaUprawneService.findByNazwaPola(nazwaPola);

        return new ResponseEntity<PolaUprawne>(polaUprawne, HttpStatus.OK);
    }

    @GetMapping("/all")
    public Iterable<PolaUprawne> getAllPola(){return polaUprawneService.findAll();}

    @DeleteMapping("/{nazwaPola}")
    public ResponseEntity<?> deletePole(@PathVariable String nazwaPola){
        polaUprawneService.deletePoleByNazwaPola(nazwaPola);

        return new ResponseEntity<String>("Pole " + nazwaPola + " zostało usunięte z bazy", HttpStatus.OK);
    }
}
