package shop.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import shop.entity.Brand;
import shop.entity.Category;
import shop.entity.Thing;

@Repository
public interface ThingRepository extends CrudRepository<Thing, Long> {
    @Query("SELECT t FROM Thing t WHERE t.brand = :b")
    Iterable<Thing> findAllByBrand(@Param("b") Brand brand);

    @Query("SELECT t FROM Thing t WHERE t.category = :c")
    Iterable<Thing> findAllByCategory(@Param("c")Category category);
}
