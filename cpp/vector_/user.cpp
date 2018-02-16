//user.cpp

#include "Vector.cpp"
#include <cmath>
#include <iostream>
namespace com{
	class complex{
	double re,im;
	public:
		complex(double r, double i):re{r},im{i}{}
		complex(double r):re{r},im{0}{}
		complex():re{0},im{0}{}
		double real() const{
			return re;
		}
		double imag() const{
			return im;
		}
	};
	complex sqrt(complex);
	int main();
}

int com::main(){
	complex z {1,2};
	auto z2 = sqrt(z);
	std::cout << z2.real() << z2.imag() << std::endl;
	return 0;
};
com::complex com::sqrt(com::complex z){
	return com::complex(0,0);
}
using namespace std;

double sqrt_sum(Vector& v){
	double sum = 0;
	for(int i=0;i!=v.size();i++){
		sum+=sqrt(v[i]);
	}
	return sum;
}

int main(){
	Vector v(4);
	cout << sqrt_sum(v) << endl;
	return com::main();
	return 0;
}
