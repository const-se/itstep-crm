package shop.repository;

import org.springframework.data.jpa.repository.Query;
        import org.springframework.data.repository.CrudRepository;
        import org.springframework.data.repository.query.Param;
        import org.springframework.stereotype.Repository;
        import shop.entity.Brand;
        import shop.entity.Cart;
        import shop.entity.Thing;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long> {
    @Query("SELECT t FROM Thing t WHERE t.brand = :b")
    Iterable<Thing> findAllByCart(@Param("b") Brand brand);

}
