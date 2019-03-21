package pl.retrix.smartfarm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.retrix.smartfarm.domain.Mleko;
import pl.retrix.smartfarm.exceptions.MlekoDataOdbioruException;
import pl.retrix.smartfarm.exceptions.MlekoIloscException;
import pl.retrix.smartfarm.repositories.MlekoRepository;

import javax.xml.crypto.Data;
import java.util.Date;

@Service
public class MlekoService {

    @Autowired
    private MlekoRepository mlekoRepository;

    public Mleko saveOrUpdateMleko(Mleko mleko){
        try{
            return mlekoRepository.save(mleko);
        }catch(Exception e){
            throw new MlekoDataOdbioruException("Odbiór dla daty '" + mleko.getDataOdbioru() + "' został dodany! Możesz go edytować!");
        }
    }
    /*
    public Mleko findMlekoByNrOdbioru(Integer nrOdbioru){
        Mleko mleko = mlekoRepository.findByNrOdbioru(nrOdbioru);

        if(mleko == null){
            throw new MlekoDataOdbioruException("Odbiór nr " +)
        }
    }*/

    public Mleko findMlekoByDataOdbioru(Date dataOdbioru){

        Mleko mleko = mlekoRepository.findByDataOdbioru(dataOdbioru);

        if(mleko == null){
            throw new MlekoDataOdbioruException("Odbiór mleko z dnia " + dataOdbioru + " nie istnieje");
        }

        return mleko;
    }

    public Iterable<Mleko> findAllMleko() {return mlekoRepository.findAll();}

    public void deleteMlekoByDataOdbioru(Date dataOdbioru){
        Mleko mleko = mlekoRepository.findByDataOdbioru(dataOdbioru);

        if(mleko == null){
            throw new MlekoDataOdbioruException("W bazie nie istnieje odbior z dnia " + dataOdbioru);
        }

        mlekoRepository.delete(mleko);
    }
}
