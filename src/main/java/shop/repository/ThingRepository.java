package shop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import shop.entity.Thing;

@Repository
public interface ThingRepository extends CrudRepository<Thing, Long> {
}
