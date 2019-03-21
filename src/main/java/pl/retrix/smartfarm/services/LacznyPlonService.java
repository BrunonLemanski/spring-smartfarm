package pl.retrix.smartfarm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.retrix.smartfarm.domain.LacznyPlon;
import pl.retrix.smartfarm.exceptions.LacznyPlonTypUprawyException;
import pl.retrix.smartfarm.repositories.LacznyPlonRepository;

@Service
public class LacznyPlonService {

    @Autowired
    private LacznyPlonRepository lacznyPlonRepository;

    public LacznyPlon saveOrUpdateLacznyPlon(LacznyPlon lacznyPlon){
        try{
            lacznyPlon.setId(lacznyPlon.getId());
            return lacznyPlonRepository.save(lacznyPlon);
        }catch(Exception e){
            System.out.println("Coś poszło nie tak :(");
            throw e;
        }
    }

    public Iterable<LacznyPlon> findAll() { return lacznyPlonRepository.findAll();}

    public void deleteLacznyPlonByNazwa(Integer typUprawy){
        LacznyPlon lacznyPlon = lacznyPlonRepository.findByTypUprawy(typUprawy);

        if(lacznyPlon == null){
            throw new LacznyPlonTypUprawyException("Wpis typu " + typUprawy + " nie istnieje w bazie");
        }
        lacznyPlonRepository.delete(lacznyPlon);
    }
}
