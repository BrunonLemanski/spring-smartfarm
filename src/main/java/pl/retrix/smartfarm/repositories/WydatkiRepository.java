package pl.retrix.smartfarm.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.retrix.smartfarm.domain.finanse.Wydatki;

public interface WydatkiRepository extends CrudRepository<Wydatki, Long> {

    Wydatki findByTytul (String tytul);

    @Override
    Iterable<Wydatki> findAll();
}
