/*
* Currently this file still doesn't work
*/

#include <iostream>

using namespace std;

class boVector{
    int size;
    double *arr_;
public:
    /*
    explicit boVector(int s = 0):size(s){
        arr_ = new double[size];
    }
    */
    boVector(){
        cout << "Call default constructor" << endl;
    }
    boVector(const boVector& rhs){
        cout << "Call copy constructor " << endl;
        size = rhs.size;
        arr_ = new double[size];
        for(int i=0; i<size; i++){
            arr_[i] = rhs.arr_[i];
        }
    }
    boVector(boVector&& rhs){
        cout << "Call move constructor" << endl;
        size = rhs.size;
        arr_ = rhs.arr_;
        rhs.arr_ = nullptr;
    }

    boVector & operator=(const boVector& rhs){
        cout << "Call copy assignment" << endl;
        if(this != &rhs){
            for(int i=0; i<rhs.size; i++){
                arr_[i] = rhs.arr_[i];
            }
        }
        return *this;
    }
    boVector & operator=(boVector&& rhs){
        cout << "Call move assignment" << endl;
        swap(arr_, rhs.arr_);
        return *this;
    }

    ~boVector(){
        cout << "Call destructor" << endl;
        delete arr_;
    }
};

void foo(boVector v);
boVector createBoVector();

int main()
{
    boVector resuable;
    resuable = createBoVector();//which constructor will this call
    //foo(resuable);

    //foo(std::move(createBoVector()));
    return 0;
}
void foo(boVector v)
{
    cout << "Call foo" << endl;
}

boVector createBoVector()
{
    boVector b;
    return b;
}
