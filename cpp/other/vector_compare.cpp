#include <iostream>
#include <vector>
#include <string>

using namespace std;

/*
* the comparison between two vectors will be lexicographical order compare
*/
int main(){
    vector<int> a = {4,0,3,5,6,7,8,9};
    vector<int> b = {3,4,-1,-7,-5,-4,-7,-8};
    vector<int> c = min(a, b);
    for(auto d : c){
        cout << d << "\t";
    }
    cout << endl;
    string ans = a < b ? "true" : "false";
    cout << ans << endl;
}
