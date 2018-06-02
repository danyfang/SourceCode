#include<iostream>
#include<iostream>
using namespace std;

class Father{
protected:
	string name;
	int age;
public:
	Father(string name, int age){
		this->name = name;
		this->age = age;
	}
	Father(){}
	virtual void setInfo(string name, int age){
		this->name = name;
		this->age = age;
	}
	virtual void PrintInfo(){
		cout << "Name: " << name << endl;
		cout << "Age: " << age << endl;
	}
};

class Son:public Father{
public:
	Son(string name, int age){
		this->name = name;
		this->age = age;
	}
	Son(){}
	
};

class Daughter:public Father{
public:
	Daughter(string name, int age){
		this->name = name;
		this->age = age;
	}
	Daughter(){}
};


int main(){
	Father fa("Qiangqiang",43);
	Son son("William",13);
	Daughter dau("Susie",10);
	Father *f1 = &fa;
	Father *f2 = &son;
	Father *f3 = &dau;
	f1->PrintInfo();
	f2->PrintInfo();
	f3->PrintInfo();
	f1->setInfo("Xuqiang Fang",43);
	f2->setInfo("Weilian",13);
	f3->setInfo("Susu",10);	
	f1->PrintInfo();
	f2->PrintInfo();
	f3->PrintInfo();
	return 0;
}
