package vehicle_prototype;

public class CPlane extends CplaneAndShipPrototype{
    private double flightAltitude;

    public CPlane(String name, int degrees, int minutes, int seconds, int price, double speed, int modelYear, int id, TransmissionPrototype transmission, double carryingPassangers, double flightAltitude) {
        super(name, degrees, minutes, seconds, price, speed, modelYear, id, transmission, carryingPassangers);
        this.flightAltitude = flightAltitude;
    }

    @Override
    void display() {
        System.out.println(this.toString());
    }
}
