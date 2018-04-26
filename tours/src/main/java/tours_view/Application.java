package tours_view;

import tours_model.NoSuchMealTypeException;
import tours_model.NoSuchNumberOfDaysException;
import tours_model.NoSuchTransportException;

public class Application {

    public static void main(String[] args) throws NoSuchTransportException, NoSuchMealTypeException,
            NoSuchNumberOfDaysException {

        Menu menu = new Menu();
        menu.run();
    }
}
