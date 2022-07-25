package com.academy.xzxz.service.implementations;

import com.academy.xzxz.model.Engine;
import com.academy.xzxz.repository.EngineRepository;
import com.academy.xzxz.service.dto.EngineDto;
import com.academy.xzxz.service.interfaces.BodyService;
import com.academy.xzxz.service.interfaces.EngineService;
import com.academy.xzxz.service.mappers.BodyMapper;
import com.academy.xzxz.service.mappers.EngineMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class EngineServiceImpl implements EngineService {

    private final EngineRepository engineRepository;
    private final EngineMapper engineMapper;

    private final BodyService bodyService;
    private final BodyMapper bodyMapper;

    @Override
    public List<EngineDto> findAll() {
        return StreamSupport
                .stream(engineRepository.findAll().spliterator(), false)
                .map(engineMapper::toEngineDto)
                .sorted(Comparator.comparingInt(EngineDto::getId).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public EngineDto findById(Integer engineId) {
        Engine engine = engineRepository.findById(engineId).orElse(null);
        return  engineMapper.toEngineDto(engine);
    }

    @Override
    public void createNewEngine(String name ,
                                int power, int torque, String driveUnit, int bodyId,
                                double price) {
        EngineDto engineDto = EngineDto.builder()
                .name(name)
                .power(power)
                .torque(torque)
                .body(bodyMapper.toBody(bodyService.findById(bodyId)))
                .driveUnit(driveUnit)
                .price(price)
                .build();
        engineRepository.save(engineMapper.toEngine(engineDto));
    }

    @Override
    public void deleteById(Integer engineId) {
            engineRepository.deleteById(engineId);
    }

    @Override
    public void updateEngine(EngineDto engineDto) {
        engineRepository.save(engineMapper.toEngine(engineDto));
    }

    @Override
    public List<EngineDto> findEnginesForBody(int bodyId) {
       return engineRepository.findAllEnginesForCurrentBody(bodyId).stream()
                .map(engineMapper::toEngineDto)
                .sorted(Comparator.comparingInt(EngineDto::getId).reversed())
                .collect(Collectors.toList());
    }

}
