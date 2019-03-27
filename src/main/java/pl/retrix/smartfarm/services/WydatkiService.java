package pl.retrix.smartfarm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.retrix.smartfarm.domain.finanse.Wydatki;
import pl.retrix.smartfarm.exceptions.WydatkiTytulException;
import pl.retrix.smartfarm.repositories.WydatkiRepository;

@Service
public class WydatkiService {

    @Autowired
    private WydatkiRepository wydatkiRepository;

    public Wydatki saveOrUpdateWydatki(Wydatki wydatki){
        try{
            wydatki.setTytul(wydatki.getTytul().toUpperCase());
            return wydatkiRepository.save(wydatki);
        }catch (Exception e){
            throw new WydatkiTytulException("Wpis " + wydatki.getTytul().toUpperCase() + " juz istnieje w bazie");
        }
    }

    public Wydatki findWydatkiByTytul(String tytul){
        Wydatki wydatki = wydatkiRepository.findByTytul(tytul);

        if(wydatki == null){
            throw new WydatkiTytulException("Wpis " + tytul + " nie istnieje");
        }
        return wydatki;
    }

    public Iterable<Wydatki> findAllWydatki(){return wydatkiRepository.findAll();}

    public void deleteWydatkiByTytul(String tytul){
        Wydatki wydatki = wydatkiRepository.findByTytul(tytul);
        if(wydatki == null){
            throw new WydatkiTytulException("W bazie nie istnieje wpis z id " + tytul);
        }
        wydatkiRepository.delete(wydatki);
    }
}
