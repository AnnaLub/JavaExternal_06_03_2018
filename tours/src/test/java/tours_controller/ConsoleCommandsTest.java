package tours_controller;

import org.junit.Test;
import tours_model.*;

import static org.junit.Assert.*;

public class ConsoleCommandsTest {
    ConsoleCommands consoleCommands;

    @Test
    public void setCommandSetRecreationTour() {
        ConsoleCommands consoleCommandsActual = new ConsoleCommands();
        consoleCommandsActual.setCommand(new SetRecreationTour(new RecreationTour()));
        assertNotNull(consoleCommandsActual);
    }

    @Test
    public void setCommandSetTreatingTour() {
        ConsoleCommands consoleCommandsActual = new ConsoleCommands();
        consoleCommandsActual.setCommand(new SetTreatingTour(new TreatingTour()));
        assertNotNull(consoleCommandsActual);
    }

    @Test
    public void setCommandSetCruiseTour() {
        ConsoleCommands consoleCommandsActual = new ConsoleCommands();
        consoleCommandsActual.setCommand(new SetCruiseTour(new CruiseTour()));
        assertNotNull(consoleCommandsActual);
    }

    @Test
    public void setCommandSetShoppingTour() {
        ConsoleCommands consoleCommandsActual = new ConsoleCommands();
        consoleCommandsActual.setCommand(new SetShoppingTour(new ShoppingTour()));
        assertNotNull(consoleCommandsActual);
    }

    @Test
    public void setCommandSetExcursionTour() {
        ConsoleCommands consoleCommandsActual = new ConsoleCommands();
        consoleCommandsActual.setCommand(new SetExcursionTour(new ExcursionTour()));
        assertNotNull(consoleCommandsActual);
    }

    @Test(expected = NullPointerException.class)
    public void setCommandSetRecreationTourNullPointerException() {
        consoleCommands.setCommand(new SetRecreationTour(new RecreationTour()));
        assertNull(consoleCommands);
    }

    @Test(expected = NullPointerException.class)
    public void setCommandSetTreatingTourNullPointerException() {
        consoleCommands.setCommand(new SetTreatingTour(new TreatingTour()));
        assertNull(consoleCommands);
    }

    @Test(expected = NullPointerException.class)
    public void setCommandSetCruiseTourNullPointerException() {
        consoleCommands.setCommand(new SetCruiseTour(new CruiseTour()));
        assertNull(consoleCommands);
    }

    @Test(expected = NullPointerException.class)
    public void setCommandSetShoppingTourNullPointerException() {
        consoleCommands.setCommand(new SetShoppingTour(new ShoppingTour()));
        assertNull(consoleCommands);
    }

    @Test(expected = NullPointerException.class)
    public void setCommandSetExcursionTourNullPointerException() {
        consoleCommands.setCommand(new SetExcursionTour(new ExcursionTour()));
        assertNull(consoleCommands);
    }

    @Test
    public void setCommandSetRecreationTourNotNull() {
        consoleCommands = new ConsoleCommands();
        consoleCommands.setCommand(new SetRecreationTour(new RecreationTour()));
        assertNotNull(consoleCommands);
    }

    @Test
    public void setCommandSetTreatingTourNotNull() {
        consoleCommands = new ConsoleCommands();
        consoleCommands.setCommand(new SetTreatingTour(new TreatingTour()));
        assertNotNull(consoleCommands);
    }

    @Test
    public void setCommandSetCruiseTourNotNull() {
        consoleCommands = new ConsoleCommands();
        consoleCommands.setCommand(new SetCruiseTour(new CruiseTour()));
        assertNotNull(consoleCommands);
    }

    @Test
    public void setCommandSetShoppingTourNotNull() {
        consoleCommands = new ConsoleCommands();
        consoleCommands.setCommand(new SetShoppingTour(new ShoppingTour()));
        assertNotNull(consoleCommands);
    }

    @Test
    public void setCommandSetExcursionTourNotNull() {
        consoleCommands = new ConsoleCommands();
        consoleCommands.setCommand(new SetExcursionTour(new ExcursionTour()));
        assertNotNull(consoleCommands);
    }

