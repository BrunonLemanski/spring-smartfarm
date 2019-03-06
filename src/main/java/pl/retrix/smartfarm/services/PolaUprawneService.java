package pl.retrix.smartfarm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.retrix.smartfarm.domain.PolaUprawne;
import pl.retrix.smartfarm.exceptions.PolaUprawneException;
import pl.retrix.smartfarm.exceptions.PolaUprawneExceptionResponse;
import pl.retrix.smartfarm.repositories.PolaUprawneRepository;

@Service
public class PolaUprawneService {

    @Autowired
    private PolaUprawneRepository polaUprawneRepository;

    public PolaUprawne saveOrUpdatePola(PolaUprawne pole)
    {
        try{
            pole.setNazwaPola(pole.getNazwaPola().toUpperCase());
            return polaUprawneRepository.save(pole);
        }catch (Exception e){
            throw new PolaUprawneException("Pole '" + pole.getNazwaPola().toUpperCase() + "' istnieje już w bazie! Możesz je zaktualizować!");
        }
    }
}
