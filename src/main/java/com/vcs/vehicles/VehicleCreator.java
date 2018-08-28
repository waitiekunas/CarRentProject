package com.vcs.vehicles;


import com.vcs.operators.KeepsVehicles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.boot.context.event.ApplicationReadyEvent;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;


import static com.vcs.vehicles.TypesOfVehicle.*;

@Service
public class VehicleCreator implements VehicleCreatorInt {


    @Autowired
    @Qualifier("keepsVehicles")
    private KeepsVehicles shop;

    @Autowired
    @Qualifier("counter")
    private Counter count;

    @EventListener(ApplicationReadyEvent.class)
    @Override
    public void addCars() {
        if (shop.getGeneralList().isEmpty()) {

            for (int i = 0; i < 3; i++) {

                shop.getGeneralList().add(new Vehicle(JEEP, count.increasesCounter()));
                shop.getGeneralList().add(new Vehicle(MOTORBIKE, count.increasesCounter()));
                shop.getGeneralList().add(new Vehicle(HATCHBACK, count.increasesCounter()));
                shop.getGeneralList().add(new Vehicle(SEDAN, count.increasesCounter()));
            }
        }
    }


}
