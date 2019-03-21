package pl.retrix.smartfarm.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.retrix.smartfarm.domain.Plony;

@Repository
public interface PlonyRepository extends CrudRepository<Plony, Long> {

    Plony findByIdUprawy (String idUprawy);

    @Override
    Iterable<Plony> findAll();
}
