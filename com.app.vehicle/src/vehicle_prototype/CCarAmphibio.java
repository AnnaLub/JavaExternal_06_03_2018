package vehicle_prototype;

public class CCarAmphibio extends CCar implements ISwim, IMove {

    public CCarAmphibio(String name, int degrees, int minutes, int seconds, int price, double speed, int modelYear, int id, TransmissionPrototype transmission) {
        super(name, degrees, minutes, seconds, price, speed, modelYear, id, transmission);
    }

    @Override
    public double speedWater() {
        return this.getSpeed()/3.56;
    }

    @Override
    public double speedRoad() {
        return this.getSpeed();
    }
}
