/*
* This source file demos the usage of alias, function template and iterator
* Written by Xuqiang Fang on 8 June, 2018
*/
#include <iostream>
#include <string>
#include <iterator>
#include <vector>
#include <list>
using namespace std;

/*
*trying to use alias for template but failed
template<typename T>
using Iterator<T> = typename T::iterator;
*/

template<typename C, typename V>
vector<typename C::iterator> find_all(C& c, V v){
    vector<typename C::iterator> res;
    for(auto p=c.begin(); p!=c.end(); ++p){
        if(*p == v){
            res.push_back(p);
        }
    }
    return res;
}

void test(){
    string m{"Mart had a little lamb"};
    for(auto p : find_all(m, 'a')){
        if(*p != 'a'){
            cerr << "string bug!\n";
        }
    }
    list<double> ld{1.1,2.2,3.3,1.1};
    for(auto p : find_all(ld, 1.1)){
        if(*p != 1.1){
            cerr << "list bug\n";
        }
    }

    vector<string> vs{"red","blue","green","green","orange","green"};
    for(auto p : find_all(vs, "green")){
        if(*p != "green"){
            cerr << "vector bug\n";
        }
    }
    for(auto p : find_all(vs, "green")){
        *p = "vert";
    }
}

int main(){
    test();
    ostream_iterator<string> oo{cout};
    *oo = "Hello, ";
    ++oo;
    *oo = "World\n";
    return 0;
}
