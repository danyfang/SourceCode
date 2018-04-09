/*
* This example piece of code shows the case when default big five doesn't work
* We would have to manually define big five ourselves
*/

#include <iostream>
#include <string>
using namespace std;
class IntCell
{
public:
    explicit IntCell(int init = 0)
    {
        cout << "Call explicit constructor" << this << endl;
        stored = new int(init);
    }

    ~IntCell()
    {
        cout << "Destroy object" << this << endl;
        delete stored;
    }

    IntCell(const IntCell& rhs)
    {
        cout << "Call copy constructor " << this << endl;
        stored = new int(*rhs.stored); 
    }

    IntCell(IntCell && rhs)
    {
        cout << "Call move constructor " << this << endl;
        stored = rhs.stored;
        rhs.stored = nullptr;
    }
    
    IntCell & operator= (const IntCell& rhs)
    {
        cout << "Call copy assignment" << this << endl;
        if(this != &rhs)
            *stored = *rhs.stored;
        return *this;
    }

    IntCell & operator= (IntCell&& rhs)
    {
        cout << "Call move assignment" << this << endl;
        std::swap(stored, rhs.stored);
        return *this;
    }

    int read() const
    {
        return *stored;
    }
    void write(int x)
    {
        *stored = x;
    }
private:
    int* stored;
};
IntCell create();
int main()
{
    IntCell a(2);
    IntCell b = a;
    IntCell c;
    c = b;
    c = create();//inside function call explicit and then move assignment
    a.write(4);
    std::cout << a.read() << std::endl << b.read() << std::endl << c.read() << std::endl;
    return 0;
}
IntCell create(){
    IntCell a;
    return a;
}