    @Test(expected = NullPointerException.class)
    public void setCommandSetRecreationTourObjectNotNull() throws NoSuchMealTypeException, NoSuchTransportException, NoSuchNumberOfDaysException {
        consoleCommands = new ConsoleCommands();
        consoleCommands.setCommand(null);
        consoleCommands.consoleMenuTourChosen();
        assertNull(consoleCommands);
    }

   @Test(expected = NullPointerException.class)
    public void setCommandSetTreatingTourObjectNotNull() throws NoSuchMealTypeException, NoSuchTransportException, NoSuchNumberOfDaysException {
        consoleCommands = new ConsoleCommands();
        consoleCommands.setCommand(null);
        consoleCommands.consoleMenuTourChosen();
        assertNull(consoleCommands);
    }

    @Test(expected = NullPointerException.class)
    public void setCommandSetCruiseTourObjectNotNull() throws NoSuchMealTypeException, NoSuchTransportException, NoSuchNumberOfDaysException {
        consoleCommands = new ConsoleCommands();
        consoleCommands.setCommand(null);
        consoleCommands.consoleMenuTourChosen();
        assertNull(consoleCommands);
    }

    @Test(expected = NullPointerException.class)
    public void setCommandSetShoppingTourObjectNotNull() throws NoSuchMealTypeException, NoSuchTransportException, NoSuchNumberOfDaysException {
        consoleCommands = new ConsoleCommands();
        consoleCommands.setCommand(null);
        consoleCommands.consoleMenuTourChosen();
        assertNull(consoleCommands);
    }

    @Test(expected = NullPointerException.class)
    public void setCommandSetExcursionTourObjectNotNull() throws NoSuchMealTypeException, NoSuchTransportException, NoSuchNumberOfDaysException {
        consoleCommands = new ConsoleCommands();
        consoleCommands.setCommand(null);
        consoleCommands.consoleMenuTourChosen();
        assertNull(consoleCommands);
    }

    @Test(expected = NoSuchTransportException.class)
    public void consoleMenuExcursionTourChosen() throws NoSuchMealTypeException, NoSuchTransportException, NoSuchNumberOfDaysException {
        consoleCommands = new ConsoleCommands();
        consoleCommands.setCommand(new SetExcursionTour(new ExcursionTour()));
        consoleCommands.consoleMenuTourChosen();
        assertNotNull(consoleCommands);
    }

    @Test(expected = NoSuchTransportException.class)
    public void consoleMenuRecreationTourChosen() throws NoSuchMealTypeException, NoSuchTransportException, NoSuchNumberOfDaysException {
        consoleCommands = new ConsoleCommands();
        consoleCommands.setCommand(new SetRecreationTour(new RecreationTour()));
        consoleCommands.consoleMenuTourChosen();
        assertNotNull(consoleCommands);
    }

    @Test(expected = NoSuchTransportException.class)
    public void consoleMenuCruiseTourChosen() throws NoSuchMealTypeException, NoSuchTransportException, NoSuchNumberOfDaysException {
        consoleCommands = new ConsoleCommands();
        consoleCommands.setCommand(new SetCruiseTour(new CruiseTour()));
        consoleCommands.consoleMenuTourChosen();
        assertNotNull(consoleCommands);
    }

    @Test(expected = NoSuchTransportException.class)
    public void consoleMenuTreatingTourChosen() throws NoSuchMealTypeException, NoSuchTransportException, NoSuchNumberOfDaysException {
        consoleCommands = new ConsoleCommands();
        consoleCommands.setCommand(new SetTreatingTour(new TreatingTour()));
        consoleCommands.consoleMenuTourChosen();
        assertNotNull(consoleCommands);
    }

    @Test(expected = NoSuchTransportException.class)
    public void consoleMenuShoppingTourChosen() throws NoSuchMealTypeException, NoSuchTransportException, NoSuchNumberOfDaysException {
        consoleCommands = new ConsoleCommands();
        consoleCommands.setCommand(new SetShoppingTour(new ShoppingTour()));
        consoleCommands.consoleMenuTourChosen();
        assertNotNull(consoleCommands);
    }
}