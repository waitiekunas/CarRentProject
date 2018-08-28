package com.vcs.rentalOperations;

import com.vcs.vehicles.Vehicle;
import java.util.List;
import java.util.Map;

public interface Rent_Return_Ops {


    String returnVehicle(int id, int startDate, int endDate, int returnDate, Map<Integer, List<Vehicle>> rentedList, List<Vehicle> generalList);

    String rent(int id, int startDate, int endDate, Map<Integer, List<Vehicle>> rentedList, List<Vehicle> generalList);
}
