package task_3;

/*Упорядочить строки, по возрастанию по самой длинной серии одинаковых элементов.*/

public class MatrixSortingRows {

    /*counts the biggest number of repeated elements in a row of matrix*/
    static int countRepeted(int [] mas){
        int counter = 1;
        int repeated = 1;
        for (int i = 0; i < mas.length-1; i++) {
            if(mas[i]==mas[i+1]){
                repeated++;
            }else{
                repeated=1;
            }
            if(repeated>counter){
                counter=repeated;
            }
        }
        return counter;
    };

    /* swap two columns of matrix */
    static void swap(int[] mas1, int[] mas2){
        for (int i = 0; i < mas1.length; i++) {
            int tmp = mas1[i];
            mas1[i]=mas2[i];
            mas2[i]=tmp;
        }
    }

    /*sorting rows by increasing the biggest number of repeated elements in a row */
    static void sortingIncreasing(int [][] mas){
        for (int i = mas.length-1; i > 0; i--) {
            for (int j = 0; j < i ; j++) {
                if(countRepeted(mas[j])>countRepeted(mas[j+1])){
                    swap(mas[j],mas[j+1]);
                }
            }
        }
    };

    /* prints matrix to console */
    static void printMatrix(int [][] mas){
        for (int i = 0; i <mas.length; i++) {
            for (int j = 0; j <mas[i].length ; j++) {
                System.out.print(mas[i][j]+", ");
            }
            System.out.println();
        }
    }
}
