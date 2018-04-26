package tours_model;

public class DisplayAllTourTypes {

    public static void displayAllTourTypes(Tour [] tours)throws NullPointerException{
        for (Tour tourType : tours) {
            System.out.println(tourType.toString());
        }
    }
}


