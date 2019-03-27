package pl.retrix.smartfarm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.retrix.smartfarm.domain.finanse.Przychody;
import pl.retrix.smartfarm.exceptions.PrzychodyTytulException;
import pl.retrix.smartfarm.repositories.PrzychodyRepository;

@Service
public class PrzychodyService {

    @Autowired
    private PrzychodyRepository przychodyRepository;

    public Przychody saveOrUpdatePrzychody(Przychody przychody){
        try{
            przychody.setTytul(przychody.getTytul().toUpperCase());
            return przychodyRepository.save(przychody);
        }catch (Exception e){
            throw new PrzychodyTytulException("Wpis " + przychody.getTytul().toUpperCase() + " juz istnieje w bazie");
        }
    }

    public Przychody findPrzychodyByTytul(String tytul){
        Przychody przychody = przychodyRepository.findByTytul(tytul);

        if(przychody == null){
            throw new PrzychodyTytulException("Wpis " + tytul + " nie istnieje");
        }
        return przychody;
    }

    public Iterable<Przychody> findAllPrzychody(){return przychodyRepository.findAll();}

    public void deletePrzychodyByTytul(String tytul){
        Przychody przychody = przychodyRepository.findByTytul(tytul);
        if(przychody == null){
            throw new PrzychodyTytulException("W bazie nie istnieje wpis z id " + tytul);
        }
        przychodyRepository.delete(przychody);
    }
}
