package pl.retrix.smartfarm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.retrix.smartfarm.domain.finanse.Zobowiazania;
import pl.retrix.smartfarm.exceptions.ZobowiazaniaTytulException;
import pl.retrix.smartfarm.repositories.ZobowiazaniaRepository;

@Service
public class ZobowiazaniaService {

    @Autowired
    private ZobowiazaniaRepository zobowiazaniaRepository;

    public Zobowiazania saveOrUpdateZobowiazania(Zobowiazania zobowiazania){
        try{
            zobowiazania.setTytul(zobowiazania.getTytul().toUpperCase());
            return zobowiazaniaRepository.save(zobowiazania);
        }catch (Exception e){
            throw new ZobowiazaniaTytulException("Wpis " + zobowiazania.getTytul().toUpperCase() + " juz istnieje w bazie");
        }
    }

    public Zobowiazania findZobowiazaniaByTytul(String tytul){
        Zobowiazania zobowiazania = zobowiazaniaRepository.findByTytul(tytul);

        if(zobowiazania == null){
            throw new ZobowiazaniaTytulException("Wpis " + tytul + " nie istnieje");
        }
        return zobowiazania;
    }

    public Iterable<Zobowiazania> findAllZobowiazania(){return zobowiazaniaRepository.findAll();}

    public void deleteZobowiazaniaByTytul(String tytul){
        Zobowiazania zobowiazania = zobowiazaniaRepository.findByTytul(tytul);
        if(zobowiazania == null){
            throw new ZobowiazaniaTytulException("W bazie nie istnieje wpis z id " + tytul);
        }
        zobowiazaniaRepository.delete(zobowiazania);
    }
}
