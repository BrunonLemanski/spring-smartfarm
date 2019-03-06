package pl.retrix.smartfarm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.retrix.smartfarm.domain.Mleko;
import pl.retrix.smartfarm.exceptions.MlekoIloscException;
import pl.retrix.smartfarm.repositories.MlekoRepository;

@Service
public class MlekoService {

    @Autowired
    private MlekoRepository mlekoRepository;

    public Mleko saveOrUpdateMleko(Mleko mleko){
        try{
            mleko.setIloscMleko(mleko.getIloscMleko());
            return mlekoRepository.save(mleko);
        }catch(Exception e){
            throw new MlekoIloscException("Odbiór dla daty '" + mleko.getIloscMleko() + "' został dodany! Możesz go edytować!");
        }
    }
}
