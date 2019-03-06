package pl.retrix.smartfarm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
