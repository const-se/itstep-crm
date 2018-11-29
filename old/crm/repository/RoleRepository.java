package org.itstep.crm.repository;

import jdk.internal.jline.internal.Nullable;
import org.itstep.crm.entity.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    @Query("SELECT r FROM Role r WHERE r.name = :name")
    @Nullable
    Role findOneByName(@Param("name") String name);
}
