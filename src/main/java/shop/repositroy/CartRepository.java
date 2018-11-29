package shop.repositroy;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import shop.entity.Cart;

@Repository
public interface CartRepository extends CrudRepository<Cart,Long> {

}
