package tours_model;

import org.junit.Assert;
import org.junit.Test;

public class ExcursionTourTotalPriceToStringTest extends OutputTest {
    private ExcursionTour excursionTour = new ExcursionTour();

    @Test
    public void toStringExecuteAssertion(){
        excursionTour.setTotalPriceDisplay(120);
        String expected = "Total price of your Excursion tour including chosen options: 120$\r\n";
        Assert.assertEquals(expected, output.toString());
    }
}
