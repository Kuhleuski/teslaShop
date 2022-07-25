package com.academy.xzxz.service.implementations;

import com.academy.xzxz.model.*;
import com.academy.xzxz.repository.CarRepository;
import com.academy.xzxz.service.dto.*;
import com.academy.xzxz.service.interfaces.*;
import com.academy.xzxz.service.mappers.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final CarMapper carMapper;

    private final BodyService bodyService;
    private final EquipmentService equipmentService;
    private final WheelService wheelService;
    private final ColorService colorService;

    private final BodyMapper bodyMapper;
    private final EquipmentMapper equipmentMapper;
    private final WheelMapper wheelMapper;
    private final ColorMapper colorMapper;

    @Override
    public List<CarDto> findAll() {
        return StreamSupport
                .stream(carRepository.findAll().spliterator(), false)
                .map(carMapper::toCarDto)
                .sorted(Comparator.comparingInt(CarDto::getId).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public CarDto findById(Integer carId) {
        Car car = carRepository.findById(carId).orElse(null);
        return carMapper.toCarDto(car);
    }

    @Override
    public void createNewCar( int bodyId, int equipmentId, int wheelId, CarStatus status, boolean toning, int colorId) {

        BodyDto bodyDto = bodyService.findById(bodyId);
        EquipmentDto equipmentDto = equipmentService.findById(equipmentId);
        WheelDto wheelDto = wheelService.findById(wheelId);
        ColorDto colorDto = colorService.findById(colorId);

        Body body = bodyMapper.toBody(bodyDto);
        Equipment equipment = equipmentMapper.toEquipment(equipmentDto);
        Wheel wheel = wheelMapper.toWheel(wheelDto);
        Color color = colorMapper.toColor(colorDto);

        CarDto carDto = CarDto.builder()
                .body(body)
                .equipment(equipment)
                .wheel(wheel)
                .color(color)
                .toning(toning)
                .status(CarStatus.ACTIVE)
                .build();
        carRepository.save(carMapper.toCar(carDto));
    }

    @Override
    public void deleteById(Integer carId) {
        carRepository.deleteById(carId);
    }

    @Override
    public void updateCar(int id, int equipmentId, int wheelId, int colorId) {


        Car car = carRepository.findById(id).orElse(null);

        Equipment equipment =equipmentMapper.toEquipment( equipmentService.findById(equipmentId));
        Wheel wheel =wheelMapper.toWheel( wheelService.findById(wheelId));
       Color color =colorMapper.toColor( colorService.findById(colorId));

        assert car != null;
        car.setEquipment(equipment);
        car.setWheel(wheel);
        car.setStatus(CarStatus.ACTIVE);
        car.setColor(color);

       carRepository.save(car);
    }
}
