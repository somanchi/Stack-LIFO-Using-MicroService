package sp.sample.simpleCurd.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import sp.sample.simpleCurd.dao.DataObject;

@Repository
public interface DataAccessCurdRepository extends CrudRepository<DataObject, Integer> {

    DataObject findTop1ByOrderByIdDesc();
}
