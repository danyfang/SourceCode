#include <string>
#include <sstream>
#include <iostream>
using namespace std;
int main(){
    string mystr;
    float price;
    cout << "enter price :" << endl;
    getline(cin,mystr);
    //cin.getline(mystr);
    stringstream (mystr) >> price;
    cout << "the price is:" << price << endl;
    return 0;
}