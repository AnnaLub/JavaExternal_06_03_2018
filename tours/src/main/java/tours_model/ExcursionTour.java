package tours_model;

public class ExcursionTour extends Tour {
    private static final String NAME = "Excursion tour";
    private static final int PRICE = 10;

    public ExcursionTour() {
        setTourName(this.NAME);
        setPrice(this.PRICE);
    }
}
