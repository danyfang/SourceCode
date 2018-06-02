package dany.fang.java;

public class Student  implements Comparable<Student>{
    private String name;
    private int age;
    public Student(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student name: "+ this.name+ ", age: "+this.age;
    }

    @Override
    public int compareTo(Student o) {
        if(this.age> o.age){
            return -1;
        }else if (this.age == o.age){
            if(this.name.compareTo(o.name)>0){
                return -1;
            }else if(this.name.compareTo(o.name)<0){
                return 1;
            }else {
                return 0;
            }
        }else{
            return 1;
        }
    }
}
