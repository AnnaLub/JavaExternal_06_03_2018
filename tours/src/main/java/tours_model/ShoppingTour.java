package tours_model;

public class ShoppingTour extends Tour {
    private static final String NAME = "Shopping tour";
    private static final int PRICE = 5;

    public ShoppingTour() {
        setTourName(this.NAME);
        setPrice(this.PRICE);
    }
}
