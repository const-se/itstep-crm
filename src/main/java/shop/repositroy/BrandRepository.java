package shop.repositroy;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import shop.entity.Brand;

@Repository
public interface BrandRepository extends CrudRepository<Brand, Long> {

}
