package tours_model;

public class Tour implements ISetTransport, ISetMealType, ISetNumberOfDays, ICalculateTotalPrice{
    private String tourName;
    private int pricePerDay;
    private int transportPrice;
    private int mealTypePrice;
    private int numberOfDays;
    private int totalPrice;

    public Tour() {
    }

    protected final void setPrice(int price) {
        this.pricePerDay = price;
    }

    protected final void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public final int getPrice() {
        return pricePerDay;
    }

    public final String getTourName() {
        return tourName;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    @Override
    public final int setTransportType(int transportType) throws NoSuchTransportException{
        switch(transportType){
            case 1:
                transportPrice = AirplanePrice;
                break;
            case 2:
                transportPrice = BusPrice;
                break;
            case 3:
                transportPrice = TrainPrice;
                break;
            case 4:
                transportPrice = NoTransportPrice;
                break;
            default:
                throw new NoSuchTransportException("There is no such a transport"+transportType);
        }
        return transportPrice;
    }


    @Override
    public final int setMealType(int mealType) throws NoSuchMealTypeException {
        switch (mealType) {
            case 1:
               mealTypePrice = AIPrice;
               break;
            case 2:
               mealTypePrice = FBPrice;
               break;
            case 3:
                mealTypePrice = HBPrice;
                break;
            case 4:
                mealTypePrice = BBPrice;
                break;
            case 5:
                mealTypePrice = NAPrice;
                break;
            default:
                throw new NoSuchMealTypeException("There is no such a meal type"+mealTypePrice);
        }
        return mealTypePrice;
    }

    @Override
    public final int setNumberOfDays(int enteredNumberOfDays) throws NoSuchNumberOfDaysException {
        if (enteredNumberOfDays > 2 && enteredNumberOfDays < 15) {
            numberOfDays = enteredNumberOfDays;
        }else{
            throw new NoSuchNumberOfDaysException("There is no such a number of days" + enteredNumberOfDays);
        }
        return numberOfDays;
    }

    @Override
    public final int totalPriceCalculation(int transportPrice, int mealTypePrice, int numberOfDays) {
        totalPrice = (this.transportPrice+(this.mealTypePrice+this.pricePerDay)*this.numberOfDays);
        return totalPrice;
    }

    public final void setTotalPriceDisplay(int totalPrice){
        System.out.println("Total price of your " + this.getTourName()+ " including chosen options: "
                +totalPrice+"$");
    }

    @Override
    public String toString() {
        return "Tour{'" +
                this.getTourName() + '\'' +
                ", pricePerDay=" + this.getPrice() +
                '}';
    }
}
