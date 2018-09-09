//Codeforces Problem No. 1040 B
//Written by Xuqiang Fang on 5 Sep, 2018
/*
Description:

*/
#include <cmath>
#include <iostream>
#include <string>
#include <vector>
#include <unordered_map>
#include <map>
#include <unordered_set>
#include <set>
#include <stack>
#include <queue>
#include <algorithm>
using namespace std;

int main(){
    int n, k;
    cin >> n >> k;
    int ans = 0;
    vector<int> v;
    if(n % (2*k+1) == 0){
        ans = n / (2*k+1);
        int i = k+1;
        while(i <= n){
            v.push_back(i);
            i += 2*k+1;
        }
    }
    else{
        ans = n / (2*k+1) + 1;
        int t = ans * (2*k+1);
        if(t >= n + k){
            int i = 1;
            while(i <= n){
                v.push_back(i);
                i += 2*k+1;
            }
        }
        else{
            int i = n+k-t+1;
            while(i <= n){
                v.push_back(i);
                i += 2*k+1;
            }
        }
    }
    cout << ans << endl;
    for(auto i : v){
        cout << i << " ";
    }
    cout << endl;
    return 0;
}
