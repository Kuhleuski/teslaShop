package com.academy.xzxz.service.implementations;

import com.academy.xzxz.model.Color;
import com.academy.xzxz.repository.ColorRepository;
import com.academy.xzxz.service.dto.ColorDto;
import com.academy.xzxz.service.interfaces.ColorService;
import com.academy.xzxz.service.mappers.ColorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
@RequiredArgsConstructor
public class ColorServiceImpl implements ColorService {

    private final ColorRepository colorRepository;
    private final ColorMapper colorMapper;

    @Override
    public List<ColorDto> findAll() {
        return StreamSupport
                .stream(colorRepository.findAll().spliterator(), false)
                .map(colorMapper::toColorDto)
                .sorted(Comparator.comparingInt(ColorDto::getId).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public ColorDto findById(Integer colorId) {
        Color color = colorRepository.findById(colorId).orElse(null);
        return  colorMapper.toColorDto(color);
    }

    @Override
    public void createNewColor(String name, double price) {
        ColorDto colorDto = ColorDto.builder()
                .name(name)
                .price(price)
                .build();
        colorRepository.save(colorMapper.toColor(colorDto));
    }

    @Override
    public void deleteById(Integer colorId) {
        colorRepository.deleteById(colorId);
    }

    @Override
    public void updateColor(ColorDto colorDto) {
        colorRepository.save(colorMapper.toColor(colorDto));
    }
}
