#include "Stack.h"

class Student {
    private:
        std::string name;
        std::string course;
        int age;

    public:
        Student(std::string n, std::string c, int a) : name(n), course (c) {
            //std::cout << "In STUDENT constructor" << std::endl;
            age = a;
        }

        ~Student() {
            //std::cout << "In STUDENT destructor" << std::endl;
        }

        std::string getName() {
            return name;
        }

        std::string getCourse() {
            return course;
        }

        int getAge() {
            return age;
        }
};

int main () {
    Stack <Student> studentStack;

    Stack <int> number;
    int i = 0;
    int j = 1;
    number.push(i);
    std::cout << i << std::endl;
    number.push(j);
    std::cout << j << std::endl;
    try {
        int k = number.pop();
        std::cout << k << std::endl;
        int l = number.pop();
        std::cout << l << std::endl;
    } catch (StackException& int_exception){
        int_exception.what();
    }

    Student s1( "Student1" , "Course1", 21);
    Student s2( "Student2" , "Course2", 22);

    studentStack.push ( s1 );
    std::cout << "Student Details: " << s1.getName() << ", " << s1.getCourse() << ", " << s1.getAge() << std::endl;
    studentStack.push ( s2 );
    std::cout << "Student Details: " << s2.getName() << ", " << s2.getCourse() << ", " << s2.getAge() << std::endl;

    try {
        Student s3 = studentStack.pop();
        std::cout << "Student Details: " << s3.getName() << ", " << s3.getCourse() << ", " << s3.getAge() << std::endl;

        Student s4 = studentStack.pop();
        std::cout << "Student Details: " << s4.getName() << ", " << s4.getCourse() << ", " << s4.getAge() << std::endl;

        Student s5 = studentStack.pop();
        std::cout << "Student Details: " << s5.getName() << ", " << s5.getCourse() << ", " << s5.getAge() << std::endl;
    } catch (StackException& se) {
        se.what();
    }
}