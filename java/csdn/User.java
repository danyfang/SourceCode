public class User{
    private String name;
    private int age;
    private String passport;
    public User(String n, int a, String p){
        name = n;
        age = a;
        passport = p;
    }
    
    @Override 
    public boolean equals(Object o){
        if(o == this){
            return true;
        }
        if(!(o instanceof User)){
            return false;
        }
        User u = (User)o;
        return u.name.equals(name) && u.age == age && u.passport.equals(passport);
    }

    @Override
    public int hashCode(){
        int result = 17;
        result = 31 * result + name.hashCode();
        result = 31 * result + age;
        result = 31 * result + passport.hashCode();
        return result;
    }

    public static void main(String[] args){
        User u1 = new User("xuqiang", 28, "E7893294");
        User u2 = new User("xuqiang", 28, "E7893294");
        System.out.println(u1.hashCode());
        // before override equals, the following is false
        System.out.println(u1.equals(u2));
    }
}


