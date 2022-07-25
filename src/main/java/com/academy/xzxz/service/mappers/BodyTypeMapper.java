package com.academy.xzxz.service.mappers;

import com.academy.xzxz.model.BodyType;
import com.academy.xzxz.service.dto.BodyTypeDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BodyTypeMapper {

    BodyTypeDto toBodyTypeDto(BodyType bodyType);
    BodyType toBodyType(BodyTypeDto bodyTypeDto);
}
