package tours_model;

import org.junit.Assert;
import org.junit.Test;

public class CruiseTourTotalPriceToStringTest extends OutputTest {
    private CruiseTour cruiseTour = new CruiseTour();

    @Test
    public void toStringExecuteAssertion(){
        cruiseTour.setTotalPriceDisplay(759);
        String expected = "Total price of your Cruise tour including chosen options: 759$\r\n";
        Assert.assertEquals(expected, output.toString());
    }
}
