package com.academy.xzxz.service.implementations;

import com.academy.xzxz.model.Battery;
import com.academy.xzxz.model.Body;
import com.academy.xzxz.model.Engine;
import com.academy.xzxz.model.Equipment;
import com.academy.xzxz.repository.EquipmentRepository;
import com.academy.xzxz.service.dto.BatteryDto;
import com.academy.xzxz.service.dto.BodyDto;
import com.academy.xzxz.service.dto.EngineDto;
import com.academy.xzxz.service.dto.EquipmentDto;
import com.academy.xzxz.service.interfaces.BatteryService;
import com.academy.xzxz.service.interfaces.BodyService;
import com.academy.xzxz.service.interfaces.EngineService;
import com.academy.xzxz.service.interfaces.EquipmentService;
import com.academy.xzxz.service.mappers.BatteryMapper;
import com.academy.xzxz.service.mappers.BodyMapper;
import com.academy.xzxz.service.mappers.EngineMapper;
import com.academy.xzxz.service.mappers.EquipmentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class EquipmentServiceImpl implements EquipmentService {

    private final EquipmentRepository equipmentRepository;
    private final EquipmentMapper equipmentMapper;

    private final EngineService engineService;
    private final BatteryService batteryService;

    private final EngineMapper engineMapper;
    private final BatteryMapper batteryMapper;


private final BodyService bodyService;
private final BodyMapper bodyMapper;


    @Override
    public List<EquipmentDto> findAll() {
        return StreamSupport
                .stream(equipmentRepository.findAll().spliterator(), false)
                .map(equipmentMapper::toEquipmentDto)
                .sorted(Comparator.comparingInt(EquipmentDto::getId).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public EquipmentDto findById(Integer equipmentId) {
        Equipment equipment = equipmentRepository.findById(equipmentId).orElse(null);
        return equipmentMapper.toEquipmentDto(equipment);
    }

    @Override
    public void createNewEquipment(String name, int engineId, int batteryId,int bodyId, double accelerate, int maxSpeed) {

        EngineDto engineDto = engineService.findById(engineId);
        BatteryDto batteryDto = batteryService.findById(batteryId);
        BodyDto bodyDto = bodyService.findById(bodyId);

        Battery battery = batteryMapper.toBattery(batteryDto);
        Engine engine = engineMapper.toEngine(engineDto);
        Body body = bodyMapper.toBody(bodyDto);

        // попробовать так-------
//        Battery battery = batteryMapper.toBattery(batteryService.findById(batteryId));
//        Engine engine = engineMapper.toEngine(engineService.findById(engineId));


        EquipmentDto equipmentDto = EquipmentDto.builder()
                .name(name)
                .battery(battery)
                .engine(engine)
                .body(body)
                .accelerate(accelerate)
                .maxSpeed(maxSpeed)
                .build();
        equipmentRepository.save(equipmentMapper.toEquipment(equipmentDto));
    }

    @Override
    public void deleteById(Integer equipmentId) {
        equipmentRepository.deleteById(equipmentId);
    }

    @Override
    public void updateEquipment(int id, String name, int engineId, int batteryId,int bodyId, double accelerate, int maxSpeed) {

       Equipment equipment =  equipmentRepository.findById(id).orElse(null);

        Battery battery = batteryMapper.toBattery(batteryService.findById(batteryId));
        Engine engine = engineMapper.toEngine(engineService.findById(engineId));
        Body body = bodyMapper.toBody(bodyService.findById(bodyId));

        assert equipment != null;
        equipment.setName(name);
        equipment.setBattery(battery);
        equipment.setEngine(engine);
        equipment.setBody(body);
        equipment.setAccelerate(accelerate);
        equipment.setMaxSpeed(maxSpeed);


        equipmentRepository.save(equipment);
    }

    @Override
    public List<EquipmentDto> findAllEnginesForCurrentBody(int bodyId) {
        return equipmentRepository.findAllEnginesForCurrentBody(bodyId).stream()
                .map(equipmentMapper::toEquipmentDto)
                .sorted(Comparator.comparingInt(EquipmentDto::getId).reversed())
                .collect(Collectors.toList());
    }
}
