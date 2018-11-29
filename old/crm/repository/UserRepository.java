package org.itstep.crm.repository;

import jdk.internal.jline.internal.Nullable;
import org.itstep.crm.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.username = :username")
    @Nullable
    User findOneByUsername(@Param("username") String username);
}
