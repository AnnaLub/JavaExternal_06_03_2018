package tours_model;

public class CruiseTour extends Tour{
    private static final String NAME = "Cruise tour";
    private static final int PRICE = 40;

    public CruiseTour() {
        setTourName(this.NAME);
        setPrice(this.PRICE);
    }
}
