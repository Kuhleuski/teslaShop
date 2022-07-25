package com.academy.xzxz.service.implementations;

import com.academy.xzxz.model.Battery;
import com.academy.xzxz.model.ComponentStatus;
import com.academy.xzxz.repository.BatteryRepository;
import com.academy.xzxz.service.dto.BatteryDto;
import com.academy.xzxz.service.interfaces.BatteryService;
import com.academy.xzxz.service.mappers.BatteryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class BatteryServiceImpl implements BatteryService {

    private final BatteryRepository batteryRepository;
    private final BatteryMapper batteryMapper;



    @Override
    public List<BatteryDto> findAll() {
        return StreamSupport
                .stream(batteryRepository.findAll().spliterator(), false)
                .map(batteryMapper::toBatteryDto)
                .sorted(Comparator.comparingInt(BatteryDto::getId).reversed())
                .collect(Collectors.toList());
    }




    @Override
    public BatteryDto findById(Integer batteryId) {
        Battery battery = batteryRepository.findById(batteryId).orElse(null);
        return  batteryMapper.toBatteryDto(battery);
    }

    @Override
    public void createNewBattery(String capacity, int reserve, boolean status, double price) {
        BatteryDto batteryDto = BatteryDto.builder()
                .capacity(capacity)
                .reserve(reserve)
                .status(true)
                .price(price)
                .build();
        batteryRepository.save(batteryMapper.toBattery(batteryDto));
    }

    @Override
    public void deleteById(Integer batteryId) {
        batteryRepository.deleteById(batteryId);
    }

    @Override
    public void updateBattery(BatteryDto batteryDto) {
        batteryRepository.save(batteryMapper.toBattery(batteryDto));
    }
}
