package senioryear;

public class Info {
    private String name;
    private int place;
    private int size;
    private boolean life;
    
    public Info() {
    }
    
    public void setName(String s) {
        name = s;
    }
    
    public void setPlace(int i) {
        place = i;
    }
    
    public void setSize(int mass) {
        size = mass;
    }
    
    public void setLife(boolean organic) {
        life = organic;
    }
    
    public String getName() {
        return name;
    }
    
    public int getPlace() {
        return place;
    }
    
    public int getSize() {
        return size;
    }
    
    public boolean getLife(){
        //get a life man
        return life;
    }
    
    @Override
    public String toString() {
        return name + " is the " + placed(place) + " planet from the sun";
    }
    
    private String placed(int i) {
        switch(i){
            case 1:return "1st";
            case 2:return "2nd";
            case 3:return "3rd";
            default:return i+ "th";
        }
    }
    
    
}
