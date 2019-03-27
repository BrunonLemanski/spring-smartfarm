package pl.retrix.smartfarm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.retrix.smartfarm.domain.Nawozenie;
import pl.retrix.smartfarm.exceptions.NawozenieIdNawozeniaException;
import pl.retrix.smartfarm.repositories.NawozenieRepository;

@Service
public class NawozenieService {

    @Autowired
    private NawozenieRepository nawozenieRepository;

    public Nawozenie saveOrUpdateNawozenie(Nawozenie nawozenie){
        try{
            nawozenie.setIdNawozenia(nawozenie.getIdNawozenia().toUpperCase());
            return nawozenieRepository.save(nawozenie);
        }catch (Exception e){
            throw new NawozenieIdNawozeniaException("Wpis " + nawozenie.getIdNawozenia().toUpperCase() + " juz istnieje w bazie");
        }
    }

    public Nawozenie findNawozenieByIdNawozenia(String idNawozenia){
        Nawozenie nawozenie = nawozenieRepository.findByIdNawozenia(idNawozenia);

        if(nawozenie == null){
            throw new NawozenieIdNawozeniaException("Wpis " + idNawozenia + " nie istnieje");
        }
        return nawozenie;
    }

    public Iterable<Nawozenie> findAllNawozenie(){return nawozenieRepository.findAll();}

    public void deleteNawozenieByIdNawozenia(String idNawozenia){
        Nawozenie nawozenie = nawozenieRepository.findByIdNawozenia(idNawozenia);
         if(nawozenie == null){
             throw new NawozenieIdNawozeniaException("W bazie nie istnieje wpis z id " + idNawozenia);
         }
         nawozenieRepository.delete(nawozenie);
    }
}
