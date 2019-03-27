package pl.retrix.smartfarm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.retrix.smartfarm.domain.finanse.Pozyczki;
import pl.retrix.smartfarm.exceptions.PozyczkiTytulException;
import pl.retrix.smartfarm.repositories.PozyczkiRepository;

@Service
public class PozyczkiService {

    @Autowired
    private PozyczkiRepository pozyczkiRepository;

    public Pozyczki saveOrUpdatePozyczki(Pozyczki pozyczki){
        try{
            pozyczki.setTytul(pozyczki.getTytul().toUpperCase());
            return pozyczkiRepository.save(pozyczki);
        }catch (Exception e){
            throw new PozyczkiTytulException("Wpis " + pozyczki.getTytul().toUpperCase() + " już istnieje w bazie");
        }
    }

    public Pozyczki findPozyczkiByTytul(String tytul){
        Pozyczki pozyczki = pozyczkiRepository.findByTytul(tytul);

        if(pozyczki == null){
            throw new PozyczkiTytulException("Wpis " + tytul + " nie istnieje w bazie");
        }
        return pozyczki;
    }

    public Iterable<Pozyczki> findAllPozyczki(){return pozyczkiRepository.findAll();}

    public void deletePozyczkiByTytul(String tytul){
        Pozyczki pozyczki = pozyczkiRepository.findByTytul(tytul);

        if(pozyczki == null){
            throw new PozyczkiTytulException("W bazie nie istnieje wpis o tytule " + tytul);
        }
        pozyczkiRepository.delete(pozyczki);
    }
}
