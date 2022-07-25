package com.academy.xzxz.service.mappers;

import com.academy.xzxz.model.Engine;
import com.academy.xzxz.service.dto.EngineDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EngineMapper {

    EngineDto toEngineDto(Engine engine);
    Engine toEngine(EngineDto engineDto);
}
