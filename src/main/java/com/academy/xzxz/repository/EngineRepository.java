package com.academy.xzxz.repository;

import com.academy.xzxz.model.Engine;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EngineRepository extends CrudRepository<Engine, Integer> {

    @Query("SELECT u FROM Engine u WHERE u.body.id = :bodyId")
    List<Engine> findAllEnginesForCurrentBody(@Param("bodyId") Integer bodyId);

}
