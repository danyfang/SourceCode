//spoj problem no. 3 Substring Check
//written by xuqiang fang on 20 Aug, 2018
/*Description
Given two binary strings, A (of length 10) and B (of length 5), output 1 if B is a substring of A and 0 otherwise.
*/
#include <iostream>
#include <string>
#include <vector>
#include <unordered_map>
#include <map>
#include <unordered_set>
#include <set>
#include <stack>
#include <queue>
using namespace std;
bool sub(string a, string b){
    int m = a.size(), n = b.size();
    for(int i=0; i<m-n; ++i){
        int j = 0;
        while(j < n && a[i+j] == b[j]){
            j++;
        }
        if(j == n){
            return true;
        }
    }
    return false;
}
int main(){
    string A, B;
    int i = 0;
    while(i++ < 24){
        cin >> A >> B;
        if(sub(A, B)){
            cout << 1 << endl;
        }
        else{
            cout << 0 << endl;
        }
    }
    return 0;
}
