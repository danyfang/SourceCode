/*
* This demos the design pattern of multiple instances, comparing to singleton
* The main feature is to make the constructor private, so objects can not be instantiated outside class
* Construct all instances inside the class and make all instances final and static
*/

class Sex{
    private static final Sex Male = new Sex("Male");
    private static final Sex Female = new Sex("Female");

    private String title;
    private Sex(String title){
        this.title = title;
    }

    public static Sex getInstance(String m){
        switch(m.toUpperCase()){
            case "MALE":
                return Male;
            case "FEMALE":
                return Female;
            default:
                return null;
        }
    }

    public String getTitle(){
        return this.title;
    }
}

public class Multiton{
    public static void main(String args[]){
        Sex male = Sex.getInstance("male"); 
        System.out.println(male.getTitle());
    }
}
