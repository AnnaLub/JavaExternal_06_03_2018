package inputdata_inversion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InfixProcess {

    public static String[] getInfix() throws IOException {
        InputInversion inputInversion = new InputInversion(getString());
        String [] output = inputInversion.doTrans();
        String[] result = outputTrim(output);
        System.out.println("Postfix is: ");
        printOutput(result);
        return result;
    }

    public static String[] outputTrim(String[]s){
        String[] result;
        int count = -1;
        for (int i = 0; i < s.length; i++) {
            count++;
            if(s[i]==null)
                break;
        }
        result = new String[count];
        for (int i = 0; i < result.length; i++) {
            result[i]=s[i];
        }
        return result;
    }

    private static String[] getString() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter number of elements: ");
        int arrLength =Integer.parseInt(br.readLine());
        String[] input = new String[arrLength];

        System.out.println("Please fulfill it: ");
        for (int i = 0; i < arrLength; i++) {
            System.out.println("element "+i+":");
            input[i] = br.readLine();
        }
        System.out.println("Result is");
        printOutput(input);
        return input;
    }

    public static void printOutput(String[]output){
        for (String s : output) {
            System.out.print(s);
        }
        System.out.println(" ");
    }
}
