package pl.retrix.smartfarm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.retrix.smartfarm.domain.Plony;
import pl.retrix.smartfarm.repositories.PlonyRepository;

@Service
public class PlonyService {

    @Autowired
    private PlonyRepository plonyRepository;

    public Plony saveOrUpdatePlony(Plony plon){
            return plonyRepository.save(plon);
            //TODO: napisac metode ktora pozwoli na sprawdzenie czy istnieje wystarczajaca ilosc powierzchni do uprawy
    }
}
