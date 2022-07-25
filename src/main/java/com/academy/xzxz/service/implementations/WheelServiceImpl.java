package com.academy.xzxz.service.implementations;

import com.academy.xzxz.model.Wheel;
import com.academy.xzxz.repository.WheelRepository;
import com.academy.xzxz.service.dto.WheelDto;
import com.academy.xzxz.service.interfaces.WheelService;
import com.academy.xzxz.service.mappers.WheelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
@RequiredArgsConstructor
public class WheelServiceImpl implements WheelService {

    private final WheelMapper wheelMapper;
    private final WheelRepository wheelRepository;


    @Override
    public List<WheelDto> findAll() {
        return StreamSupport
                .stream(wheelRepository.findAll().spliterator(), false)
                .map(wheelMapper::toWheelDto)
                .sorted(Comparator.comparingInt(WheelDto::getId).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public WheelDto findById(Integer wheelId) {
        Wheel wheel = wheelRepository.findById(wheelId).orElse(null);
        return  wheelMapper.toWheelDto(wheel);
    }

    @Override
    public void updateWheel(WheelDto wheelDto) {
        wheelRepository.save(wheelMapper.toWheel(wheelDto));
        
    }

    @Override
    public void deleteById(Integer wheelId) {
        wheelRepository.deleteById(wheelId);
    }

    @Override
    public void createNewWheel(String radius, String type, double price) {
        WheelDto wheelDto = WheelDto.builder()
                .radius(radius)
                .type(type)
                .price(price)
                .build();
        wheelRepository.save(wheelMapper.toWheel(wheelDto));
    }
}
