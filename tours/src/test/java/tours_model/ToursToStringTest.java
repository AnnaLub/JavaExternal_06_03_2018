package tours_model;

import org.junit.Assert;
import org.junit.Test;

public class ToursToStringTest {
    private Tour shoppingTour = new ShoppingTour();

    @Test
    public void ToursToStringAssert(){
        String expected =  "Tour{'Shopping tour', pricePerDay=5}";
        Assert.assertEquals(expected,shoppingTour.toString());
    }
}
