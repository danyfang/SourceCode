#include <iostream>

using namespace std;

int count_x(char *p, char x){
	if (p == nullptr){
		return 0;
	}
	int count = 0;
	for(; *p!=0; ++p){
		if(*p == x){
			++count;
		}
	}
	return count;
}	

class Vector{
public:
	Vector(int s):elem{new double[s]},sz{s}{}
	double& operator[](int i){
		return elem[i];
	}
	int size(){
		return sz;
	}
private:
	double *elem;
	int sz;
};
enum class TrafficLight{red, green, yellow};
TrafficLight& operator++(TrafficLight& t){
	switch(t){
		case TrafficLight::red:
			return t = TrafficLight::green;
		case TrafficLight::green:
			return t = TrafficLight::yellow;
		case TrafficLight::yellow:
			return t = TrafficLight::red;
	


	}
}


int main(){
	cout << "Hello World " << endl;
	int arr[] = {1,2,3,4,5,6,7,8,9};
	int a = 0;
	const int (&brr)[9] = arr;
	int *p = arr;
	for(auto &x:arr){
		cout << *(p+a) << endl;// this way is quite dangerous to get the value
		a++;
		cout << ++x << endl;
	}
	char crr[] = {'2','3','5','6','8','9'};
	cout << count_x(crr, '2') << endl;
	return 0;
}
