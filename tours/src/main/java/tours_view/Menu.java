package tours_view;

import tours_controller.*;
import tours_model.*;

import java.util.Scanner;

public final class Menu {
   private ConsoleCommands consoleCommands = new ConsoleCommands();
   private static int chosenTransport = 0;
   private static int chosenMenu = 0;
   private static int chosenNumberOfDays = 0;
   private static Tour[] tourTypes = {new RecreationTour(), new ExcursionTour(), new TreatingTour(),
            new ShoppingTour(), new CruiseTour()};


    public static int getChosenTransport() {
        return chosenTransport;
    }

    public static int getChosenMenu() {
        return chosenMenu;
    }

    public static int getChosenNumberOfDays() {
        return chosenNumberOfDays;
    }

    private static void displayEnties(String [] menuArray){
        for (int i = 0; i < menuArray.length; i++) {
            System.out.println((i+1) + ". " + menuArray[i]);
        }
    }

    private static void addEntries(){
        String [] menuArray = {
                "Recreation Tour",
                "Excursion tour",
                "Treatment tour",
                "Shopping tour",
                "Cruise tour",
                "Sort tour by price",
                "Enter 'E' to exit"
        };
       displayEnties(menuArray);
    }

    private static void addTransportMenu(){
        String [] menuArray = {
                "Airplane",
                "Bus",
                "Train",
                "No transport",
                "Enter 'E' to exit"
        };
       displayEnties(menuArray);
    }

    private static void addMealTypeMenu(){
        String [] menuArray = {
                "AI",
                "FB",
                "HB",
                "BB",
                "NA",
                "Enter 'E' to exit"
        };
        displayEnties(menuArray);
    }

    //метод для траспортного подменю
   private static int runTransportMenu(){
        boolean isExit = false;
        do{
            System.out.println("Please, select type of transport");
            Menu.addTransportMenu();
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()){
                int input = scanner.nextInt();
                if ((input <= 0) || (input > 4)){
                    System.out.println("Menu range is from 1 to 4");
                } else {
                    switch (input) {
                        case 1:
                            System.out.println("Airplane");
                            isExit=true;
                            chosenTransport=input;
                            break;
                        case 2:
                            System.out.println("Bus");
                            isExit=true;
                            chosenTransport=input;
                            break;
                        case 3:
                            System.out.println("Train");
                            isExit=true;
                            chosenTransport=input;
                            break;
                        case 4:
                            System.out.println("No transport");
                            isExit=true;
                            chosenTransport=input;
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
        return chosenTransport;
    }

    //метод для выбора еды подменю
   private static int runMealTypeMenu(){
        boolean isExit = false;
        do{
            System.out.println("Please, select menu type: ");
            Menu.addMealTypeMenu();
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()){
                int input = scanner.nextInt();
                if ((input <= 0) || (input > 5)){
                    System.out.println("Menu range is from 1 to 5");
                } else {
                    switch (input) {
                        case 1:
                            System.out.println("AI");
                            isExit=true;
                            chosenMenu=input;
                            break;
                        case 2:
                            System.out.println("FB");
                            isExit=true;
                            chosenMenu=input;
                            break;
                        case 3:
                            System.out.println("HB");
                            isExit=true;
                            chosenMenu=input;
                            break;
                        case 4:
                            System.out.println("BB");
                            isExit=true;
                            chosenMenu=input;
                            break;
                        case 5:
                            System.out.println("NA");
                            isExit=true;
                            chosenMenu=input;
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
        return chosenMenu;
    }

   private static int runNumberOfDaysMethod() {
        boolean correctNumberOfDays = false;
        System.out.println("Please, enter number of days between 3 and 14");
        do {
            Scanner scanner = new Scanner(System.in);

            if (scanner.hasNextInt()) {
                int input = scanner.nextInt();
                if ((input <= 2) || (input > 14)) {
                    System.out.println("You can enter number of days between 3 and 14");
                } else {
                    chosenNumberOfDays = input;
                    correctNumberOfDays=true;
                    System.out.println("Thank you!");
                }
            }
        } while (!correctNumberOfDays);
        return chosenNumberOfDays;
    }

    void run() throws NoSuchTransportException, NoSuchMealTypeException, NoSuchNumberOfDaysException {
        boolean isExit = false;
        do {
            Menu.addEntries();
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                int input = scanner.nextInt();
                if ((input <= 0) || (input > 6)) {
                    System.out.println("Menu range is from 1 to 6");
                } else {
                    switch (input){
                        case 1:
                            System.out.println("Recreation tour - nice choice!");
                            runTransportMenu();
                            runMealTypeMenu();
                            runNumberOfDaysMethod();
                            consoleCommands.setCommand(new SetRecreationTour(new RecreationTour()));
                            consoleCommands.consoleMenuTourChosen();
                            isExit=true;
                            break;
                        case 2:
                            System.out.println("Excursion tour - nice choice!");
                            runTransportMenu();
                            runMealTypeMenu();
                            runNumberOfDaysMethod();
                            consoleCommands.setCommand(new SetExcursionTour(new ExcursionTour()));
                            consoleCommands.consoleMenuTourChosen();
                            isExit=true;
                            break;
                        case 3:
                            System.out.println("Treating tour - nice choice!");
                            runTransportMenu();
                            runMealTypeMenu();
                            runNumberOfDaysMethod();
                            consoleCommands.setCommand(new SetTreatingTour(new TreatingTour()));
                            consoleCommands.consoleMenuTourChosen();
                            isExit=true;
                            break;
                        case 4:
                            System.out.println("Shopping tour - nice choice!");
                            runTransportMenu();
                            runMealTypeMenu();
                            runNumberOfDaysMethod();
                            consoleCommands.setCommand(new SetShoppingTour(new ShoppingTour()));
                            consoleCommands.consoleMenuTourChosen();
                            isExit=true;
                            break;
                        case 5:
                            System.out.println("Cruise tour - nice choice!");
                            runTransportMenu();
                            runMealTypeMenu();
                            runNumberOfDaysMethod();
                            consoleCommands.setCommand(new SetCruiseTour(new CruiseTour()));
                            consoleCommands.consoleMenuTourChosen();
                            isExit=true;
                            break;
                        case 6:
                            System.out.println("Sorted by price in increasing order:");
                            DisplayAllTourTypes.displayAllTourTypes(StaticMethodSortByPrice.sortByPrice(tourTypes));
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
