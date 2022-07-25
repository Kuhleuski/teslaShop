package com.academy.xzxz.repository;


import com.academy.xzxz.model.Equipment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EquipmentRepository extends CrudRepository<Equipment, Integer> {

    @Query("SELECT u FROM Equipment u WHERE u.body.id = :bodyId")
    List<Equipment> findAllEnginesForCurrentBody(@Param("bodyId") Integer bodyId);
}
