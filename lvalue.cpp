#include <iostream>

class A {
public:
    void foo() const { std::cout << "A::foo() const\n"; }
    void foo() { std::cout << "A::foo()\n"; }
};

A bar() { return A(); }
const A cbar() { return A(); }


int main()
{
    bar().foo();  // calls foo
    cbar().foo(); // calls foo const
}