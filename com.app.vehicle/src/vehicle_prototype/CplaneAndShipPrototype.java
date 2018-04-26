package vehicle_prototype;

public abstract class CplaneAndShipPrototype extends CVehicle{
    private double carryingPassangers;

    public CplaneAndShipPrototype(String name, int degrees, int minutes, int seconds, int price, double speed, int modelYear, int id, TransmissionPrototype transmission, double carryingPassangers) {
        super(name, degrees, minutes, seconds, price, speed, modelYear, id, transmission);
        this.carryingPassangers = carryingPassangers;
    }

    public void setCarryingPassangers(double carryingPassangers) {
        this.carryingPassangers = carryingPassangers;
    }

    public double getCarryingPassangers() {
        return carryingPassangers;
    }
}
