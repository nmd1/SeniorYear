package senioryear;

public class Info {
    public String name;
    public int place;
    
    public Info() {
    }
    
    public void setName(String s) {
        name = s;
    }
    
    public void setPlace(int i) {
        place = i;
    }
    
    public String getName() {
        return name;
    }
    
    public int getPlace() {
        return place;
    }
    
    @Override
    public String toString() {
        return name + "is the" + placed(place) + "planet from the sun";
    }
    
    private String placed(int i) {
        switch(i){
            case 1:return "1st";
            case 2:return "2nd";
            case 3:return "3rd";
            default:return i+ "st";
        }
    }
    
    
}
