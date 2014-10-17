package Stacks;
import java.util.*;


public class main {

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
                    input = s.nextLine(); //the fact that I need to do this doesn't make sense
                    System.out.println(one(input));
                    break;
                case 2:
                    System.out.println("Input infix: ");
                    String input2 = s.nextLine();
                    input2 = s.nextLine();
                    String wer = convertToPostfix(input2);
                    System.out.println("The converted infix" + wer);
                    System.out.println("The Answer: " + one(wer));
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
            if(isNumber(token))
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
    
    private static boolean isNumber(String s) {
        if(isOperator(s)) return false;
        if(s.equals("(") || s.equals(")")) return false;
        
        double k = Double.parseDouble(s);
        if( k < 0) return true;
        
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
    
    public static int precedence(String s) {
        if(s.equals("+") || s.equals("+"))
            return 1;
        if(s.equals("*") || s.equals("/"))
            return 2;
        if(s.equals("^"))
            return 3;
        else return 99;
    }
       private static boolean isOperator(char c) { // Tell whether c is an operator.
        return c == '+'  ||  c == '-'  ||  c == '*'  ||  c == '/'  ||  c == '^'
           || c=='(' || c==')';
   }//end isOperator

 

   private static boolean isSpace(char c) {  // Tell whether c is a space.

     return (c == ' ');
   
   }//end isSpaces


   private static  boolean lowerPrecedence(char op1, char op2) {  
      switch (op1) {
         case '+':
         case '-':
            return !(op2=='+' || op2=='-') ;

         case '*':
         case '/':
            return op2=='^' || op2=='(';

         case '^':
            return op2=='(';

         case '(': return true;

         default:  // (shouldn't happen)
            return false;
      }
 
   } // end lowerPrecedence


// Method to convert infix to postfix:

   public static String convertToPostfix(String infix) {
      // Return a postfix representation of the expression in infix.

     Stack operatorStack = new Stack();  //the stack
     char c;      
   
     StringTokenizer parser = new StringTokenizer(infix,"+-*/^() ",true);
     StringBuffer postfix = new StringBuffer(infix.length());  // result
        while (parser.hasMoreTokens()) {     
                                            
           String token = parser.nextToken();  
           c = token.charAt(0);      
           if ((token.length() == 1) && isOperator(c)) {  
              while (!operatorStack.empty() &&
                 !lowerPrecedence(((String)operatorStack.peek()).charAt(0), c))
                 postfix.append(" ").append((String)operatorStack.pop());

              if (c==')') {
                 // Output the remaining operators in the parenthesized part.
                    String operator = (String)operatorStack.pop();
                    while (operator.charAt(0)!='(') {
                       postfix.append(" ").append(operator);
                       operator = (String)operatorStack.pop();  
                    }
              }
              else
                 operatorStack.push(token);
           }
           else if ( (token.length() == 1) && isSpace(c) ) { 
           }
           else { 
             postfix.append(" ").append(token);  
           }
 
         }
        while (!operatorStack.empty())
           postfix.append(" ").append((String)operatorStack.pop());
        return postfix.toString();


   }
    public static void print(String s) {
        System.out.println(s);
    }
}
