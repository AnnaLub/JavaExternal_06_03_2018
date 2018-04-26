package tours_model;

public interface ICommand {
    void execute() throws NoSuchTransportException, NoSuchMealTypeException, NoSuchNumberOfDaysException;
}
