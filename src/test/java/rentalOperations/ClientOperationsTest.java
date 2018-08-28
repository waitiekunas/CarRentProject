package rentalOperations;


import com.vcs.rentalOperations.ClientOperations;
import com.vcs.vehicles.Vehicle;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;


public class ClientOperationsTest {


    @Autowired
    @Qualifier("keepsVehiclesTest")
    private KeepsVehiclesForTest test;

    @Autowired
    @Qualifier("clientOps")
    ClientOperations cOps;

    @Before
    public void init() {

        cOps = new ClientOperations();
        test = new KeepsVehiclesForTest();


    }

    @Test
    public void parseSucess() {

        List<Vehicle> vehicles = cOps.showAvailableCarsByDate(1, 365, test.getGeneralList(), test.getRentedList());
        System.out.println(vehicles.size());
    }

    @Test(expected = RuntimeException.class)
    public void parseFails() {
        cOps.showAvailableCarsByDate(100, 33, test.getGeneralList(), test.getRentedList());

    }

    @Test(expected = RuntimeException.class)
    public void parseFails2() {
        cOps.showAvailableCarsByDate(-1, 33, test.getGeneralList(), test.getRentedList());

    }

    @Test(expected = RuntimeException.class)
    public void parseFails3() {
        cOps.showAvailableCarsByDate(1, 1, test.getGeneralList(), test.getRentedList());

    }

    @Test(expected = RuntimeException.class)
    public void parseFails4() {
        cOps.showAvailableCarsByDate(366, 366, test.getGeneralList(), test.getRentedList());

    }

    @Test(expected = RuntimeException.class)
    public void parseFails5() {
        cOps.showAvailableCarsByDate(1, 367, test.getGeneralList(), test.getRentedList());

    }
}
