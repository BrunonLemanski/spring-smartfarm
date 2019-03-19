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

    public Maszyny findMaszynaByNazwaMaszyny(String nazwaMaszyny){

        Maszyny maszyny= maszynyRepository.findByNazwaMaszyny(nazwaMaszyny);

        if(maszyny == null){
            throw new MaszynyNazwaException("Maszyna " + nazwaMaszyny + " nie istnieje w bazie");
        }

        return maszyny;
    }

    public Iterable<Maszyny> findAllMaszyny(){
        return maszynyRepository.findAll();
    }

    public void deleteMaszynaByNazwaMaszyny(String nazwaMaszyny){
        Maszyny maszyny = maszynyRepository.findByNazwaMaszyny(nazwaMaszyny);

        if(maszyny == null){
            throw new MaszynyNazwaException("W bazie nie istnieje maszyna o nazwie" + nazwaMaszyny);
        }

        maszynyRepository.delete(maszyny);
    }

    //Update - Aby zaktualizować wpis należy podać w formularzu id aktualizowanego wpisu
}
