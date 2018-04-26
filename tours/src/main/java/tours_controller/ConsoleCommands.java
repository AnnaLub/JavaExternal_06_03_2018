package tours_controller;

import tours_model.*;

public class ConsoleCommands{
   private ICommand ConsoleCommand;

    public ConsoleCommands() {
    }

    public void setCommand(ICommand command) {
        ConsoleCommand = command;
    }

    public void consoleMenuTourChosen() throws NoSuchTransportException, NoSuchMealTypeException, NoSuchNumberOfDaysException {
        ConsoleCommand.execute();
    }

}
