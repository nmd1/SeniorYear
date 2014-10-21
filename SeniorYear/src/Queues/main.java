package Queues;
import java.util.*;

public class main {
    public static void main(String[] args) {
        main q = new main();
        System.out.print("You walk in. You look around and see\n empty chairs "
                + "and soft couches. The place smells of anesetic.\nthe lady behind "
                + "the glass is sitting staring at her papers. She welcomes you to\n "
                + "a room you never want to visit, a room you've always lothed. You are now in \n");
        q.main();
        
    }
    
    public void main() {       
        Queue<String> queue = new LinkedList<>();
        String[] examRoom = {"", "", "", ""};
        print("The WAIT room");
        print("1) Status of exam rooms");
        print("2) Print wait room and wait times");
        print("3) Print individual status (Wait time)");
        print("4) Check in");
        print("5) Check out");
        
        Scanner s = new Scanner(System.in), c = new Scanner(System.in);   
        int choice = s.nextInt();
        switch(choice) {
            case 1:
                try {
                System.out.println("Exam room 1 is " + 
                        (examRoom[0].isEmpty() ? "Empty" : "currently occupied by" + examRoom[0]));
                System.out.println("Exam room 2 is " + 
                        (examRoom[1].isEmpty() ? "Empty" : "currently occupied by" + examRoom[0]));
                System.out.println("Exam room 3 is " + 
                        (examRoom[2].isEmpty() ? "Empty" : "currently occupied by" + examRoom[0]));
                System.out.println("Exam room 4 is " + 
                        (examRoom[3].isEmpty() ? "Empty" : "currently occupied by" + examRoom[0]));
                } catch(java.lang.NullPointerException e) {
                    System.out.println("Whoops");
                }
                break;
            case 2:
                if(queue.isEmpty()) {print("No one is here...."); break;}
                int wait = 5;
                for(String names : queue) {
                    System.out.println(names + "has to wait for " + wait + " minutes");
                    wait = wait + 5;
                }
                break;
            case 3:
                break; 
            case 4:
                System.out.print("Name please?: "); 
                String name = c.nextLine();
                int count = -1;
                for(int i = 0; i < examRoom.length; i++) {
                    if(examRoom[i].isEmpty()) {
                        count = i;
                        break;
                    }                           
                }
                if(count != -1) {
                    examRoom[count] = name; //print("you're in " + count);
                } else {
                    queue.add(name); //print("Please have a seat in...THE WAIT ROOM");
                }
                
                break;
            case 5:
                break;
            case 7:
                print("Congrats, you found an easter egg! pat yo curious ass on the back");
                break;
            default:
                print("I'm sorry, we speak American here. Try again.");
                break;

        }
        
        
    }
    
    
    
    public void print(String s) {
        System.out.println(s);
    }
}
