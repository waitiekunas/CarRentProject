package com.vcs.rentalOperations;


import com.vcs.vehicles.Vehicle;
import java.util.List;
import java.util.Map;

public abstract class ReturnOperations implements Rent_Return_Ops {


    @Override
    public String returnVehicle(int id, int startDate, int endDate, int returnDate, Map<Integer, List<Vehicle>> rentedList, List<Vehicle> generalList) {

        Vehicle vehicle = selectVehicle(id, generalList);
        returnAVehicle(id, startDate, endDate, rentedList, generalList);
        if (returnDate > endDate) {
            double toPay = (returnDate - endDate) * vehicle.getVehPrice();
            return "You have exceeded your rent period, please pay additional sum of " + toPay + " EUR.";
        }
        return "The vehicle has been accepted." + vehicle;
    }

    private void returnAVehicle(int id, int startDate, int endDate, Map<Integer, List<Vehicle>> rentedList, List<Vehicle> generalList) {

        Vehicle vehicle = selectVehicle(id, generalList);

        for (int i = startDate; i <= endDate; i++) {
            if (rentedList.containsKey(i)) {
                rentedList.get(i).remove(vehicle);
            }
            if (rentedList.get(i).isEmpty()) {
                rentedList.remove(i);
            }
        }
    }


    protected Vehicle selectVehicle(int ID, List<Vehicle> generalList) {
        for (Vehicle vehicle : generalList) {
            if (vehicle.getVehicleId() == ID) {
                return vehicle;
            }
        }
        return null;
    }


}
