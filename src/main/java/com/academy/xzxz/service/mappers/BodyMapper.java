package com.academy.xzxz.service.mappers;

import com.academy.xzxz.model.Body;
import com.academy.xzxz.service.dto.BodyDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BodyMapper {

    BodyDto toBodyDto(Body body);
    Body toBody(BodyDto bodyDto);
}
