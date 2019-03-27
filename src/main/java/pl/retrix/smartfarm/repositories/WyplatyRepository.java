package pl.retrix.smartfarm.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.retrix.smartfarm.domain.finanse.Wyplaty;

@Repository
public interface WyplatyRepository extends CrudRepository<Wyplaty, Long> {

    Wyplaty findByTytul(String tytul);

    @Override
    Iterable<Wyplaty> findAll();
}
