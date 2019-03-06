package pl.retrix.smartfarm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.retrix.smartfarm.domain.Mleko;
import pl.retrix.smartfarm.services.MapValidationErrorService;
import pl.retrix.smartfarm.services.MlekoService;

import javax.validation.Valid;

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

}
