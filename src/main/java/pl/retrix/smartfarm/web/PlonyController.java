package pl.retrix.smartfarm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.retrix.smartfarm.domain.Plony;
import pl.retrix.smartfarm.services.MapValidationErrorService;
import pl.retrix.smartfarm.services.PlonyService;

import javax.validation.Valid;

@RestController
@RequestMapping("api/plony")
public class PlonyController {

    @Autowired
    private PlonyService plonyService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> dodajNowyPlon(@Valid @RequestBody Plony plon, BindingResult result){
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidatonService(result);
        if(errorMap!= null) return errorMap;

        Plony plony1 = plonyService.saveOrUpdatePlony(plon);

        return new ResponseEntity<Plony>(plon, HttpStatus.CREATED);
    }
}
