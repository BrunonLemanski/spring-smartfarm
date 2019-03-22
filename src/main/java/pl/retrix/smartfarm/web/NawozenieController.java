package pl.retrix.smartfarm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.retrix.smartfarm.domain.Nawozenie;
import pl.retrix.smartfarm.services.MapValidationErrorService;
import pl.retrix.smartfarm.services.NawozenieService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/nawozenie")
public class NawozenieController {

    @Autowired
    private NawozenieService nawozenieService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> dodajNoweNawozenie(@Valid @RequestBody Nawozenie nawozenie, BindingResult result)
    {
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidatonService(result);
        if(errorMap != null) return errorMap;

        Nawozenie nawozenie1 = nawozenieService.saveOrUpdateNawozenie(nawozenie);

        return new ResponseEntity<Nawozenie>(nawozenie, HttpStatus.CREATED);
    }

    @GetMapping("/{idNawozenia}")
    public ResponseEntity<?> findNawozenieByIdNawozenia(@PathVariable String idNawozenia){
        Nawozenie nawozenie = nawozenieService.findNawozenieByIdNawozenia(idNawozenia);

        return new ResponseEntity<Nawozenie>(nawozenie, HttpStatus.OK);
    }

    @GetMapping("/all")
    public Iterable<Nawozenie> getAllNawozenie(){return nawozenieService.findAllNawozenie();}

    @DeleteMapping("/{idNawozenia}")
    public ResponseEntity<?> deleteNawozenie(@PathVariable String idNawozenia){
        nawozenieService.deleteNawozenieByIdNawozenia(idNawozenia);

        return new ResponseEntity<String>("Wpis z kodem " + idNawozenia + " został usunięty", HttpStatus.OK);
    }
}
