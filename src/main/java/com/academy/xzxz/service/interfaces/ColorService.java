package com.academy.xzxz.service.interfaces;

import com.academy.xzxz.service.dto.ColorDto;
import com.academy.xzxz.service.dto.WheelDto;

import java.util.List;

public interface ColorService {

    List<ColorDto> findAll();

    ColorDto findById(Integer colorId);

    void createNewColor(String name,double price);

    void deleteById(Integer colorId);

    void updateColor(ColorDto colorDto);
}
