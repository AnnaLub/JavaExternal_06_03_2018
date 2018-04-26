package vehicle_prototype;

public class CShip extends CplaneAndShipPrototype{
    private String homePort;

    public CShip(String name, int degrees, int minutes, int seconds, int price, double speed, int modelYear, int id, TransmissionPrototype transmission, double carryingPassangers, String homePort) {
        super(name, degrees, minutes, seconds, price, speed, modelYear, id, transmission, carryingPassangers);
        this.homePort = homePort;
    }

    public void setHomePort(String homePort) {
        this.homePort = homePort;
    }

    public String getHomePort() {
        return homePort;
    }

    @Override
    void display() {
        System.out.println(this.toString());
    }


}
