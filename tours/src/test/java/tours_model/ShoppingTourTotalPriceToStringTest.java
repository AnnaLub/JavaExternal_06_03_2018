package tours_model;

import org.junit.Assert;
import org.junit.Test;

public class ShoppingTourTotalPriceToStringTest extends OutputTest {
    private ShoppingTour shoppingTour = new ShoppingTour();

    @Test
    public void toStringExecuteAssertion(){
        shoppingTour.setTotalPriceDisplay(229);
        String expected = "Total price of your Shopping tour including chosen options: 229$\r\n";
        Assert.assertEquals(expected, output.toString());
    }
}
