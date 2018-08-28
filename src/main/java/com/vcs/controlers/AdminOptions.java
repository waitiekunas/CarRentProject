package com.vcs.controlers;

import com.vcs.rentalOperations.AdminOperations;
import com.vcs.vehicles.TypesOfVehicle;
import com.vcs.vehicles.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminOptions extends ClientOptions implements AdminOptionsInt {

    @Autowired
    @Qualifier("admin")
    private AdminOperations forAdmin;

    @Override
    @RequestMapping(value = "/addNewCar/{type}", method = RequestMethod.GET)
    public Vehicle addNewCar(@PathVariable("type") TypesOfVehicle type) {
        return forAdmin.addNewVehicle(type, keepsVehicles.getGeneralList());
    }

    @Override
    @RequestMapping(value = "/ownedVehicles", method = RequestMethod.GET)
    public List<Vehicle> showAllVehicles() {
        return forAdmin.howManyCarsWePosses(keepsVehicles.getGeneralList());
    }

    @Override
    @RequestMapping(value = "/rentedVehicles", method = RequestMethod.GET)
    public Map<Vehicle, List<Integer>> rentedVehicles() {
        return forAdmin.showWhatIsRented(keepsVehicles.getRentedList());
    }


}
