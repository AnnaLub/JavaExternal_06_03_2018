package tours_model;

public class StaticMethodSortByPrice {

    public static Tour[] sortByPrice(Tour[] tourTypes){
        for (int i = tourTypes.length-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (tourTypes[j].getPrice()>tourTypes[j+1].getPrice()){
                    Tour tmp = tourTypes[j];
                    tourTypes[j] = tourTypes[j+1];
                    tourTypes[j+1] = tmp;
                }
            }
        }
        return tourTypes;
    }
}
