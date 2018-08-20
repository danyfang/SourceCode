//Codeforces Problem No. 888 A
//Written by Xuqiang Fang on 16 Aug, 2018
/*
Description: A local Extrema
You are given an array a. Some element of this array ai is a local minimum iff it is strictly less than both
of its neighbours (that is, ai < ai - 1 and ai < ai + 1). Also the element can be called local maximum iff it
is strictly greater than its neighbours (that is, ai > ai - 1 and ai > ai + 1). Since a1 and an have only one
neighbour each, they are neither local minima nor local maxima.

An element is called a local extremum iff it is either local maximum or local minimum. Your task is to 
calculate the number of local extrema in the given array.
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

int main(){
    int n;
    cin >> n;
    int arr[n];
    for(int i=0; i<n; ++i){
        cin >> arr[i];
    }
    int ans = 0;
    for(int i=1; i<n-1; ++i){
        if(arr[i] > arr[i-1] && arr[i] > arr[i+1]){
            ans++;
        }
        else if(arr[i] < arr[i-1] && arr[i] < arr[i+1]){
            ans++;
        }
    }
    cout << ans << endl;
    return 0;
}
