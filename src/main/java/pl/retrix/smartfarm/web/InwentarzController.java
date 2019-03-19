package pl.retrix.smartfarm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.retrix.smartfarm.domain.Inwentarz;
import pl.retrix.smartfarm.services.InwentarzService;
import pl.retrix.smartfarm.services.MapValidationErrorService;

import javax.validation.Valid;

@RestController
@RequestMapping("api/inwentarz")
public class InwentarzController {

    @Autowired
    private InwentarzService inwentarzService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> dodajNoweZwierze(@Valid @RequestBody Inwentarz inwentarz, BindingResult result){
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidatonService(result);
        if(errorMap!= null) return errorMap;

        Inwentarz inwentarz1 = inwentarzService.saveOrUpdateInwentarz(inwentarz);

        return new ResponseEntity<Inwentarz>(inwentarz, HttpStatus.CREATED);
    }

    //Wyszukiwanie rekordu w bazie
    @GetMapping("/{nrId}")
    public ResponseEntity<?> getBydloByNrId(@PathVariable String nrId){

        Inwentarz inwentarz = inwentarzService.findBydloByNrId(nrId);

        return new ResponseEntity<Inwentarz>(inwentarz, HttpStatus.OK);
    }

    //Wyszukiwanie wszystkich rekordow w bazie
    @GetMapping("/all")
    public Iterable<Inwentarz> getAllInwentarz(){return inwentarzService.findAllInwentarz();}

    //Usuwanie rekordu z bazy
    @DeleteMapping("/{nrId}")
    public ResponseEntity<?> deleteInwentarz(@PathVariable String nrId){
        inwentarzService.deleteInwentarzByNrId(nrId);

        return new ResponseEntity<String>("Krowa o numerze kolczyka " + nrId + " została usunięta z bazy", HttpStatus.OK);
    }
}