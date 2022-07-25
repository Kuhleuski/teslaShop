package com.academy.xzxz.repository;

import com.academy.xzxz.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
    User findByUsername(String name);
}
