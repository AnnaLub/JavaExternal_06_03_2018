package tours_model;

public interface ISetMealType {
    int AIPrice = 50;
    int FBPrice = 40;
    int HBPrice = 30;
    int BBPrice = 20;
    int NAPrice = 0;

    int setMealType(int mealType) throws NoSuchMealTypeException;

}
