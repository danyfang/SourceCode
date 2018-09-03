//Codeforces Problem No. 1037 C
//Written by Xuqiang Fang on 2 Sep, 2018
/*
Description:
You are given two binary strings a and b of the same length. You can perform the following two operations on 
the string a : Swap any two bits at indices i and j respectively ( 1 ≤ i , j ≤ n), the cost of this operation
is | i − j | , that is, the absolute difference between i and j .  Select any arbitrary index i ( 1 ≤ i ≤ n)
and flip (change 0 to 1 or 1 to 0) the bit at this index. The cost of this operation is 1 .  Find the minimum 
cost to make the string a equal to b . It is not allowed to modify string b .
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
    int n;
    string a, b;
    cin >> n;
    cin >> a;
    cin >> b;
    int ans = 0;
    vector<int> used(n, 0);
    for(int i=0; i<n; ++i){
        if(a[i] != b[i]){
            ans++;
        }
        if(i >= 1 && a[i] != b[i] && a[i-1] != b[i-1] && !used[i-1] && (a[i] != a[i-1])){
            used[i] = 1;
            used[i-1] = 1;
            ans--;
        }
    }
    cout << ans << endl;
    return 0;
}
