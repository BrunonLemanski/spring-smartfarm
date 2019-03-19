package pl.retrix.smartfarm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.retrix.smartfarm.domain.Mleko;
import pl.retrix.smartfarm.exceptions.MlekoDataOdbioruException;
import pl.retrix.smartfarm.services.MapValidationErrorService;
import pl.retrix.smartfarm.services.MlekoService;

import javax.validation.Valid;
import java.util.Date;

@RestController
@RequestMapping("api/mleko")
public class MlekoController {

    @Autowired
    private MlekoService mlekoService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> dodajNowyOdbior(@Valid @RequestBody Mleko mleko, BindingResult result){
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidatonService(result);
        if(errorMap!=null) return errorMap;

        Mleko mleko1 = mlekoService.saveOrUpdateMleko(mleko);

        return new ResponseEntity<Mleko>(mleko, HttpStatus.CREATED);
    }

    @GetMapping("/{dataOdbioru")
    public ResponseEntity<?> getOdbiorByDataOdbioru(@PathVariable Date dataOdbioru){
        Mleko mleko = mlekoService.findMlekoByDataOdbioru(dataOdbioru);

        return new ResponseEntity<Mleko>(mleko, HttpStatus.OK);
    }

    @GetMapping("/all")
    public Iterable<Mleko> getAllMleko(){return mlekoService.findAllMleko();}

    @DeleteMapping("/{dataOdbioru")
    public ResponseEntity<?> deleteMleko(@PathVariable Date dataOdbioru){
        mlekoService.deleteMlekoByDataOdbioru(dataOdbioru);

        return new ResponseEntity<String>("Odbiór z dnia " + dataOdbioru + " został usunięty", HttpStatus.OK);
    }

}
