package com.vcs.rentalOperations;

import com.vcs.vehicles.Vehicle;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class RentOperations extends ReturnOperations {


    @Override
    public String rent(int id, int startDate, int endDate, Map<Integer, List<Vehicle>> rentedList, List<Vehicle> generalList) {


        if (checkIfVehIsAvl(id, startDate, endDate, rentedList)) {
            Vehicle vehicle = rentAVehicle(id, startDate, endDate, rentedList, generalList);
            return "The Vehicle is rented to you." + "Model: " + vehicle.getModel() + ". ID: " + vehicle.getVehicleId() + ". " + vehicle;
        } else {
            return "Vehicle with ID: " + id + " is rented during your selected dates.";
        }

    }

    private Vehicle rentAVehicle(int id, int startDate, int endDate, Map<Integer, List<Vehicle>> rentedList, List<Vehicle> generalList) {

        Vehicle vehicle = selectVehicle(id, generalList);

        for (int i = startDate; i <= endDate; i++) {
            if (!rentedList.containsKey(i)) {
                rentedList.put(i, new ArrayList<Vehicle>());
            }
            rentedList.get(i).add(vehicle);
        }
        return vehicle;
    }

    private boolean checkIfVehIsAvl(int id, int startDate, int endDate, Map<Integer, List<Vehicle>> rentedList) {

        for (int a = startDate; a <= endDate; a++) {
            if (rentedList.containsKey(a)) {
                for (Vehicle vehicle : rentedList.get(a)) {
                    if (vehicle.getVehicleId() == id) {
                        return false;
                    }
                }
            }
        }
        return true;
    }


}



