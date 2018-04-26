package vehicle_prototype;

public class VehicleArray {
    private CVehicle [] vehicles;
    private int index;

    public VehicleArray() {
        this.index = -1;
        vehicles = new CVehicle[1];
    }

    public CVehicle getElement(int index) {
        if (index >= vehicles.length) {
            return null;
        } else{
            return vehicles[index];
        }
    }
    public int size(){
        return vehicles.length;
    }

    public void addElement(CVehicle vehicle){
        if(index<vehicles.length-1){
            vehicles[++index]=vehicle;
        }else {
            int newSize = vehicles.length + 1;
            CVehicle[] temporaryArray = new CVehicle[newSize];
            System.arraycopy(vehicles, 0, temporaryArray, 0, vehicles.length);
            vehicles =temporaryArray;
            vehicles[++index]=vehicle;
        }
    }
}
