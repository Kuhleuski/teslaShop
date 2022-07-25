package com.academy.xzxz.service.implementations;

import com.academy.xzxz.model.Body;
import com.academy.xzxz.repository.BodyRepository;
import com.academy.xzxz.service.dto.BodyDto;
import com.academy.xzxz.service.interfaces.BodyService;
import com.academy.xzxz.service.mappers.BodyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class BodyServiceImpl implements BodyService {

    private final BodyRepository bodyRepository;
    private final BodyMapper bodyMapper;

    @Override
    public List<BodyDto> findAll() {
        return StreamSupport
                .stream(bodyRepository.findAll().spliterator(), false)
                .map(bodyMapper::toBodyDto)
                .sorted(Comparator.comparingInt(BodyDto::getId).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public BodyDto findById(Integer bodyId) {
        Body body = bodyRepository.findById(bodyId).orElse(null);
        return bodyMapper.toBodyDto(body);
    }

    @Override
    public void createNewBody(String name, String type, int numberOfSeats, double weight,
                              double width, double height, double length, int trunk,
                              double wheelBase, double price) {

        BodyDto bodyDto = BodyDto.builder()
                .name(name)
                .type(type)
                .numberOfSeats(numberOfSeats)
                .weight(weight)
                .width(width)
                .height(height)
                .length(length)
                .trunk(trunk)
                .wheelBase(wheelBase)
                .price(price)
                .build();
        bodyRepository.save(bodyMapper.toBody(bodyDto));
    }

    @Override
    public void deleteById(Integer bodyId) {
        bodyRepository.deleteById(bodyId);
    }

    @Override
    public void updateBody(BodyDto bodyDto) {
        bodyRepository.save(bodyMapper.toBody(bodyDto));
    }
}
