package com.vcs.rentalOperations;

import com.vcs.vehicles.TypesOfVehicle;
import com.vcs.vehicles.Vehicle;
import java.util.List;
import java.util.Map;

public interface InfoOperationsForAdmin {

    Map<Vehicle, List<Integer>> showWhatIsRented(Map<Integer, List<Vehicle>> rentedList);

    Vehicle addNewVehicle(TypesOfVehicle type, List<Vehicle> generalList);

    List<Vehicle> howManyCarsWePosses(List<Vehicle> generalList);

}

