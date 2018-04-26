package console_menu;

import vehicle_prototype.*;

public class Application {
    public static void main(String[] args) {

        VehicleArray va = new VehicleArray();
        va.addElement(new CCar("Tesla roadster",10,20,30,79000,400.0,2020,1,new TransmissionPrototype(1)));
        CCar cCar1=new CCar("One",1,1,1,33333,333.0,2020,1,new TransmissionPrototype(1));
        va.addElement(new CCar("BMW",20,30,40,49999,256.0,2002,3,new TransmissionPrototype(2)));
        va.addElement(new CCar("Mercedes",30,40,50,59000,300.0,2000,3,new TransmissionPrototype(2)));
        va.addElement(new CCar("Skoda",40,50,60,2900,140.0,1998,3, new TransmissionPrototype(2)));
        va.addElement(new CPlane("MRIYA AN-225",15,30,45,150000000,800.0,1988,1, new TransmissionPrototype(1),500,10.000));
        va.addElement(new CPlane("STARWARS X-wing T-65",101,111,121,999999999,299792.458,2099,1,new TransmissionPrototype(1),100000,999999999.99));
        va.addElement(new CPlane("Boing-777",7,7,7,100000000,1200.0,2017,1,new TransmissionPrototype(1),100,10.000));
        va.addElement(new CShip("Windrose",21,12,21,1500000,80.0,2017,2, new TransmissionPrototype(2),21,"Istambul"));
        va.addElement(new CShip("Arkadia",101,121,111,129000,40.0,1956,2,new TransmissionPrototype(2),156,"Odessa"));
        va.addElement(new CShip("Gudson",1,1,1,999999,60.0,2015,1,new TransmissionPrototype(2), 211,"New York"));
        va.addElement(new CCarAmphibio("Amphibio1", 1,1,1,1000000,550,2029,1,new TransmissionPrototype(1)));
        va.addElement(new CCarAmphibio("Amphibio2", 1,1,1,1000000,660,2030,1,new TransmissionPrototype(1)));
        va.addElement(new CCarAmphibio("Amphibio3", 1,1,1,1000000,770,2031,1,new TransmissionPrototype(1)));
        va.addElement(new CCarBatMobile("Batmobile1",0,0,0,1111111,400,2040,1,new TransmissionPrototype(1)));
        va.addElement(new CCarBatMobile("Batmobile2",0,0,0,2222222,500,2041,1,new TransmissionPrototype(1)));
        va.addElement(new CCarBatMobile("Batmobile3",0,0,0,3333333,600,2042,1,new TransmissionPrototype(1)));

        Menu menu = new Menu();

        menu.run(va);

    }
}
