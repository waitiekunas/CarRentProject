package com.vcs.controlers;

import com.vcs.vehicles.TypesOfVehicle;
import com.vcs.vehicles.Vehicle;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

public interface AdminOptionsInt {

    @RequestMapping(value = "/addNewCar/{type}", method = RequestMethod.GET)
    Vehicle addNewCar(@PathVariable("type") TypesOfVehicle type);

    @RequestMapping(value = "/ownedVehicles", method = RequestMethod.GET)
    List<Vehicle> showAllVehicles();


    @RequestMapping(value = "/rentedVehicles", method = RequestMethod.GET)
    Map<Vehicle, List<Integer>> rentedVehicles();
}
