package vehicle_prototype;

public class CCarBatMobile extends CCar implements IMove, IFly {

    public CCarBatMobile(String name, int degrees, int minutes, int seconds, int price, double speed, int modelYear, int id, TransmissionPrototype transmission) {
        super(name, degrees, minutes, seconds, price, speed, modelYear, id, transmission);
    }

    @Override
    public double speedAir() {
        return this.getSpeed()*5;
    }

    @Override
    public double speedRoad() {
        return this.getSpeed();
    }
}
