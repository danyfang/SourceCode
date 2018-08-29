//Codeforces Problem No. 1024 B 
//Written by Xuqiang Fang on 27 Aug, 2018
/*
Description:
Tanechka is shopping in the toy shop. There are exactly n toys in the shop for sale, the cost of the i -th toy
is i burles. She wants to choose two toys in such a way that their total cost is k burles. How many ways to do
that does she have?  Each toy appears in the shop exactly once. Pairs ( a , b) and ( b , a) are considered equal.
Pairs ( a , b) , where a = b , are not allowed.
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

typedef unsigned long long int ull;

using namespace std;

int main(){
    ull n, k; 
    cin >> n >> k;
    auto s = 2*n-1;
    if(s < k){
        cout << 0 << endl;
    }
    else{
        auto a = (k-1)/2; 
        if(k-1 <= n){
            cout << a << endl;
        }
        else{
            cout << a - (k-n-1) << endl;
        }
    }
    return 0;
}
