package com.academy.xzxz.service.interfaces;


import com.academy.xzxz.model.CarStatus;
import com.academy.xzxz.service.dto.CarDto;

import java.util.List;

public interface CarService {
    List<CarDto> findAll();

    CarDto findById(Integer carId);

//    void createNewCar( Body body, Equipment equipment, Wheel wheel,
//                       Color color, String status);

    void createNewCar(int bodyId, int equipmentId, int wheelId,  CarStatus status, boolean toning, int colorId);



    void deleteById(Integer carId);

    void updateCar(int id,  int equipmentId, int wheelId,  int colorId);

}


