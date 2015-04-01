
package SetsNmaps;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //sets are like statistical sets
        //A{1,2,3}
        //B{1,3,5}
        //AuB{1,2,3,5}
        //AnB{1,3}
        //A-B==Everything in A, not in B {2}
        //B-A==Everything in B, not in A {5}
        //ACB if A is a subset of B (in this case it returns "false")
        Scanner c = new Scanner(System.in);
        p("Insert set A: ");
        HashSet<Integer> A = new HashSet<>();
        setSet(A);
        p("Insert set B: ");
        HashSet<Integer> B = new HashSet<>();
        setSet(B);
        
        System.out.print("A:");
        for(int a : A) {
            System.out.print(" " + a + " ");
        }
        System.out.println();
        System.out.print("B:");
        for(int a : B) {
            System.out.print(" " + a + " ");
        }
        System.out.println();
        boolean stop = true;
        while(stop) {

            p("The Set Program");
            p("1- Union");
            p("2- Intersection");
            p("3- Difference (A-B)");  
            p("4- Difference (B-A)");
            p("5- Sort");
            p("6- Print");
            p("7- Edit A");
            p("8- Edit B");
            p("9- Add A");
            p("10- Add B");
            p("11- Subtract A");
            p("12- Subtract B");
            p("0- Exit");
            
            p("Input your numb here: ");
            int j = c.nextInt();

            switch(j) {
                case 0:
                    stop = false;
                    break;
                case 1:
                    union(A, B);
                    break;
                case 2:
                    intersection(A, B);
                    break;
                case 3:
                    subtraction(A, B);
                    break;
                case 4:
                    subtraction(B, A);
                    break;
                case 5:
                    sort(A);
                    sort(B);
                    break;
                case 6:
                    print(A);
                    print(B);
                    break; 
                case 7:
                    setSet(A);
                    break;
                case 8:
                    setSet(B);
                    break;
                case 9: 
                    add(A);
                    break;
                case 10:
                    add(B);
                    break;
                case 11:
                    subtract(A);
                    break;
                case 12:
                    subtract(B);
                    break;
                default:
                    p("Error");
                    break;
            }
        }
    }
    
    public static void p(String s) {
        System.out.println(s);
    }
    
    public static void setSet(HashSet A) {
        Scanner c = new Scanner(System.in);
        String choice = "";
        int i = 0;
        while(!choice.equalsIgnoreCase(("done"))) {
            i++;
            System.out.print(i + "- ");
            choice = c.nextLine();
            try {
                A.add(Integer.parseInt(choice));
            } catch (java.lang.NumberFormatException e) {
                i--;
            }
        }
    }
    public static void union(HashSet<Integer> A, HashSet<Integer> B){
        HashSet<Integer> temp = new HashSet<>();
        for(int x : A) {
            temp.add(x);
        }
        for(int x : B) {
            temp.add(x);
        }
        print(temp);
    }
    
    public static void intersection(HashSet<Integer> A, HashSet<Integer> B){
        HashSet<Integer> temp = new HashSet<>();
        
        for(int x : A) {
            if(B.contains(x)) {
                temp.add(x);
            }
        }
        print(temp);
    }
    
    public static void subtraction(HashSet<Integer> A, HashSet<Integer> B) {
        HashSet<Integer> temp = A;
        for(int a : temp) {
            if(B.contains(a)) {
                temp.remove(a);
            }
        }
        print(temp);
    }
    
    public static void sort(HashSet<Integer> A) {
        HashSet temp = A;
        TreeSet<Integer> sort = new TreeSet<>();
        
        for(int a : A) {
            sort.add(a);
        }
        A.clear();
        for(int a : sort) {
            A.add(a);
        }
        print(A);
    }
    
    public static void print(HashSet<Integer> temp) {
        System.out.print("{");
        for(int x : temp) {
            System.out.print(" " + x + " ");
        }
        System.out.print("}"); 
    }
    
    public static void add(HashSet<Integer> A) {
        Scanner c = new Scanner(System.in);
        System.out.print("Tyoe in number to add: ");
        String toadd = c.nextLine();
        try {
           A.add(Integer.parseInt(toadd)); 
        } catch (java.lang.NumberFormatException e) {
            System.out.println("Error cannot add");
        }
        print(A);
    }
    
    public static void subtract(HashSet<Integer> A) {
        Scanner c = new Scanner(System.in);
        System.out.print("Tyoe in number to subtract: ");
        String toadd = c.nextLine();
        int t;
        boolean removed = false;
        try {
           t = Integer.parseInt(toadd); 
           for(int w : A) {
                if(w == t) {
                    A.remove(w);
                    removed = true;
                }
            }
           if(removed) {
               System.out.println("Removed!");
           } else {
               System.out.println("Could not remove");
           }
           print(A);
        } catch (java.lang.NumberFormatException e) {
            System.out.println("Format Error");
        }
        
        
        print(A);
    }
        
}
