package inputdata_inversion;

public class InputInversion {
    private InputStack inputStack;
    private String[] input;
    private String[] output;
    private int top;

    public InputInversion(String[] in) {
        input=in;
        int stackSize = input.length;
        inputStack = new InputStack(stackSize);
        output = new String[input.length];
        top = -1;
    }

    public String[] doTrans() {
        String function = "";
        for (int i = 0; i < input.length; i++) {
            String s = input[i];
            inputStack.displayStack("For " + s + " ");
            switch (s) {
                case "+":
                    function="_plus_";
                    gotOper(function, 1);
                    break;
                case "-":
                    function="_min_";
                    gotOper(function, 1);
                    break;
                case "*":
                    function="_mult_";
                    gotOper(function, 2);
                    break;
                case "/":
                    function="_div_";
                    gotOper(function, 2);
                    break;
                case "(":
                    inputStack.push(s);
                    break;
                case ")":
                    gotParen(s);
                    break;
                case "sin":
                    function="_sin_";
                    gotOper(function, 2);
                    break;
                case "cos":
                    function="_cos_";
                    gotOper(function, 2);
                    break;
                case "tg":
                    function="_tg_";
                    gotOper(function, 2);
                    break;
                default:
                    output [++top] = s;
                    break;
            }
        }
        while(!inputStack.isEmpty()){
            inputStack.displayStack("While ");
            output[++top] = inputStack.pop();
        }
        inputStack.displayStack("End ");
        return output;
    }

        public void gotOper(String opThis, int prec1){
            while (!inputStack.isEmpty()) {
                String opTop = inputStack.pop();
                if (opTop.equals("(")) {
                    inputStack.push(opTop);
                    break;
                } else {
                    int prec2;
                    if (opTop.equals("_plus_") || opTop.equals("_min_"))
                        prec2 = 1;
                    else
                        prec2 = 2;
                    if (prec2 <= prec1) {
                        inputStack.push(opTop);
                        break;
                    } else
                        output[++top] = opTop;
                }
            }
            inputStack.push(opThis);
        }

        public void gotParen (String s){
            while (!inputStack.isEmpty()) {
                String chx = inputStack.pop();
                if (chx.equals("("))
                    break;
                else
                    output[++top] = chx;
            }
        }
    }
