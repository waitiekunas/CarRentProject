package com.vcs.operators;

import com.vcs.vehicles.Vehicle;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
@Qualifier("keepsVehicles")
public class KeepsVehicles {


    private List<Vehicle> generalList = new CopyOnWriteArrayList<>();


    private Map<Integer, List<Vehicle>> rentedList = new ConcurrentHashMap();

    public List<Vehicle> getGeneralList() {
        return generalList;
    }

    public void setGeneralList(List<Vehicle> generalList) {
        this.generalList = generalList;
    }

    public Map<Integer, List<Vehicle>> getRentedList() {
        return rentedList;
    }

    public void setRentedList(Map<Integer, List<Vehicle>> rentedList) {
        this.rentedList = rentedList;
    }
}




