package com.academy.xzxz.service.interfaces;

import com.academy.xzxz.service.dto.BodyDto;
import com.academy.xzxz.service.dto.WheelDto;

import java.util.List;

public interface BodyService {
    List<BodyDto> findAll();

    BodyDto findById(Integer bodyId);

    void createNewBody(String name, String type, int numberOfSeats, double weight,
                       double width, double height, double length,
                       int trunk, double wheelBase, double price);

    void deleteById(Integer bodyId);

    void updateBody(BodyDto bodyDto);
}
