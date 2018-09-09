//Codeforces Problem No. 1040 A
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
    int n, a, b;
    cin >> n >> a >> b;
    vector<int> color(n, 0);
    for(int i=0; i<n; ++i){
        cin >> color[i];
    }
    int c = min(a, b);
    int l = 0, r = n-1;
    int ans = 0;
    while(l < r){
        if(color[r] == color[l]){
            if(color[l] != 0 && color[l] != 1){
                ans += 2 * c; 
            }
        }
        else{
            if((color[l] == 1 && color[r] == 0) || (color[l] == 0 && color[r] == 1)){
                cout << -1 << endl;
                return 0;
            }
            else{
                if(color[l] == 0 || color[r] == 0){
                    ans += a;
                }
                else if(color[l] == 1 || color[r] == 1){
                    ans += b;
                }
            }
        }
        l++;
        r--;
    }
    if(l == r){
        if(color[l] != 0 && color[l] != 1){
            ans += c; 
        }
    }
    cout << ans << endl;
    return 0;
}
