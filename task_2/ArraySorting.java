package task_2;

/* Сортировка последовательности:
   Упорядочить одномерный маcив - вначале отрицательные по возрастанию,
   затем положительные по убыванию */

public class ArraySorting {

    static void masSorting(int [] mas){
        for (int i = mas.length-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if((mas[j]<0 || mas[j+1]<0) && (mas[j]>mas[j+1])){
                    int tmp = mas[j];
                    mas[j]=mas[j+1];
                    mas[j+1] = tmp;
                }else if((mas[j]>0 && mas [j+1]>0) && (mas[j]<mas[j+1])){
                    int tmp = mas[j];
                    mas[j]=mas[j+1];
                    mas[j+1] = tmp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int [] mas = {42, -121, 112, 12, 1, 4, -2, -21, 221, -212};
        masSorting(mas);
        for (int i : mas) {
            System.out.println(i);
        }
    }
}
