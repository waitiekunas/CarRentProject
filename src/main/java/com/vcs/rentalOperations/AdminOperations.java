package com.vcs.rentalOperations;


import com.vcs.vehicles.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.vcs.vehicles.TypesOfVehicle.*;


@Service
@Qualifier("admin")
public class AdminOperations extends ClientOperations implements InfoOperationsForAdmin {

    @Autowired
    @Qualifier("counter")
    private Counter count;

    @Override
    public Map<Vehicle, List<Integer>> showWhatIsRented(Map<Integer, List<Vehicle>> list) {
        Map<Vehicle, List<Integer>> rentedVehicles = new HashMap<>();
        for (int i = 0; i <= DAYS_IN_YEAR; i++) {
            if (list.containsKey(i)) {
                for (Vehicle vehicle : list.get(i)) {
                    rentedVehicles.putIfAbsent(vehicle, new ArrayList<>());
                    rentedVehicles.get(vehicle).add(i);
                }
            }
        }
        return rentedVehicles;


    }

    @Override
    public List<Vehicle> howManyCarsWePosses(List<Vehicle> generalList) {
        return generalList;


    }

    @Override
    public Vehicle addNewVehicle(TypesOfVehicle type, List<Vehicle> generalList) {
        switch (type) {
            case HATCHBACK:
                Vehicle vehicle1 = new Vehicle(HATCHBACK, count.increasesCounter());
                generalList.add(vehicle1);
                return vehicle1;
            case JEEP:
                Vehicle vehicle2 = new Vehicle(JEEP, count.increasesCounter());
                generalList.add(vehicle2);
                return vehicle2;
            case MOTORBIKE:
                Vehicle vehicle3 = new Vehicle(MOTORBIKE, count.increasesCounter());
                generalList.add(vehicle3);
                return vehicle3;
            case SEDAN:
                Vehicle vehicle4 = new Vehicle(SEDAN, count.increasesCounter());
                generalList.add(vehicle4);
                return vehicle4;
        }
        return null;

    }
}
