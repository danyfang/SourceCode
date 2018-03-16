/*
C++ program to demonstrate const lvalue reference and 
rvalue reference
*/

#include<iostream>
#include<string>
#include<vector>

using namespace std;
string randomItem(const vector<string> & arr);
string randomItem(vector<string> && arr);

int main(int arg, char** argv){
	vector<string> v{"Hello", "World"};
	cout << randomItem(v) << endl;
	cout << randomItem({"Hello", "World"}) << endl;
	return 0;
}

string randomItem(const vector<string> & arr){
	cout << "Invoke the first method" << endl;
	return arr[0];
}

string randomItem(vector<string> && arr){
	cout << "Invoke the second method" << endl;
	return arr[0];
}
