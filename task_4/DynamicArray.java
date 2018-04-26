package task_4;

/*создать динамический массив из разных фигур и вывести информацию на экран*/

public class DynamicArray {
    private Figure [] figures;
    private int index;

    public DynamicArray() {
        this.index = -1;
        figures = new Figure[1];
    }

    public Figure getElement(int index) {
        if (index >= figures.length) {
            return null;
        } else{
            return figures[index];
        }
    }

    public int size(){
        return figures.length;
    }

    public void addElement(Figure figure){
        if(index<figures.length-1){
            figures[++index]=figure;
        }else {
            int newSize = figures.length + 1;
            Figure[] temporaryArray = new Figure[newSize];
            System.arraycopy(figures, 0, temporaryArray, 0, figures.length);
            figures = temporaryArray;
            figures[++index]=figure;
        }
    }
}
