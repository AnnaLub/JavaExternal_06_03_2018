package app;

import inputdata_inversion.InfixProcess;
import outputdata_parsing.PostfixParsing;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {


       PostfixParsing parsing = new PostfixParsing(InfixProcess.getInfix());
        System.out.println("Calculation result: " + parsing.getParsing());
    }
}
