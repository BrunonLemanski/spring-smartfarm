package pl.retrix.smartfarm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/{idUprawy}")
    public ResponseEntity<?> findPlonByIdUprawy(@PathVariable String idUprawy){
        Plony plony = plonyService.findByIdUprawy(idUprawy);

        return new ResponseEntity<Plony>(plony, HttpStatus.OK);
    }

    @GetMapping("/all")
    public Iterable<Plony> getAllPlony(){return plonyService.findAll();}

    @DeleteMapping("/{idUprawy}")
    public ResponseEntity<?> deletePlony(@PathVariable String idUprawy){
        plonyService.deletePlonyByIdUprawy(idUprawy);

        return new ResponseEntity<String>("Uprawa " + idUprawy + " została usunięta z bazy danych", HttpStatus.OK);
    }
}
