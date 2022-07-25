package com.academy.xzxz.service.mappers;

import com.academy.xzxz.model.Color;
import com.academy.xzxz.service.dto.ColorDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ColorMapper {

    ColorDto toColorDto(Color color);
    Color toColor(ColorDto colorDto);
}
