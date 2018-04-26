package console_methods;

import vehicle_prototype.*;

import java.util.Arrays;
import java.util.Comparator;


public class ConsoleMethods {

    /*The most expensive Vehicle*/
    public static void getBiggestPrice(VehicleArray vehicles){
        int biggestPrice = vehicles.getElement(0).getPrice();
        CVehicle vehicle = vehicles.getElement(0);

        for (int i = 1; i < vehicles.size(); i++) {
            if(vehicles.getElement(i).getPrice()>biggestPrice){
                biggestPrice=vehicles.getElement(i).getPrice();
                vehicle=vehicles.getElement(i);
            }
        }
        System.out.println("biggest price: "+biggestPrice);
        System.out.println(vehicle);
    }

    /*Vehicle modelYear: 2000-2005, with speed that exceed 150km/h and has lowest price*/
    public static void findByYearThanBySpeedThanByPrice(VehicleArray vehicles){
        int lowestPrice = 0;
        CVehicle vehicle = null;
        boolean isEmpty = true;

        for (int i = 1; i < vehicles.size(); i++) {
            if(vehicles.getElement(i).getModelYear()>=2000 & vehicles.getElement(i).getModelYear()<=2005) {
                if (vehicles.getElement(i).getSpeed() > 150) {
                    if (isEmpty) {
                        lowestPrice = vehicles.getElement(i).getPrice();
                        vehicle = vehicles.getElement(i);
                        isEmpty = false;
                    }else{
                        if (vehicles.getElement(i).getPrice() < lowestPrice) {
                            lowestPrice = vehicles.getElement(i).getPrice();
                            vehicle = vehicles.getElement(i);
                        }
                    }
                }
            }
        }
        if(isEmpty){
            System.out.println("No vehicles finded with given parameters");
        }else{
            System.out.println("lowest price: " + lowestPrice);
            System.out.println(vehicle);
        }
    }

    /*From Vehicle array get Car array, with Cars not older than 5 years*/
    public static void findCarsNotOlderThanFiveYears(VehicleArray vehicles){
        CVehicle vehicle = null;

        for (int i = 0; i < vehicles.size(); i++) {
            if("vehicle_prototype.CCar".equals(vehicles.getElement(i).getClass().getName())){
                if(vehicles.getElement(i).getModelYear()>=2013){
                    vehicle = vehicles.getElement(i);
                    System.out.println(vehicle);
                }
            }
        }
    }


