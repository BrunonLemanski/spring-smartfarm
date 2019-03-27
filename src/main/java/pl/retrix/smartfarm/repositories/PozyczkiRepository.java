package pl.retrix.smartfarm.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.core.CrudMethods;
import org.springframework.stereotype.Repository;
import pl.retrix.smartfarm.domain.finanse.Oszczednosci;
import pl.retrix.smartfarm.domain.finanse.Pozyczki;

@Repository
public interface PozyczkiRepository extends CrudRepository<Pozyczki, Long> {

    Pozyczki findByTytul(String tytul);

    @Override
    Iterable<Pozyczki> findAll();
}
