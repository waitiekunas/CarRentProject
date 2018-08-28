package com.vcs.rentalOperations;

import com.vcs.vehicles.TypesOfVehicle;
import com.vcs.vehicles.Vehicle;
import java.util.List;
import java.util.Map;

public interface InfoOperationsForClient {

    List<Vehicle> showAvailableCarsByDate(int startDate, int endDate, List<Vehicle> aList, Map<Integer, List<Vehicle>> mList);

    List<Vehicle> showIfTheVehrIsAvailable(TypesOfVehicle type, int startDate, int endDate, List<Vehicle> generalList, Map<Integer, List<Vehicle>> rentedList);


}
