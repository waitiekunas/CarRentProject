package rentalOperations;

import com.vcs.vehicles.TypesOfVehicle;
import com.vcs.vehicles.Vehicle;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
@Qualifier("keepsVehiclesTest")
public class KeepsVehiclesForTest {


    Vehicle vehicle1 = new Vehicle(TypesOfVehicle.HATCHBACK, 1);
    Vehicle vehicle2 = new Vehicle(TypesOfVehicle.SEDAN, 2);
    Vehicle vehicle3 = new Vehicle(TypesOfVehicle.MOTORBIKE, 3);
    Vehicle vehicle4 = new Vehicle(TypesOfVehicle.JEEP, 4);


    private List<Vehicle> generalList = new CopyOnWriteArrayList<Vehicle>() {{
        add(vehicle1);
        add(vehicle2);
        add(vehicle3);
        add(vehicle4);
    }};


    private Map<Integer, List<Vehicle>> rentedList = new ConcurrentHashMap();


    public Map<Integer, List<Vehicle>> getRentedList() {
        return rentedList;
    }

    public void setRentedList(Map<Integer, List<Vehicle>> rentedList) {
        this.rentedList = rentedList;
    }

    public List<Vehicle> getGeneralList() {
        return generalList;
    }

    public void setGeneralList(List<Vehicle> generalList) {
        this.generalList = generalList;
    }
}
