package com.academy.xzxz.service.mappers;

import com.academy.xzxz.model.Deal;
import com.academy.xzxz.service.dto.DealDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DealMapper {

    DealDto toDealDto(Deal deal);
    Deal toDeal(DealDto dalDto);
}
