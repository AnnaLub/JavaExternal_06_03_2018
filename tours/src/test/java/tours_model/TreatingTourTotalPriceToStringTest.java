package tours_model;

import org.junit.Assert;
import org.junit.Test;

public class TreatingTourTotalPriceToStringTest extends OutputTest {
    private TreatingTour treatingTour = new TreatingTour();

    @Test
    public void toStringExecuteAssertion(){
        treatingTour.setTotalPriceDisplay(2299);
        String expected = "Total price of your Treating tour including chosen options: 2299$\r\n";
        Assert.assertEquals(expected, output.toString());
    }
}
