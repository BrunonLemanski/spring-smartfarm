package pl.retrix.smartfarm.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.retrix.smartfarm.domain.finanse.Przychody;

@Repository
public interface PrzychodyRepository extends CrudRepository<Przychody, Long> {

    Przychody findByTytul (String tytul);

    @Override
    Iterable<Przychody> findAll();
}
