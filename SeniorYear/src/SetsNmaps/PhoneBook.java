/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SetsNmaps;

import java.util.*;

/**
 *
 * @author s11370863
 */
public class PhoneBook {
    public static void main(String[] args) {
        System.out.println("The phone book");
        
        SortedMap<String, String> book = new TreeMap<>();
        Scanner c = new Scanner(System.in);
        
        pl("The Maps Program");
            pl("1- Add Entry");
            pl("2- Remove Entry");
            pl("3- View Entries");  
            pl("4- Drop table");
            pl("0- Exit");
            
            boolean stop = true;
            while(stop) {
                pl("Enter Menu Selection:");
                int j = c.nextInt();

                switch(j) {
                    case 0:
                        stop = false;
                        break;
                    case 1:
                        add(book);
                        break;
                    case 2:
                        remove(book);
                        break;
                    case 3:
                        prStringBook(book);
                        break;
                    case 4:
                        book.clear();
                        break;
                    default:
                        p("Error");
                        break;
                }
            }
    }
    
    public static void prStringBook(SortedMap<String, String> thing) {
        Set<String> names = thing.keySet();
        Collection<String> numbers = thing.values();
        Iterator<String> keys = names.iterator();
        Iterator<String> values = numbers.iterator();
        while(keys.hasNext() && values.hasNext()) {
            p("Name: " + keys.next() );
            pl("  |  Number: " + values.next());
        }
    }
    
    public static void add(SortedMap<String, String> HM) {
        Scanner c = new Scanner(System.in);
        p("Enter Name: ");
        String name = c.nextLine();
        p("Enter Number: ");
        String number = c.nextLine();
        HM.put(name, number);
    }
    public static void remove(SortedMap<String, String> HM) {
        Scanner c = new Scanner(System.in);
        p("What name would you like to remove?");
        String remove = c.nextLine();
        
        if(HM.containsKey(remove)) {
            HM.remove(remove);
        } else {
            pl("Name Does not exist");
        }
    }
    public static void pl(String s) {
        System.out.println(s);
    }
    public static void p(String s) {
        System.out.print(s);
    }
    
}
