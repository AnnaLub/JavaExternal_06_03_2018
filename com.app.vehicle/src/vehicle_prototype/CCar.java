package vehicle_prototype;

public class CCar extends CVehicle {

    public CCar(String name, int degrees, int minutes, int seconds, int price, double speed, int modelYear, int id, TransmissionPrototype transmission) {
        super(name, degrees, minutes, seconds, price, speed, modelYear, id, transmission);
    }

    @Override
    void display() {
        System.out.println(this.toString());
    }

}
