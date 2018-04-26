package tours_model;

import org.junit.Assert;
import org.junit.Test;

public class RecreationTourTotalPriceToStringTest extends OutputTest{
    private RecreationTour recreationTour = new RecreationTour();

    @Test
    public void toStringExecuteAssertion(){
        recreationTour.setTotalPriceDisplay(339);
        String expected = "Total price of your Recreation tour including chosen options: 339$\r\n";
        Assert.assertEquals(expected, output.toString());
    }
}