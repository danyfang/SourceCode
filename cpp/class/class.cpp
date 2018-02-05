#include<iostream>

using namespace std;

class Animal{
private:
	string type;
	int weight;
	string color;

public:
	Animal(string type, string color, int weight){
		this->type = type;
		this->color = color;
		this->weight = weight;
	}
	Animal(){
		cout<< "Animal constructor without param" << endl;
	}

	~Animal(){
		cout<< "Animal destructor executed!" << endl;
	}

};


class Human:public Animal{
private:
	string name;
	string country;
	int age;
	int weight;

public:
	Human(string name, string country, int age, int weight):Animal("Human","white",weight){
		this->name = name;
		this->country = country;
		this->age = age;
		this->weight = weight;
	}
	Human(){
		cout<< "Human constructor without param" << endl;
	}

	~Human(){
		cout<< "Human destructor executed!" << endl;
	}
};





int main(){

	Human *hm = new Human();	
	delete hm;
	Human h;
	return 0;	
	
}
