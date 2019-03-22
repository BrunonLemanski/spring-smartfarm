package pl.retrix.smartfarm.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.retrix.smartfarm.domain.Nawozenie;

@Repository
public interface NawozenieRepository extends CrudRepository<Nawozenie,Long> {

    Nawozenie findByIdNawozenia (String idNawozenia);

    @Override
    Iterable<Nawozenie> findAll();
}
