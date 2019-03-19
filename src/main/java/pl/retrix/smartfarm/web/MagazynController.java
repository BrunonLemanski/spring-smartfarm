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

    //Wyszukiwanie rekordu w bazie
    @GetMapping("/{nazwaTowaru}")
    public ResponseEntity<?> findMagazynByNazwaTowaru(@PathVariable String nazwaTowaru){

        Magazyn magazyn = magazynService.findByNazwaTowaru(nazwaTowaru);

        return new ResponseEntity<Magazyn>(magazyn, HttpStatus.OK);
    }

    //Wyszukiwanie wszystkich rekordów w bazie
    @GetMapping("/all")
    public Iterable<Magazyn> getAllMagazyn(){return magazynService.findAll();}

    @DeleteMapping("/{nazwaTowaru")
    public ResponseEntity<?> deleteMagazyn(@PathVariable String nazwaTowaru){
        magazynService.deleteMagazynByNazwa(nazwaTowaru);

        return new ResponseEntity<String>("Towar o nazwie " + nazwaTowaru + " został usunięty z bazy", HttpStatus.OK);
    }
}
