package org.itstep.crm.repository;

import org.itstep.crm.entity.Brand;
import org.itstep.crm.entity.Car;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {
    @Query("SELECT c FROM Car c WHERE c.brand = :brand")
    Iterable<Car> findAllByBrand(@Param("brand") Brand brand);
}
