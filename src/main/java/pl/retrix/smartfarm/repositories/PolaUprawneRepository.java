package pl.retrix.smartfarm.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.retrix.smartfarm.domain.PolaUprawne;

@Repository
public interface PolaUprawneRepository extends CrudRepository<PolaUprawne, Long> {

    PolaUprawne findByNazwaPola(String nazwaPola);

    @Override
    Iterable<PolaUprawne> findAll();
}
