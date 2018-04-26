package console_menu;

import console_methods.ConsoleMethods;
import vehicle_prototype.VehicleArray;

import java.util.Scanner;

public class Menu {
    VehicleArray va = new VehicleArray();


    public static void addEntries(){
        String [] menuArray = {
                "The most expensive Vehicle",
                "Vehicle modelYear: 2000-2005, with speed that exceed 150km/h and has lowest price",
                "From Vehicle array get Car array, with Cars not older than 5 years",
                "From the Vehicle array, get the Ship array not older than 5 years, with a sorted price in descending order",
                "Find iMoveAble and sort to MAX and to MIN",
                "Find iFlyAble and sort to MAX and to MIN",
                "Find iSwimAble and sort to MAX and to MIN",
                "Enter 'E' to exit"
        };
        for (int i = 0; i < menuArray.length; i++) {
                System.out.println((i+1) + ". " + menuArray[i]);
            }
        }

    void run(VehicleArray va){
        boolean isExit = false;
        do {
            Menu.addEntries();
            Scanner scanner = new Scanner(System.in);
                if (scanner.hasNextInt()) {
                    int input = scanner.nextInt();
                    if ((input <= 0) || (input > 7)) {
                        System.out.println("Menu range is from 1 to 7");
                    } else {
                        switch (input) {
                            case 1:
                                ConsoleMethods.getBiggestPrice(va);
                                break;
                            case 2:
                                ConsoleMethods.findByYearThanBySpeedThanByPrice(va);
                                break;
                            case 3:
                                ConsoleMethods.findCarsNotOlderThanFiveYears(va);
                                break;
                            case 4:
                                ConsoleMethods.findShipsAndSortByPriceInDescendingOrder(va);
                                break;
                            case 5:
                                ConsoleMethods.findIMoveAble(va);
                                break;
                            case 6:
                                ConsoleMethods.findIFlyAble(va);
                                break;
                            case 7:
                                ConsoleMethods.findISwimAble(va);
                                break;
                        }
                    }
                } else {
                    String inputString=scanner.nextLine();
                    if (inputString.equals("E")) {
                        isExit = true;
                        System.out.println("Program is closed");
                    }else {
                        System.out.println("Incorrect request");
                    }
                }
        }while (!isExit);
    }
}

