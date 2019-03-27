package pl.retrix.smartfarm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.retrix.smartfarm.domain.finanse.Pozyczki;
import pl.retrix.smartfarm.domain.finanse.Wyplaty;
import pl.retrix.smartfarm.exceptions.WyplatyTytulException;
import pl.retrix.smartfarm.repositories.WyplatyRepository;

@Service
public class WyplatyService {

    @Autowired
    private WyplatyRepository wyplatyRepository;

    public Wyplaty saveOrUpdateWyplaty(Wyplaty wyplaty){
        try{
            wyplaty.setTytul(wyplaty.getTytul().toUpperCase());
            return wyplatyRepository.save(wyplaty) ;
        }catch (Exception e){
            throw new WyplatyTytulException("Wpis " + wyplaty.getTytul().toUpperCase() + " już istnieje w bazie");
        }
    }

    public Wyplaty findWyplateByTytul(String tytul){
        Wyplaty wyplaty = wyplatyRepository.findByTytul(tytul);

        if(wyplaty == null){
            throw new WyplatyTytulException("Wpis " + tytul + " nie istnieje");
        }
        return wyplaty;
    }

    public Iterable<Wyplaty> findAllWyplaty(){return wyplatyRepository.findAll();}

    public void deleteWyplatyByTytul(String tytul){
        Wyplaty wyplaty = wyplatyRepository.findByTytul(tytul);
        if(wyplaty == null){
            throw new WyplatyTytulException("W bazie nie istnieje wpis o tytule " + tytul);
        }
        wyplatyRepository.delete(wyplaty);
    }
}
