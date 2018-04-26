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

    public static void main(String[] args) {
            int [][] mas = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
            int [][] arr = {{1,8,21,16},{4,2,11,42},{39,15,3,5}};
            int [][] arr1 = {{-4,2,-11,42},{1,-8,21,-16},{-39,15,-3,5}};
       /* sortingDecreasing(mas);
        printMatrix(mas);*/
       /*getAverage(arr,0);
        printMatrix(arr);*/
        /*printMatrix(arr1);
        System.out.println();
        sortingDecreasing(arr1);
        printMatrix(arr1);*/
            System.out.println();
            printMatrix(mas);
            System.out.println();
            sortingDecreasing(mas);
            printMatrix(mas);
        }
    }

