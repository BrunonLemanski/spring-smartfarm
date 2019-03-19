package pl.retrix.smartfarm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.retrix.smartfarm.domain.Magazyn;
import pl.retrix.smartfarm.exceptions.MagazynNazwaException;
import pl.retrix.smartfarm.repositories.MagazynRepository;

@Service
public class MagazynService {

    @Autowired
    private MagazynRepository magazynRepository;

    public Magazyn saveOrUpdateMagazyn(Magazyn magazyn){
        try{
            magazyn.setNazwaTowaru(magazyn.getNazwaTowaru().toUpperCase());
            return magazynRepository.save(magazyn);
        }catch(Exception e){
            throw new MagazynNazwaException("Towar '" + magazyn.getNazwaTowaru().toUpperCase() + "' istnieje już w bazie! Możesz go zaktualizować");
        }
    }

    public Magazyn findByNazwaTowaru(String nazwaTowaru){
        Magazyn magazyn = magazynRepository.findByNazwaTowaru(nazwaTowaru);

        if(magazyn == null){
            throw new MagazynNazwaException("Towar o nazwie " + nazwaTowaru + " nie istnieje");
        }

        return magazyn;
    }

    public Iterable<Magazyn> findAll(){
        return magazynRepository.findAll();
    }

    public void deleteMagazynByNazwa(String nazwaTowaru){
        Magazyn magazyn = magazynRepository.findByNazwaTowaru(nazwaTowaru);

        if(magazyn == null){
            throw new MagazynNazwaException("Towar o nazwie " + nazwaTowaru + " nie istnieje");
        }
        magazynRepository.delete(magazyn);
    }
}
