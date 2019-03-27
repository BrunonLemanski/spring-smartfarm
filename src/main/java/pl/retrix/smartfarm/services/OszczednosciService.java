package pl.retrix.smartfarm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.retrix.smartfarm.domain.finanse.Oszczednosci;
import pl.retrix.smartfarm.exceptions.OszczednosciIdException;
import pl.retrix.smartfarm.repositories.OszczednosciRepository;

@Service
public class OszczednosciService {

    @Autowired
    private OszczednosciRepository oszczednosciRepository;

    public Oszczednosci saveOrUpdateOszczednosci(Oszczednosci oszczednosci){
        try{
            oszczednosci.setIdOszczednosci(oszczednosci.getIdOszczednosci().toUpperCase());
            return oszczednosciRepository.save(oszczednosci);
        }catch (Exception e){
            throw new OszczednosciIdException("Wpis " + oszczednosci.getIdOszczednosci().toUpperCase() + " już istnieje w bazie");
        }
    }

    public Oszczednosci findOszczednosciByIdOszczednosci(String idOszczednosci){
        Oszczednosci oszczednosci = oszczednosciRepository.findById(idOszczednosci);

        if(oszczednosci == null){
            throw new OszczednosciIdException("Wpis " + idOszczednosci + " nie istnieje w bazie");
        }
        return oszczednosci;
    }

    public Iterable<Oszczednosci> findAllOszczednosci(){return oszczednosciRepository.findAll();}

    public void deleteOszczednosciByIdOszczednosci(String idOszczednosci){
        Oszczednosci oszczednosci = oszczednosciRepository.findById(idOszczednosci);

        if(oszczednosci == null){
            throw new OszczednosciIdException("W bazie nie istnieje wpis z id " + idOszczednosci);
        }
        oszczednosciRepository.delete(oszczednosci);
    }
}
