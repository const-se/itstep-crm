package shop.repositroy;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import shop.entity.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

}
