package task_3;

/* Алгоритм:
   1. Вычисляем ср.арифметическое n-го столбца массива;
   2. Вычисляем ср.арифметическое (n+1) столбца массива;
   3. Проверяем выполнение логического условия (n<(n+1));
   4. Если boolean true - делаем swap;
      Используем bubble sort, проход по внутреннему масиву. */

public class MatrixSortingColumns {

    /* return average value of matrix columns */
    static double getAverage(int [][] mas, int j){
        double sum = 0;
        double average = 0;
        for (int i = 0; i < mas.length; i++) {
            sum+=mas[i][j];
        }
        average=sum/mas.length;
        return average;
    };

    /* swap two columns of matrix */
    static void swap(int[][] mas, int j){
        for (int i = 0; i < mas.length; i++) {
            int tmp = mas[i][j];
            mas[i][j]=mas[i][j+1];
            mas[i][j+1]=tmp;
        }
    }

    /* sorting method by average value of columns from higher to lower */
    static void sortingDecreasing(int[][]mas){
        for (int i = 0; i < mas.length-1; i++) {
            boolean swapped = false;
            for (int j = 0; j < mas[i].length-1; j++) {
                for (int k = 0; k < mas[i].length-1-j; k++) {
                    if(getAverage(mas,k)<getAverage(mas,k+1)){
                        swap(mas,k);
                        swapped=true;
                    }
                }
            }
            if(!swapped){
                break;
            }
        }
    }

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
