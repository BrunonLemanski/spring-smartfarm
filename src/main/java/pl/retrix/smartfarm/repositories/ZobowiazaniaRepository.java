package pl.retrix.smartfarm.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.retrix.smartfarm.domain.finanse.Zobowiazania;

public interface ZobowiazaniaRepository extends CrudRepository<Zobowiazania, Long> {

    Zobowiazania findByTytul(String tytul);

    @Override
    Iterable<Zobowiazania> findAll();
}
