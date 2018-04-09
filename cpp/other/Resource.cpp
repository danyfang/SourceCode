#include <iostream>
#include <vector>
#include <string>
using namespace std;
class Person{
public:
    Person(string name): n(new string(name)){}
    Person(const Person &rhs){
        n = new string(*rhs.n);
    }
    Person(Person &&rhs){
        n = rhs.n;
        rhs.n = nullptr;
    }
    Person & operator= (const Person &rhs){
        if(this != &rhs)
            *n = *rhs.n;
        return *this;
    }
    Person & operator= (Person &&rhs){
        swap(n, rhs.n);
        return *this;
    }
    
    ~Person(){delete n;}
    void print(){cout << *n <<endl;}
private:
    string* n;
};

int main()
{
    vector<Person> p;
    Person pp("K");
    p.push_back(Person("E"));
    p.push_back(Person("F"));
    p.push_back(Person("D"));
    p.push_back(Person("G"));
    p.push_back(Person("H"));
    p.push_back(Person("I"));
    p.push_back(pp);
    for(auto i = p.begin(); i !=p.end(); i++)
    {
        i->print();
    }

    return 0;
}
