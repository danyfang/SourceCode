/*
Written by Xuqiang Fang on 26-01-2018. All rights reserved.
通过这个简单的程序可以表现出栈和堆的区别。
*/
/* 
// 本程序的输出
100
0
0
0x7fff56fac8ec//cout << &a << endl;
0x7fff56fac8ec//cout << &b << endl;
0x7fc0ff400350//cout << s << endl;明显与其他的地址不同
0x7fff56fac8d8// cout << &s << endl;
0x7fff56fac8c8 //cout << &stack << endl;
0x7fff56fac8c0//cout << &stac << endl;

*/
#include<iostream>
using namespace std;

void ref(int a){
	a = 0;
}

void ref2(int &a){
	a = 0;
}
int & ret(int &a){
	//return a*10;//error! don't know why!
	return a;
}
class Show{
private:
	int show;
public:
	Show(int s):show(s){}
	Show(){
		this->show = 0;
	}
	void setShow(int show){
		this->show = show;
	}
	int getShow(){
		return this->show;
	}
	
};
class Tax{
private:	
	int amount ;
public:
	void setAmount(int amou){
		this->amount = amou;
	}
	int getAmount(){
		return this->amount;
	}
};

class Taxes{
private:
	static int amount  ;
public:
	static void setAmount(int amou);
	static int getAmount();

};
int Taxes::amount = 110;//这里表明私有静态成员在类内仅仅是声明，并没有被真正赋予内存空间，所以如果尝试在类内初始化的话应该会报错！
void Taxes::setAmount(int amou){
	Taxes::amount = amou;
}
int Taxes::getAmount(){
	return Taxes::amount;
}

class Array{
private:
	int array[100];
public:
	Array(){
		for(int i=0; i<100; i++){
			array[i] = 0;
		}
	}
	int getSize(){
		return sizeof(this->array);
	}
	int getAddress(){
		return *(this->array);
	}

};


int main(){
	int a = 100;
	ref(a);
	cout << a << endl;
	ref2(a);
	cout << a << endl;
	cout << ret(a) <<endl;
	int &b = a;
	cout << &a << endl;
	cout << &b << endl;
	Show *s = new Show(4);
	//上面这条语句将在堆中开辟一块区域以存放所生成的Show类的对象， 但是对应的指针仍然存储在栈之中
	//所以在使用完new 之后必须要用delete 进行内存回收。
	//这个程序能帮助理解很多的概念。
	Show stack;
	Show stac(4);
	cout << s << endl;
	cout << &s << endl;
	cout << &stack << endl;
	cout << &stac << endl;
	delete s;
	int arr[10];
	Tax t1;
	t1.setAmount(10);
	Taxes t2;
	Taxes t3;
	cout << Taxes::getAmount() << endl;
	Taxes::setAmount(10);
	t2.setAmount(20);
	cout << Taxes::getAmount() << endl;
	t3.setAmount(30);
	cout << Taxes::getAmount() << endl;
	Array rr;
	cout << rr.getSize() << endl;
	cout << sizeof(a) << endl;
	cout << sizeof(rr) << endl;
	cout << rr.getAddress() << endl;
}
