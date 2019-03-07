package pl.retrix.smartfarm.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.retrix.smartfarm.domain.LacznyPlon;
import pl.retrix.smartfarm.services.LacznyPlonService;
import pl.retrix.smartfarm.services.MapValidationErrorService;

import javax.validation.Valid;

@RestController
@RequestMapping("api/lacznyplon")
public class LacznyPlonController {

    @Autowired
    private LacznyPlonService lacznyPlonService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> dodajNowyLacznyPlon(@Valid @RequestBody LacznyPlon lacznyPlon, BindingResult result){
        ResponseEntity<?> erroMap = mapValidationErrorService.MapValidatonService(result);
        if(erroMap!= null) return erroMap;

        LacznyPlon lacznyPlon1 = lacznyPlonService.saveOrUpdateLacznyPlon(lacznyPlon);

        return new ResponseEntity<LacznyPlon>(lacznyPlon, HttpStatus.CREATED);
    }
}