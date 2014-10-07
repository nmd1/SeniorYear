package Stacks;
import java.util.*;


public class main {
    //Infix: 3 + 5   \\ 3 + 5 * 2 ( = 13)
    //prefix: + 3 5  \\ + 3 * 5 2
    //postfix 3 5 +  \\ 3 5 2 * +
    //
    public static void main(String[] args) {
        boolean looper = true;
        int stat = 0;
        while (looper) {
            Scanner s = new Scanner(System.in);
            String sentence = "I'm so fancy, you already know";
            String delimiter = ",.!? \n\t\r";
            StringTokenizer tokens = new StringTokenizer(sentence, delimiter);

            print("Choose your weapon:");
            print("1- Evaluate PostFix (tm)");
            print("2- Convert Infix to PostFix");
            print("3- Exit");
            int choice = s.nextInt();
            switch(choice) {
                case 1:
                    System.out.print("input postfix: ");
                    String input = s.nextLine();
                    input = s.nextLine();
                    System.out.println(one(input));
                    break;
                case 2:
                    two("");
                    break;
                case 3:
                    if(stat == 0) {
                        System.out.println("You didn't even do anything!");
                    } else {
                        System.out.println("G'bye!");
                        System.out.println("looped " + stat + " times");
                    }
                    looper = false;
                    break;
                default:
                    System.out.println("I didn't understand you. Emptying Stacks...");
                    break;
            }
            stat++;
        }
        
    }
    public static String one(String input){
        Stack<String> stack = new Stack<>();
        StringTokenizer tokens = new StringTokenizer(input);
        String op1 = null, op2 = null, error = null;
        
        while(tokens.hasMoreTokens()) {
            String token = tokens.nextToken();
            if(isOperand(token))
                stack.push(token);
            else if (isOperator(token)) {
                if(! stack.empty()) {
                    op2 = stack.pop();
                    if(! stack.empty()) {
                        op1 = stack.pop();
                        String result = compute(op1, token, op2);
                        if(result != null)
                            stack.push(result);
                        else
                            error = "Error 0: Attempt to divide by Zero";
                    } else 
                        error = "Error 2: There wasn't a second Operand";
                } else 
                    error = "Error 1: There wasn't a first Operand";
            } else 
                error = "Error ?: Unknown Operator ";
        }
            if (stack.size() != 1)
                error = "Error 23: There were nultiple numbers left in stack";
            if (error != null) 
                return error;
            else 
                return stack.pop();
    }
    
    private static boolean isOperand(String s) {
        for(int i = 0; i < s.length(); i++)
            if(! Character.isDigit(s.charAt(i)))
                return false;   
        return true;
    }
    private static boolean isOperator(String s) {
        return s.equals("+") 
               || s.equals("*") 
               || s.equals("/") 
               || s.equals("-") 
               ||s.equals("^");
    }
    private static String compute(String op1, String op, String op2) {
        int result = 0;
        int firstnumb = Integer.parseInt(op1);
        int secondnumb = Integer.parseInt(op2);
        
        if(op.equals("+"))
            result = firstnumb + secondnumb;
        else if (op.equals("-"))
            result = firstnumb - secondnumb;
        else if (op.equals("*"))
            result = firstnumb * secondnumb;
        else if(op.equals("/")) 
            if(secondnumb == 0)
                return null;
            else
                result = firstnumb / secondnumb;
        else if(op.equals("^"))
            result = (int)Math.pow(firstnumb, secondnumb);
        return "" + result;
        
    }
    
    public static int two(String s) {
        
        return 0;
    }
    
    public static void print(String s) {
        System.out.println(s);
    }
    //* + 3 5 2
    //3 5 2
}
