package sg.edu.nus.iss.task02.src;

import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Console cons = System.console();
        List<String> operations = new ArrayList<String>();
        String input = "";
        String lastval = "0";
        
        System.out.println("Welcome.");
        while (input != null) {
            input = cons.readLine("Enter equation: ");
            operations = Arrays.asList(input.split(" "));
            if (input.equalsIgnoreCase("exit")) {
                System.err.println("Bye bye");
                System.exit(1);
            }

            if (operations.size() < 3) {
                System.out.println("Invalid equation, please try again! \n");
                continue;
            }
            //checks if $last in op1 or op2
            if(operations.get(0).equalsIgnoreCase("$last") ){
                operations.set(0, lastval);
            }
            if(operations.get(2).equalsIgnoreCase("$last")){
                operations.set(2, lastval);
            }

            Float op1 = Float.parseFloat(operations.get(0));
            Float op2 = Float.parseFloat(operations.get(2));
            Float res = 0.f;
            switch (operations.get(1)) {
                case "+":
                    res = addition(op1, op2);
                    //check if res is int or float
                    if(res % 1 == 0){
                        System.out.println(Math.round(res));
                    }else{
                        System.out.printf("%.2f\n",res);
                    }
                    lastval = res.toString();
                    break;
                case "-":
                    res = (subtract(op1, op2));
                    //check if res is int or float
                    if(res % 1 == 0){
                        System.out.println(Math.round(res));
                    }else{
                        System.out.printf("%.2f\n",res);
                    }
                    lastval = res.toString();
                    break;
                case "/":
                    res = (divide(op1, op2));
                    //check if res is int or float
                    if(res % 1 == 0){
                        System.out.println(Math.round(res));
                    }else{
                        System.out.printf("%.2f\n",res);
                    }
                    lastval = res.toString();
                    break;
                case "*":
                    res = (multiply(op1, op2));
                    //check if res is int or float
                    if(res % 1 == 0){
                        System.out.println(Math.round(res));
                    }else{
                        System.out.printf("%.2f\n",res);
                    }
                    lastval = res.toString();
                    break;

            }
        }
    }

    public static Float addition(Float op1, Float op2) {
        return op1 + op2;
    }

    public static Float subtract(Float op1, Float op2) {
        return op1 - op2;
    }

    public static Float divide(Float op1, Float op2) {
        return op1 / op2;
    }

    public static Float multiply(Float op1, Float op2) {
        return op1 * op2;
    }
}
