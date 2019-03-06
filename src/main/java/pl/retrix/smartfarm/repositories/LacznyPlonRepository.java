package pl.retrix.smartfarm.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.retrix.smartfarm.domain.LacznyPlon;

@Repository
public interface LacznyPlonRepository extends CrudRepository<LacznyPlon, Long> {

    @Override
    Iterable<LacznyPlon> findAll();
}
