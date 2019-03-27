package pl.retrix.smartfarm.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.retrix.smartfarm.domain.finanse.Oszczednosci;

import java.util.Date;

@Repository
public interface OszczednosciRepository extends CrudRepository<Oszczednosci, Long> {

    Oszczednosci findById (String idOszczednosci);

    @Override
    Iterable<Oszczednosci> findAll();
}
