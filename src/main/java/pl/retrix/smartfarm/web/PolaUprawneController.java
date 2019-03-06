package pl.retrix.smartfarm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
