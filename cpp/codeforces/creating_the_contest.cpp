//Codeforces Problem No. 1029 B
//Written by Xuqiang Fang on 24 Aug, 2018
/*
Description:
You are given a problemset consisting of n problems. The difficulty of the i -th problem is a i
. It is guaranteed that all difficulties are distinct and are given in the increasing order.  
You have to assemble the contest which consists of some problems of the given problemset. In other words, the contest you have to assemble should be a subset of problems (not necessary consecutive) of the given problemset. There is only one condition that should be satisfied: for each problem but the hardest one (the problem with the maximum difficulty) there should be a problem with the difficulty not greater than twice the difficulty of this problem. In other words, let 
a i 1 , a i 2 , … , a i p be the difficulties of the selected problems in increasing order. Then for each j
 from 1 to p − 1 a i j + 1 ≤ a i j ⋅ 2 should hold. It means that the contest consisting of only one problem is always valid.  Among all contests satisfying the condition above you have to assemble one with the maximum number of problems. Your task is to find this number of problems.
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
int binary_search(int i, int l, int r, vector<int>& arr){
    while(l < r){
        int m = (l + r) / 2;
        if(arr[m] <= 2 * arr[i]){
            l = m + 1;
        }
        else{
            r = m;
        }
    }
    return (l-i);
}
int main(){
    int n;
    cin >> n;
    vector<int> arr(n, 0);
    for(int i=0; i<n; ++i){
        cin >> arr[i];
    }
    int ans = 1;
    int i = 0;
    while(i < n){
        int j = i+1;
        while(j < n && arr[j] <= 2 * arr[j-1] ){
            j++;
        }
        ans = max(ans, j-i);
        i = j;
    }
    cout << ans << endl;
    return 0;
}
