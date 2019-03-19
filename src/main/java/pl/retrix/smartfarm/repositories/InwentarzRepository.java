package pl.retrix.smartfarm.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.retrix.smartfarm.domain.Inwentarz;

@Repository
public interface InwentarzRepository extends CrudRepository<Inwentarz, Long> {

    Inwentarz findByNrId (String nrId);

    @Override
    Iterable<Inwentarz> findAll();
}
