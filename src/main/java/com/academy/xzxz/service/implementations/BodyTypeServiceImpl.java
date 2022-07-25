package com.academy.xzxz.service.implementations;

import com.academy.xzxz.model.BodyType;
import com.academy.xzxz.repository.BodyTypeRepository;
import com.academy.xzxz.service.dto.BodyTypeDto;
import com.academy.xzxz.service.interfaces.BodyTypeService;
import com.academy.xzxz.service.mappers.BodyTypeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
@RequiredArgsConstructor
public class BodyTypeServiceImpl implements BodyTypeService {

    private final BodyTypeRepository bodyTypeRepository;
    private final BodyTypeMapper bodyTypeMapper;


    @Override
    public List<BodyTypeDto> findAll() {
        return StreamSupport
                .stream(bodyTypeRepository.findAll().spliterator(), false)
                .map(bodyTypeMapper::toBodyTypeDto)
                .sorted(Comparator.comparingInt(BodyTypeDto::getId).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public BodyTypeDto findById(Integer bodyTypeId) {
        BodyType bodyType = bodyTypeRepository.findById(bodyTypeId).orElse(null);
        return  bodyTypeMapper.toBodyTypeDto(bodyType);
    }

    @Override
    public void createNewBodyType(String name) {
        BodyTypeDto bodyTypeDto = BodyTypeDto.builder()
                .name(name)
                .build();
        bodyTypeRepository.save(bodyTypeMapper.toBodyType(bodyTypeDto));
    }

    @Override
    public void deleteById(Integer bodyTypeId) {
        bodyTypeRepository.deleteById(bodyTypeId);
    }

    @Override
    public void updateBodyType(Integer id, String name) {

        BodyType bodyType = bodyTypeRepository.findById(id).orElse(null);
        assert bodyType != null;
        bodyType.setId(id);
        bodyType.setName(name);
        bodyTypeRepository.save(bodyType);
    }
}
