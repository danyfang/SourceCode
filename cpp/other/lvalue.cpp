#include <iostream>
#include <vector>
#include <string>
using namespace std;
class IntCell{
private:
	int storedValue;
	int anotherValue;
public:
	IntCell(int storedValue){
		this->storedValue = storedValue;
	}

	IntCell(int storedValue, int anotherValue){
		this->storedValue = storedValue;
		this->anotherValue = anotherValue;
	}

	void setValue(int storedValue, int anotherValue){
		this->anotherValue = anotherValue;
		this->storedValue = storedValue; 
	}

	int getValue()const{
		return this->storedValue+this->anotherValue;
	}

};
int main(){
	IntCell cell = 10;
	IntCell c(10,20);
	cout<< cell.getValue() << endl;
	cout<< c.getValue() << endl;
	int arr[] = {12,34354,4456,4545645,64534,34,534,534,534,34};
	cout << arr << endl;
	cout << "请输入你的姓名：" << endl;
	string name;
	cin >> name;
	const string greeting = "你好，"+name+"先生";
	const string space((greeting.size()),' '); 
	const string second = "*"+space+"*";
	const string first (second.size(),'*');
	cout << endl;
	cout << first << endl;
	cout << second << endl;
	cout << "*" << greeting << "*" << endl;
	cout << second << endl;
	cout << first << endl;
	char ch = 'a';
	char ch2 = 'a';
	cout << ch << " " <<ch2 << endl;
	ch2 = 'b';
	cout << ch << " " <<ch2 << endl;
	return 0;	
}



