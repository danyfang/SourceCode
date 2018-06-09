/*
* This source file is c++ demos of thread
*/

#include <vector>
#include <iostream>
#include <thread>

using namespace std;

void print(vector<int>& v){
    for(auto p=v.begin(); p!=v.end(); ++p){
        cout << *p << " ";
    }
    cout << endl;
}

void prin(vector<int>& v){
    for(auto p=v.begin(); p!=v.end(); ++p){
        cout << *p << " ";
    }
    cout << endl;
}
void foo(){
    cout << "function foo" << endl;
}
void bar(){
    cout << "function bar" << endl;
}

int main(){
    vector<int> v1{1,2,3,4,5,6,7,8,9};
    vector<int> v2{100,102,103,104,105,106,107,108,109};
    thread t1{foo};
    thread t2{bar};
    t1.join();
    t2.join();
    return 0;
}
