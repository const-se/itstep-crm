package org.itstep.crm.repository;

import org.itstep.crm.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
