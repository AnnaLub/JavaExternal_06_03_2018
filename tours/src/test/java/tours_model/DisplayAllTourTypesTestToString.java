package tours_model;

import org.junit.Assert;
import org.junit.Test;


public class DisplayAllTourTypesTestToString extends OutputTest{

    private Tour[] tourTypes = {new RecreationTour(),new ExcursionTour(), new TreatingTour(), new ShoppingTour(),
            new CruiseTour()};

        @Test
        public void toStringAssertion() {
            DisplayAllTourTypes.displayAllTourTypes(tourTypes);
            String expected = "Tour{'Recreation tour', pricePerDay=50}\r\nTour{'Excursion tour', pricePerDay=10}" +
                    "\r\nTour{'Treating tour', pricePerDay=100}\r\nTour{'Shopping tour', pricePerDay=5}" +
                    "\r\nTour{'Cruise tour', pricePerDay=40}\r\n";
            Assert.assertEquals(expected, output.toString());
        }
    }

