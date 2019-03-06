package pl.retrix.smartfarm.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.retrix.smartfarm.domain.Mleko;

@Repository
public interface MlekoRepository extends CrudRepository<Mleko, Long> {

    Mleko findByIloscMleko(String iloscMleko);


    @Override
    Iterable<Mleko> findAll();
}
