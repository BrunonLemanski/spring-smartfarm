package pl.retrix.smartfarm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.retrix.smartfarm.domain.Inwentarz;
import pl.retrix.smartfarm.exceptions.InwentarzNrIdException;
import pl.retrix.smartfarm.exceptions.InwentarzNrIdExceptionResponse;
import pl.retrix.smartfarm.repositories.InwentarzRepository;

@Service
public class InwentarzService {

    @Autowired
    private InwentarzRepository inwentarzRepository;

    public Inwentarz saveOrUpdateInwentarz(Inwentarz inwentarz){
        try{
            inwentarz.setNrId(inwentarz.getNrId().toUpperCase());
            return inwentarzRepository.save(inwentarz);
        }catch (Exception e){
            throw new InwentarzNrIdException("Numer identyfikujący zwierzę '" + inwentarz.getNrId().toUpperCase() + "' istnieje już w bazie!");
        }
    }
}
