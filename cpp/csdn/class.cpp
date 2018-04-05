#include <iostream>

using namespace std;
class Circle
{
public:
	Circle (double r) : r (r){}
	double r;
	double pi = 3.1415;
	double area = pi * r * r;
	double getArea() const
	{
		return pi * r * r;
	}
};
int main()
{
	int r = 0;
	cout << "Input radius : ";
	cin >> r;
	Circle c(r);
	cout << "Area is : " << c.getArea() << endl;
	return 0;
}
