//This piece of code demostrates why we need to use copy constructor
#include <iostream>
#include <stdlib.h>
class CopyConstructor
{
public:
    CopyConstructor();
    CopyConstructor(int n);
    CopyConstructor(CopyConstructor &rhs);
    //CopyConstructor & operator= (const CopyConstructor &rhs);
    void operator= (const CopyConstructor &rhs);
    ~CopyConstructor();

private:
    size_t size;
    int *data;
};

int main()
{
    CopyConstructor a(100);
    CopyConstructor c(a);
    CopyConstructor d = a;
    return 0;
}

CopyConstructor::CopyConstructor(int n)
{
    size = n;
    data = (int*)malloc(sizeof(int)*size);
    std::cout << "Constructor called\n" << this << std::endl;
}
CopyConstructor::~CopyConstructor()
{
    std::cout << "Destructor called \n"  << this << std::endl;
    free(data);
}
CopyConstructor::CopyConstructor(CopyConstructor &rhs)
{
    data = (int*)malloc(sizeof(int)*rhs.size);
    memcpy(data, rhs.data, sizeof(int)*rhs.size);
    std::cout << "Copy Constructor called\n"  << this << std::endl;
}
void CopyConstructor::operator= (const CopyConstructor &rhs)
{
    std::cout << "Operator overloading \n";
    if(data)
        free(data);
    data = (int*)malloc(sizeof(int)*rhs.size);
}
    
    /*
 CopyConstructor::CopyConstructor & operator= (const CopyConstructor &rhs)
 {
 }
 */
