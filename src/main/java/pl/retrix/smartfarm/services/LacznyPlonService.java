package pl.retrix.smartfarm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.retrix.smartfarm.domain.LacznyPlon;
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
}