    /*From the Vehicle array, get the Ship array not older than 5 years, with a sorted price in descending order*/
    public static void findShipsAndSortByPriceInDescendingOrder(VehicleArray vehicles){
        VehicleArray ships = new VehicleArray();

        for (int i = 0; i < vehicles.size(); i++) {
            if("vehicle_prototype.CShip".equals(vehicles.getElement(i).getClass().getName())){
                if(vehicles.getElement(i).getModelYear()>=2013)
                ships.addElement(vehicles.getElement(i));
            }
        }
        CVehicle [] shipSort = new CVehicle[ships.size()];
        for (int i = 0; i < ships.size(); i++) {
            shipSort[i] = ships.getElement(i);
        }
        Arrays.sort(shipSort, new Comparator<CVehicle>() {
            @Override
            public int compare(CVehicle cv1, CVehicle cv2) {
                int result = cv1.getPrice()-cv2.getPrice();
                return (result<0) ? 1 : (result>0) ? -1 : 0;
            }
        });
        for (int i = 0; i <shipSort.length ; i++) {
            System.out.println(shipSort[i]);
        }
    }
    public static void findIMoveAble(VehicleArray vehicles){
        VehicleArray cars = new VehicleArray();

        for (int i = 0; i < vehicles.size(); i++) {
            if(vehicles.getElement(i) instanceof IMove){
                cars.addElement(vehicles.getElement(i));
            }
        }
        IMove [] iMoves = new IMove[cars.size()];
        for (int i = 0; i <cars.size(); i++) {
            iMoves[i] = (IMove) cars.getElement(i);
            System.out.println(iMoves[i]);
        }
        System.out.println("Sorted to MAX:");
        sortToMax(iMoves);
        for (IMove iMove : iMoves) {
            System.out.println(iMove);
        }
        System.out.println("Sorted to MIN:");
        sortToMin(iMoves);
        for (IMove iMove : iMoves) {
            System.out.println(iMove);
        }
    }
    public static void sortToMax(IMove [] iMoves){
        Arrays.sort(iMoves, new Comparator<IMove>() {
            @Override
            public int compare(IMove im1, IMove im2) {
                return (int)(im1.speedRoad()-im2.speedRoad());
            }
        });
    }
    public static void sortToMin(IMove [] iMoves){
        Arrays.sort(iMoves, new Comparator<IMove>() {
            @Override
            public int compare(IMove im1, IMove im2) {
                return (int)(im2.speedRoad()-im1.speedRoad());
            }
        });
    }
    public static void findIFlyAble(VehicleArray vehicles){
        VehicleArray cars = new VehicleArray();

        for (int i = 0; i < vehicles.size(); i++) {
            if(vehicles.getElement(i) instanceof IFly){
                cars.addElement(vehicles.getElement(i));
            }
        }
        IFly [] iFlyes = new IFly[cars.size()];
        for (int i = 0; i <cars.size(); i++) {
            iFlyes[i] = (IFly) cars.getElement(i);
            System.out.println(iFlyes[i]);
        }
        System.out.println("Sorted to MAX:");
        sortToMax(iFlyes);
        for (IFly iFlye : iFlyes) {
            System.out.println(iFlye);
        }

        System.out.println("Sorted to MIN:");
        sortToMin(iFlyes);
        for (IFly iFlye : iFlyes) {
            System.out.println(iFlye);
        }
    }

    public static void sortToMax(IFly [] iFlyes){
        Arrays.sort(iFlyes, new Comparator<IFly>() {
            @Override
            public int compare(IFly if1, IFly if2) {
                return (int)(if1.speedAir()-if2.speedAir());
            }
        });
    }

    public static void sortToMin(IFly [] iFlyes){
        Arrays.sort(iFlyes, new Comparator<IFly>() {
            @Override
            public int compare(IFly if1, IFly if2) {
                return (int)(if2.speedAir()-if1.speedAir());
            }
        });
    }

    public static void findISwimAble(VehicleArray vehicles){
        VehicleArray cars = new VehicleArray();

        for (int i = 0; i < vehicles.size(); i++) {
            if(vehicles.getElement(i) instanceof ISwim){
                cars.addElement(vehicles.getElement(i));
            }
        }
        ISwim [] iSwims = new ISwim[cars.size()];
        for (int i = 0; i <cars.size(); i++) {
            iSwims[i] = (ISwim) cars.getElement(i);
            System.out.println(iSwims[i]);
        }
        System.out.println("Sorted to MAX:");
        sortToMax(iSwims);
        for (ISwim iSwim : iSwims) {
            System.out.println(iSwim);
        }

        System.out.println("Sorted to MIN:");
        sortToMin(iSwims);
        for (ISwim iSwim : iSwims) {
            System.out.println(iSwim);
        }
    }

    public static void sortToMax(ISwim [] iSwims){
        Arrays.sort(iSwims, new Comparator<ISwim>() {
            @Override
            public int compare(ISwim is1, ISwim is2) {
                return (int)(is1.speedWater()-is2.speedWater());
            }
        });
    }

    public static void sortToMin(ISwim [] iSwims){
        Arrays.sort(iSwims, new Comparator<ISwim>() {
            @Override
            public int compare(ISwim is1, ISwim is2) {
                return (int)(is2.speedWater()-is1.speedWater());
            }
        });
    }
}
