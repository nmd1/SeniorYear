package Queues;
import java.util.*;

public class main {
    public static void main(String[] args) {
        main q = new main();
        System.out.print("You walk in. You look around and see\n empty chairs "
                + "and soft couches. The place smells of anesetic.\nthe lady behind "
                + "the glass is sitting staring at her papers. She welcomes you to\n"
                + "a room you never want to visit, a room you've always lothed. You are now in\n");
        q.main();
    }
    
    public void main() {
        int time = 1000;
        boolean loop = true;
        String[] examRoom = {"", "", "", ""};
        Queue<String> queue = new LinkedList<>();
        while(loop) {

            print("The WAIT room");
            print("1) Status of exam rooms"); //empty/half/full
            print("2) Print wait room and wait times");//empty/half/full (names)
            print("3) Print individual status (Wait time)");//not in office/in exam (say)/in waiting room (names)
            print("4) Check in");//
            print("5) Check out");
            print("6) End program");

            Scanner s = new Scanner(System.in), c = new Scanner(System.in);   
            int choice = s.nextInt();
            switch(choice) {
                case 1:
                    try {
                    System.out.println("Exam room 1 is " + 
                            (examRoom[0].isEmpty() ? "Empty" : "currently occupied by " + examRoom[0]));
                    System.out.println("Exam room 2 is " + 
                            (examRoom[1].isEmpty() ? "Empty" : "currently occupied by " + examRoom[1]));
                    System.out.println("Exam room 3 is " + 
                            (examRoom[2].isEmpty() ? "Empty" : "currently occupied by " + examRoom[2]));
                    System.out.println("Exam room 4 is " + 
                            (examRoom[3].isEmpty() ? "Empty" : "currently occupied by " + examRoom[3]));
                    } catch(java.lang.NullPointerException e) {
                        System.out.println("Whoops");
                    }
                    time = 1000;
                    break;
                case 2:
                    if(queue.isEmpty()) {print("No one is here...."); break;}
                    int wait = 5;
                    int incre = 0;
                    for(String names : queue) {
                        System.out.println(names + " has to wait for " + wait + " minutes");
                        wait = wait + 5;
                        incre++;
                    }
                    time = (int)(1000 * (Math.log(incre) + 1));
                    break;
                case 3:
                    System.out.print("Name please?: "); 
                    String guy = c.nextLine();
                    boolean nameExist = true;
                    int counter2 = -1;
                    for(String room : examRoom) {
                        counter2++;
                        if(room.equalsIgnoreCase(guy)) {
                            System.out.println(guy + " is currently in exam room " + (counter2 + 1));
                            nameExist = false;
                            break;
                        }
                    }
                    
                    int cou = 0;
                    for(String names : queue) {
                        if(names.equalsIgnoreCase(guy)){
                            System.out.println(guy + " is in the wait room and must wait " + ((cou + 1) * 5) + " minutes");
                            nameExist = false;
                            break;
                        }
                        cou++;
                    }
                    
                    if(nameExist) System.out.println("We have no records of '" + guy + "'.");
                    time = 1000;
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
                        examRoom[count] = name; //print(name + " is in " + count);
                    } else {
                        queue.add(name); //print("Please have a seat in...THE WAIT ROOM");
                    }

                    break;
                case 5:
                    System.out.print("Who are you?: ");
                    String person = c.nextLine();
                    
                    int counter = -1;
                    boolean end5 = false;
                    for(String room : examRoom) {
                        counter++;
                        if(room.equalsIgnoreCase(person)) {
                            //YOU FOUND 'EM
                            examRoom[counter] = "";
                            System.out.println(person + " has left exam room " + (counter + 1));
                            if(!queue.isEmpty()) {
                                examRoom[counter] = queue.remove();
                                System.out.println(examRoom[counter] + " has taken " + person 
                                        + "'s place in exam room " + (counter + 1));
                            }
                            end5 = true;
                            break;
                        }
                    }
                    
                    
                    if(!end5) {
                        System.out.print(person + " is not in any exam room");
                        boolean sectionB = false;
                        for(String names: queue) {
                            if(person.equalsIgnoreCase(names)) {
                                sectionB = true;
                            }
                        }    

                        if(sectionB) {
                            System.out.println(", but " + person + "is in the WAIT room");
                        } else {
                            System.out.println("; there is no '" + person + "'.");
                        }
                    }
                    
                    break; 
                case 6:
                    loop = false;
                    System.out.println("Goodbye, and make sure to revisit\nTHE WAIT ROOM\n------END------");
                    break;
                case 7:
                    print("Congrats, you found an easter egg! pat yoself on the back");
                    break;
                default:
                    print("I'm sorry, we speak American here. Try again.");
                    break;

            }//end switch
            
            try{
                Thread.sleep(1000);
            } catch (InterruptedException  e) {
                System.out.println("FATAL THREAD ERROR");
                System.out.println(e);
            }
            System.out.println();
        }//end loop
    }//end main program
    
    public void print(String s) {
        System.out.println(s);
    }
}
