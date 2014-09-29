package Stacks;
import java.util.*;


public class main {
    //Infix: 3 + 5   \\ 3 + 5 * 2
    //prefix: + 3 5  \\ + 3 * 5 2
    //postfix 3 5 +  \\ 3 5 2 * +
    //
    public static void main(String[] args) {
        boolean looper = true;
        int stat = 0;
        while (looper) {
            Scanner s = new Scanner(System.in);
            Stack<String> stk = new Stack<String>();
            String sentence = "I'm so fancy, you already know";
            String delimiter = ",.!? \n\t\r";
            StringTokenizer tokens = new StringTokenizer(sentence, delimiter);

            print("Choose your weapon:");
            print("1- Evaluate PostFix (tm)");
            print("2- Convert Infix to PostFix");
            print("3- Exit");
            int choice = s.nextInt();
            switch(choice) {
                case '1':
                    one("");
                    break;
                case '2':
                    two("");
                    break;
                case '3':
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
    public static int one(String s){
        return 0;
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
