package com.vcs.vehicles;


public class Vehicle {
    private final int SEDAN_PRICE = 40;
    private final int HATCHBACK_PRICE = 30;
    private final int MOTORBIKE_PRICE = 20;
    private final int JEEP_PRICE = 50;


    private String model;


    private int vehicleId;

    private TypesOfVehicle typesOfVehicle;


    private double VehPrice;


    public Vehicle(TypesOfVehicle type, int id) {
        setModel("Rover");
        setVehicleId(id);
        setTypesOfVehicle(type);
        setVehPrice(determinePrice(type));
    }

    public Vehicle(TypesOfVehicle type, int id, String model) {
        setModel(model);
        setVehicleId(id);
        setTypesOfVehicle(type);
        setVehPrice(determinePrice(type));
    }


    private int determinePrice(TypesOfVehicle type) {
        switch (type) {
            case HATCHBACK:
                return HATCHBACK_PRICE;
            case SEDAN:
                return SEDAN_PRICE;
            case JEEP:
                return JEEP_PRICE;
            case MOTORBIKE:
                return MOTORBIKE_PRICE;
            default:
                return 0;

        }
    }


    public void setModel(String model) {
        this.model = model;
    }


    public String getModel() {
        return model;
    }


    public TypesOfVehicle getTypesOfVehicle() {
        return typesOfVehicle;
    }

    public void setTypesOfVehicle(TypesOfVehicle typesOfVehicle) {
        this.typesOfVehicle = typesOfVehicle;
    }


    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int id) {

        vehicleId = id;
    }

    public double getVehPrice() {
        return VehPrice;
    }

    protected void setVehPrice(double vehPrice) {
        VehPrice = vehPrice;
    }


}
