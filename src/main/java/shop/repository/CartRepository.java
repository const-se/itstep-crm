package shop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.smartcardio.Card;

@Repository
public interface CartRepository extends CrudRepository<Card, Long> {
}
