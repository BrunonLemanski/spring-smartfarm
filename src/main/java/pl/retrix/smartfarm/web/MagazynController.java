package pl.retrix.smartfarm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.retrix.smartfarm.domain.Magazyn;
import pl.retrix.smartfarm.services.MagazynService;
import pl.retrix.smartfarm.services.MapValidationErrorService;

import javax.validation.Valid;

@RestController
@RequestMapping("api/magazyn")
public class MagazynController {

    @Autowired
    private MagazynService magazynService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> dodajNowyTowar(@Valid @RequestBody Magazyn magazyn, BindingResult result)
    {
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidatonService(result);
        if(errorMap!=null) return errorMap;

        Magazyn magazyn1 = magazynService.saveOrUpdateMagazyn(magazyn);

        return new ResponseEntity<Magazyn>(magazyn, HttpStatus.CREATED);
    }
}
