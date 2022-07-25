package com.academy.xzxz.service.interfaces;

import com.academy.xzxz.service.dto.WheelDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WheelService {

    List<WheelDto> findAll();

    WheelDto findById(Integer wheelId);

    void createNewWheel(String radius, String type, double price);

    void updateWheel(WheelDto wheelDto);

    void deleteById(Integer wheelId);

//    List<WheelDto> findAll(HorseFilter filter);
}
