package pl.retrix.smartfarm.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.retrix.smartfarm.domain.Mleko;

import java.util.Date;

@Repository
public interface MlekoRepository extends CrudRepository<Mleko, Long> {

    Mleko findByDataOdbioru (Date dataOdbioru);

    Mleko findByNrOdbioru (Integer nrOdbioru);

    @Override
    Iterable<Mleko> findAll();
}
