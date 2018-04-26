package task_2;

/* Сортировка последовательности:
   В одномерном массиве сначала положительные потом отрицательные за О(n)*/

public class ArraySortingPositiveThenNegative {
    static void sortingArray(int [] mas){
        int count = mas.length-1;
        boolean flag;
        for (int i = 0; i < count; i++) {
            if(mas[i]<0){
                flag=true;
                while (flag){
                    if(mas[count]>0){
                        int tmp = mas[i];
                        mas[i] = mas[count];
                        mas[count] = tmp;
                        count--;
                        flag=false;
                    }else{
                        count--;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int [] mas = {-42, -121, 112, 4, 67, -57, 49, -12, 1, -4, -2, -21, 221, -441, -212};
        sortingArray(mas);
        for (int i : mas) {
            System.out.println(i);
        }
    }
}
