package com.vcs.rentalOperations;

import com.vcs.vehicles.TypesOfVehicle;
import com.vcs.vehicles.Vehicle;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Qualifier("clientOps")
public class ClientOperations extends RentOperations implements InfoOperationsForClient {


    public static final int DAYS_IN_YEAR = 365;


    @Override
    public List<Vehicle> showAvailableCarsByDate(int startDate, int endDate, List<Vehicle> generalList, Map<Integer, List<Vehicle>> rentedList) {

        if (startDate > endDate) {
            throw new RuntimeException("start date must be earlier than end date");
        }
        if (startDate <= 0 || endDate <= 1) {
            throw new RuntimeException("incorrect dates");
        }
        if (startDate > DAYS_IN_YEAR || endDate > DAYS_IN_YEAR) {
            throw new RuntimeException("No trans-year rents available");
        }

        List<Vehicle> busyVehicles = getListOfBusyVehicles(startDate, endDate, rentedList);

        if (busyVehicles.isEmpty()) {
            return generalList;
        }


        return giveListOfFreeVehicles(generalList, busyVehicles);
    }


    private List<Vehicle> giveListOfFreeVehicles(List<Vehicle> allCars, List<Vehicle> busyCars) {
        List<Vehicle> availableVeh = new ArrayList<>();
        for (Vehicle freeVehicle : allCars) {
            for (Vehicle busyVehicle : busyCars) {
                if (freeVehicle.getVehicleId() != busyVehicle.getVehicleId()) {
                    availableVeh.add(freeVehicle);
                }
            }
        }
        return availableVeh;
    }


    @Override
    public List<Vehicle> showIfTheVehrIsAvailable(TypesOfVehicle type, int startDate, int endDate, List<Vehicle> generalList, Map<Integer, List<Vehicle>> rentedList) {

        List<Vehicle> busyVehicles = getListOfBusyVehicles(startDate, endDate, rentedList);

        if (busyVehicles.isEmpty()) {
            return givesListVehByType(generalList, type);
        }
        return giveListVehTypeByBusyList(generalList, busyVehicles, type);
    }


    private List<Vehicle> giveListVehTypeByBusyList(List<Vehicle> allCars, List<Vehicle> busyCars, TypesOfVehicle type) {
        List<Vehicle> availableVeh = new ArrayList<>();
        for (Vehicle fvehicle : allCars) {
            for (Vehicle bvehicle : busyCars
            ) {
                if (fvehicle.getVehicleId() != bvehicle.getVehicleId() && fvehicle.getTypesOfVehicle() == type) {
                    availableVeh.add(fvehicle);
                }
            }
        }
        return availableVeh;
    }


    private List<Vehicle> givesListVehByType(List<Vehicle> allCars, TypesOfVehicle type) {
        List<Vehicle> freeCars = new ArrayList<>();
        for (Vehicle vehicle : allCars
        ) {
            if (vehicle.getTypesOfVehicle() == type) {
                freeCars.add(vehicle);
            }

        }

        return freeCars;
    }


    private List<Vehicle> getListOfBusyVehicles(int startDate, int endDate, Map<Integer, List<Vehicle>> rentedList) {
        List<Vehicle> busyVehicles = new ArrayList<>();
        for (int i = startDate; i <= endDate; i++) {
            if (rentedList.containsKey(i)) {
                for (Vehicle vehicle : rentedList.get(i)
                ) {
                    if (!busyVehicles.contains(vehicle)) {
                        busyVehicles.add(vehicle);
                    }
                }
            }
        }
        return busyVehicles;
    }


}
