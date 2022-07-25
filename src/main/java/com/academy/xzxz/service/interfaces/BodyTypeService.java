package com.academy.xzxz.service.interfaces;

import com.academy.xzxz.service.dto.BodyTypeDto;

import java.util.List;

public interface BodyTypeService {

    List<BodyTypeDto> findAll();

    BodyTypeDto findById(Integer bodyTypeId);

    void createNewBodyType(String name);

    void deleteById(Integer bodyTypeId);

    void updateBodyType(Integer id, String name);
}
