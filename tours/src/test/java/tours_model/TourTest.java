package tours_model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TourTest {
    private Tour tourTest;

    @Before
    public void initTourTest(){
        tourTest = new Tour();
    }
    @After
    public void clearTourTest(){
        tourTest = null;
    }

    @Test
    public void totalPriceCalculationNormalBehaviour() throws NoSuchTransportException, NoSuchMealTypeException, NoSuchNumberOfDaysException {
        tourTest.setPrice(100);
       int transportPrice = tourTest.setTransportType(1);
       int mealTypePrice =  tourTest.setMealType(1);
       int numberOfDays = tourTest.setNumberOfDays(14);

        int totalPriceExpected = tourTest.totalPriceCalculation(transportPrice,mealTypePrice,numberOfDays);
        assertEquals("Normal behavior correct!",totalPriceExpected,2299);
    }

    //should have thrown first Exception(NoSuchTransportException)
    @Test (expected = NoSuchTransportException.class)
    public void totalPriceCalculationAbnormalBehaviour() throws NoSuchTransportException, NoSuchMealTypeException, NoSuchNumberOfDaysException {
        tourTest.setPrice(0);
        int transportPrice = tourTest.setTransportType(0);
        int mealTypePrice =  tourTest.setMealType(0);
        int numberOfDays = tourTest.setNumberOfDays(0);

        int totalPriceExpected = tourTest.totalPriceCalculation(transportPrice,mealTypePrice,numberOfDays);
        assertEquals("Abnormal behaviour correct!",totalPriceExpected,0);
    }


    @Test
    public void setNormalTransportTypeOne() throws NoSuchTransportException {
        int normalTransportTypeValueOne = tourTest.setTransportType(1);
        assertEquals(normalTransportTypeValueOne,199);
    }

    @Test
    public void setNormalTransportTypeTwo() throws NoSuchTransportException {
        int normalTransportTypeValueTwo = tourTest.setTransportType(2);
        assertEquals(normalTransportTypeValueTwo,49);
    }

    @Test
    public void setNormalTransportTypeThree() throws NoSuchTransportException {
        int normalTransportTypeValueTwo = tourTest.setTransportType(3);
        assertEquals(normalTransportTypeValueTwo,99);
    }

    @Test
    public void setNormalTransportTypeFour() throws NoSuchTransportException {
        int normalTransportTypeValueTwo = tourTest.setTransportType(4);
        assertEquals(normalTransportTypeValueTwo,0);
    }

    @Test
    public void setNormalTransportTypeAbnormalBehaviour() throws NoSuchTransportException {
        int normalTransportTypeValueTwo = tourTest.setTransportType(3);
        assertNotEquals(normalTransportTypeValueTwo,0);
    }

    @Test(expected = NoSuchTransportException.class)
    public void setAbnormalTransportTypeMinimum() throws NoSuchTransportException {
        int abnormalTransportTypeValue = tourTest.setTransportType(0);
        assertEquals(abnormalTransportTypeValue,0);
    }

    @Test(expected = NoSuchTransportException.class)
    public void setAbnormalTransportTypeMaximum() throws NoSuchTransportException {
        int abnormalTransportTypeValue = tourTest.setTransportType(5);
        assertEquals(abnormalTransportTypeValue,0);
    }

    @Test
    public void setAbnormalTransportTypeExceptionMessageCheck() {
        int abnormalTransportTypeValue = 0;
        try {
            abnormalTransportTypeValue = tourTest.setTransportType(0);
            fail("Test for Transport Type set failed"+abnormalTransportTypeValue+"should have thrown a NoSuchTransportException");
        } catch (NoSuchTransportException e) {
            assertEquals("There is no such a transport" + abnormalTransportTypeValue,e.getMessage());
        }
    }

    @Test
    public void setMealTypeOne() throws NoSuchMealTypeException {
        int mealTypeValueExpected = tourTest.setMealType(1);
        assertEquals(mealTypeValueExpected,50);
    }

    @Test
    public void setMealTypeTwo() throws NoSuchMealTypeException {
        int mealTypeValueExpected = tourTest.setMealType(2);
        assertEquals(mealTypeValueExpected,40);
    }

    @Test
    public void setMealTypeThree() throws NoSuchMealTypeException {
        int mealTypeValueExpected = tourTest.setMealType(3);
        assertEquals(mealTypeValueExpected,30);
    }

    @Test
    public void setMealTypeFour() throws NoSuchMealTypeException {
        int mealTypeValueExpected = tourTest.setMealType(4);
        assertEquals(mealTypeValueExpected,20);
    }

    @Test
    public void setMealTypeFourAbnormalBehaviour() throws NoSuchMealTypeException {
        int mealTypeValueExpected = tourTest.setMealType(3);
        assertNotEquals("Meal type is wrong!", mealTypeValueExpected,20);
    }

    @Test
    public void setMealTypeFive() throws NoSuchMealTypeException {
        int mealTypeValueExpected = tourTest.setMealType(5);
        assertEquals(mealTypeValueExpected,0);
    }

    @Test(expected = NoSuchMealTypeException.class)
    public void setAbnormalMealTypeMinimum() throws NoSuchMealTypeException {
        int mealTypeValueExpected = tourTest.setMealType(0);
        assertEquals(mealTypeValueExpected,0);
    }

    @Test(expected = NoSuchMealTypeException.class)
    public void setAbnormalMealTypeMaximum() throws NoSuchMealTypeException {
        int mealTypeValueExpected = tourTest.setMealType(6);
        assertEquals(mealTypeValueExpected,0);
    }

    @Test
    public void setAbnormalMealTypeExceptionMessageCheck(){
        int abnormalMealTypeValueExpected = 0;
        try{
            abnormalMealTypeValueExpected = tourTest.setMealType(0);
            fail("Test for Meal Type set failed" + abnormalMealTypeValueExpected+
                    "should have thrown a NoSuchMealTypeException");
        }catch (NoSuchMealTypeException e){
            assertEquals("There is no such a meal type" + abnormalMealTypeValueExpected, e.getMessage());
        }
    }

    @Test
    public void setNormalNumberOfDays() throws NoSuchNumberOfDaysException {
        int normalNumberOfDays = tourTest.setNumberOfDays(3);
        assertEquals(normalNumberOfDays,3);
    }

    @Test(expected = NoSuchNumberOfDaysException.class)
    public void setAbnormalNumberOfDaysMinimum() throws NoSuchNumberOfDaysException {
        int abNormalNumberOfDays = tourTest.setNumberOfDays(2);
        assertEquals(abNormalNumberOfDays,0);
    }

    @Test(expected = NoSuchNumberOfDaysException.class)
    public void setAbnormalNumberOfDaysMaximum() throws NoSuchNumberOfDaysException {
        int abNormalNumberOfDays = tourTest.setNumberOfDays(15);
        assertEquals(abNormalNumberOfDays,0);
    }
    @Test
    public void setAbnormalNumberOfDaysExceptionMessageCheck(){
        int abnormalNumberOfDaysExpected = 0;
        try{
            abnormalNumberOfDaysExpected = tourTest.setNumberOfDays(0);
            fail("Test for Number Of Days set failed" + abnormalNumberOfDaysExpected+
                    "should have thrown a NoSuchNumberOfDaysException");
        }catch (NoSuchNumberOfDaysException e){
            assertEquals("There is no such a number of days" + abnormalNumberOfDaysExpected,
                    e.getMessage());
        }
    }
}