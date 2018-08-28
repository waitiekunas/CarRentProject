package com.vcs.controlers;

import com.vcs.vehicles.TypesOfVehicle;
import com.vcs.vehicles.Vehicle;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public interface ClientOptionsInt {

    @RequestMapping("/")
    String commandLines();

    @RequestMapping(value = "/showCar/{start}/{end}", method = RequestMethod.GET)
    List<Vehicle> showCar(@PathVariable("start") int start, @PathVariable("end") int end);

    @RequestMapping(value = "/showCarByType/{type}/{start}/{end}", method = RequestMethod.GET)
    List<Vehicle> showCarByType(@PathVariable("type") TypesOfVehicle type, @PathVariable("start") int start, @PathVariable("end") int end);

    @RequestMapping(value = "/rent/{id}/{start}/{end}", method = RequestMethod.GET)
    String rent(@PathVariable("id") int id, @PathVariable("start") int start, @PathVariable("end") int end);

    @RequestMapping(value = "/return/{id}/{start}/{end}/{rDate}", method = RequestMethod.GET)
    String returnVehicle(@PathVariable("id") int id, @PathVariable("start") int start, @PathVariable("end") int end, @PathVariable("rDate") int rDate);
}
