package pl.retrix.smartfarm.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.retrix.smartfarm.domain.Magazyn;

@Repository
public interface MagazynRepository extends CrudRepository<Magazyn, Long> {

    Magazyn findByNazwaTowaru(String nazwaTowaru);

    @Override
    Iterable<Magazyn> findAll();
}
