#include<iostream>

using namespace std;

class Ploygon{
protected:
    int width, height;
public:
    void setValues(int a, int b){
        this->width = a;
        this->height = b;
    }
    virtual int area(){
        return 0;
    }
};

class Rectangle:public Ploygon{
public:
    int area(){
        return (width*height);
    }
};

class Triangle: public Ploygon{
public:
    int area(){
        return (height*width)/2;
    }
};

int main(){
    Rectangle rect;
    Triangle tri;
    Ploygon poly;
    Ploygon *poly1 = &rect;
    Ploygon *poly2 = &tri;
    Ploygon *poly3 = &poly;
    poly1->setValues(4,5);
    poly2->setValues(4,5);
    poly3->setValues(4,5);
    cout << poly1->area() << endl;
    cout << poly2->area() << endl;
    cout << poly3->area() << endl;
    return 0;
}