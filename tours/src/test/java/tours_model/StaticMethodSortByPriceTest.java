package tours_model;

import org.junit.Test;
import static org.junit.Assert.*;

public class StaticMethodSortByPriceTest {
    private static Tour[] tourTypes = {new RecreationTour(), new ExcursionTour(), new TreatingTour(),
            new ShoppingTour(), new CruiseTour()};

    @Test
    public void sortByPrice() {
        StaticMethodSortByPrice.sortByPrice(tourTypes);
        int [] sortedByPriceActual = new int[tourTypes.length];
        for (int i = 0; i < sortedByPriceActual.length; i++) {
            sortedByPriceActual[i]=tourTypes[i].getPrice();
        }
        int [] sortedByPriceExpected = {5,10,40,50,100};
        assertArrayEquals(sortedByPriceExpected,sortedByPriceActual);
    }

    @Test(expected = NullPointerException.class)
    public void sortByPriceNullPointer() {
        StaticMethodSortByPrice.sortByPrice(null);
        int [] sortedByPriceActual = new int[tourTypes.length];
        for (int i = 0; i < sortedByPriceActual.length; i++) {
            sortedByPriceActual[i]=tourTypes[i].getPrice();
        }
        assertNull(sortedByPriceActual);
    }

    @Test
    public void sortByPriceNotNullPointer() {
        StaticMethodSortByPrice.sortByPrice(tourTypes);
        int [] sortedByPriceActual = new int[tourTypes.length];
        for (int i = 0; i < sortedByPriceActual.length; i++) {
            sortedByPriceActual[i]=tourTypes[i].getPrice();
        }
        assertNotNull(sortedByPriceActual);
    }
}