package outputdata_parsing;

public class PostfixParsing {
    private RPNStack rpnStack;
    private String [] output;

    public PostfixParsing(String[] output) {
        this.output = output;
    }

    public double getParsing(){
        rpnStack = new RPNStack(21);
        String s="";
        double num1 = 0;
        double num2 = 0;
        double interAns = 0;
        for (int i = 0; i < output.length; i++) {
            s = output[i];
                if (isDigit(s)) {
                    rpnStack.push(Integer.parseInt(s));
                    continue;
                } if(s.equals("_sin_")||s.equals("_cos_")||s.equals("_tg_")) {
                num2 = rpnStack.pop();
            }else {
                    num2 = rpnStack.pop();
                    num1 = rpnStack.pop();
                }
                switch (s) {
                    case "_plus_":
                        interAns = num1 + num2;
                        break;
                    case "_min_":
                        interAns = num1 - num2;
                        break;
                    case "_mult_":
                        interAns = num1 * num2;
                        break;
                    case "_div_":
                        interAns = num1 / num2;
                        break;
                    case "_sin_":
                        interAns = Math.sin(num2);
                        break;
                    case "_cos_":
                        interAns = Math.cos(num2);
                        break;
                    case "_tg_":
                        interAns = Math.tan(num2);
                        break;
                    default:
                        interAns = 0;
                }
                rpnStack.push(interAns);
        }
        interAns=rpnStack.pop();
        return interAns;
    }

    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
