//Codeforces Problem No. 1037 B
//Written by Xuqiang Fang on 2 Sep, 2018
/*
Description:
You are given an array a of n integers and an integer s . It is guaranteed that n is odd.  In one operation
you can either increase or decrease any single element by one. Calculate the minimum number of operations
required to make the median of the array being equal to s .  The median of the array with odd length is the
value of the element which is located on the middle position after the array is sorted. For example, the
median of the array 6 , 5 , 8 is equal to 6 , since if we sort this array we will get 5 , 6 , 8 , and 6 is 
located on the middle position. 
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
    int n, m;
    cin >> n >> m;
    vector<int> a(n, 0);
    for(int i=0; i<n; ++i){
        cin >> a[i];
    }
    std::sort(a.begin(), a.end());
    int k = (n-1)/2;
    long long ans = 0;
    if(a[k] > m){
        int t = k;
        ans = 0;
        while(t >= 0 && a[t] > m){
            ans += (long long)(a[t]-m);
            t--; 
        }
    }
    else if(a[k] < m){
        int t = k;
        ans = 0;
        while(t < n && a[t] < m){
            ans += (long long)(m-a[t]);
            t++;
        }
    }
    cout << ans << endl;
    return 0;
}
