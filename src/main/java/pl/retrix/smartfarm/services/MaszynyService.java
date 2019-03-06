package pl.retrix.smartfarm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.retrix.smartfarm.domain.Maszyny;
import pl.retrix.smartfarm.exceptions.MaszynyNazwaException;
import pl.retrix.smartfarm.repositories.MaszynyRepository;

@Service
public class MaszynyService {

    @Autowired
    private MaszynyRepository maszynyRepository;

    public Maszyny saveOrUpdateMaszyny(Maszyny maszyny){
        try{
            maszyny.setNazwaMaszyny(maszyny.getNazwaMaszyny().toUpperCase());
            return maszynyRepository.save(maszyny);
        }catch(Exception e){
            throw new MaszynyNazwaException("Maszyna '" + maszyny.getNazwaMaszyny().toUpperCase() + "' została już dodana do bazy");
        }
    }
}
