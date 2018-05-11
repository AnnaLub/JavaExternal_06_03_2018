package outputdata_parsing;

public class RPNStack {
    private int maxSize;
    private double[]inputArray;
    private int top;

    public RPNStack(int s){
        maxSize = s;
        inputArray = new double[maxSize];
        top = -1;
    }

    public void push(double i){
        inputArray[++top] = i;
    }

    public double pop(){
        return inputArray[top--];
    }

    public double peek(){
        return inputArray[top];
    }

    public boolean isEmpty(){
        return (top == -1);
    }

    public int size(){
        return top+1;
    }

    public double peekN(int n){
        return inputArray[n];
    }

    public void displayStack(String s){
        System.out.print(s);
        System.out.print("Stack (bottom->top): ");
        for (int i = 0; i < size(); i++) {
            System.out.print(peekN(i));
            System.out.print(' ');
        }
        System.out.println(" ");
    }
}
