package pl.retrix.smartfarm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.retrix.smartfarm.domain.Plony;
import pl.retrix.smartfarm.exceptions.PlonyIdUprawyException;
import pl.retrix.smartfarm.repositories.PlonyRepository;

@Service
public class PlonyService {

    @Autowired
    private PlonyRepository plonyRepository;

    public Plony saveOrUpdatePlony(Plony plon){
        try{
            plon.setIdUprawy(plon.getIdUprawy().toUpperCase());
            return plonyRepository.save(plon);
        }catch (Exception e){
            throw new PlonyIdUprawyException("Uprawa z id " + plon.getIdUprawy().toUpperCase() + " istnieje");
        }

            //TODO: napisac metode ktora pozwoli na sprawdzenie czy istnieje wystarczajaca ilosc powierzchni do uprawy
    }

    //Wyszukiwanie po id
    public Plony findByIdUprawy(String idUprawy){
        Plony plony = plonyRepository.findByIdUprawy(idUprawy);

        if(plony == null){
            throw new PlonyIdUprawyException("Uprawa z id " + idUprawy + " nie istnieje");
        }
        return plony;
    }

    //Wyszukiwanie wszystkich wpisow
    public Iterable<Plony> findAll(){return plonyRepository.findAll();}

    //Usuwanie wpisow
    public void deletePlonyByIdUprawy(String idUprawy){
        Plony plony = plonyRepository.findByIdUprawy(idUprawy);

        if(plony == null){
            throw new PlonyIdUprawyException("Uprawa z id " + idUprawy + " nie istnieje");
        }
        plonyRepository.delete(plony);
    }


}
