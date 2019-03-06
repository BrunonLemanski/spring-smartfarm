package pl.retrix.smartfarm.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.retrix.smartfarm.domain.Maszyny;

@Repository
public interface MaszynyRepository extends CrudRepository<Maszyny, Long> {

    Maszyny findByNazwaMaszyny(String nazwaMaszyny);

    @Override
    Iterable<Maszyny> findAll();
}
