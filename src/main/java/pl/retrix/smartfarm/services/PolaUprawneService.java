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

    public PolaUprawne findByNazwaPola(String nazwaPola){
        PolaUprawne polaUprawne = polaUprawneRepository.findByNazwaPola(nazwaPola);

        if(polaUprawne == null){
            throw new PolaUprawneException("Pole o nazwie " + nazwaPola + " istnieje już w bazie danych");
        }

        return polaUprawne;
    }

    public Iterable<PolaUprawne> findAll(){return polaUprawneRepository.findAll();}

    public void deletePoleByNazwaPola(String nazwaPola){
        PolaUprawne polaUprawne = polaUprawneRepository.findByNazwaPola(nazwaPola);

        if(polaUprawne == null){
            throw new PolaUprawneException("Pole " + nazwaPola + " nie istnieje");
        }
        polaUprawneRepository.delete(polaUprawne);
    }
}
