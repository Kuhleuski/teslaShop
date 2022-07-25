package com.academy.xzxz.repository;

import com.academy.xzxz.model.Wheel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WheelRepository extends CrudRepository<Wheel, Integer> {
}
