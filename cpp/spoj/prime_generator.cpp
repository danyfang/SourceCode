//spoj problem no. 2 Prime Generator
//written by xuqiang fang on 20 Aug, 2018
/*Description
Your task is to generate all prime numbers between two given numbers!
*/
#include <iostream>
#include <string>
#include <vector>
#include <unordered_map>
#include <map>
#include <unordered_set>
#include <set>
#include <stack>
#include <cmath>

using namespace std;

bool prime(int n){
    if(n < 2){
        return false;
    }
    else if(n == 2){
        return true;
    }
    int m = (int)sqrt(n);
    for(int i=2; i<=m; ++i){
        if(n%i == 0){
            return false;
        }
    }
    return true;
}
int main(){
    int t;
    cin >> t;
    int m, n;
    while(t-- > 0){
        cin >> m >> n;
        for(int i=m; i<=n; ++i){
            if(prime(i)){
                cout << i << endl;
            }
        }
        cout << endl;
    }
    return 0;
}
