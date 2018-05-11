package inputdata_inversion;

public class InputStack {
    private int maxSize;
    private String[] inputArray;
    private int top;

    public InputStack(int s){
        maxSize = s;
        inputArray = new String[maxSize];
        top = -1;
    }

    public void push(String ch){
        inputArray[++top] = ch;
    }

    public String pop(){
        return inputArray[top--];
    }

    public String peek(){
        return inputArray[top];
    }

    public boolean isEmpty(){
        return (top == -1);
    }

    public int size(){
        return top+1;
    }

    public String peekN(int n){
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
