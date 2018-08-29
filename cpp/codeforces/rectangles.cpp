//Codeforces Problem No. 1028 C
//Written by Xuqiang Fang on 27 Aug, 2018
/*
Description:
You are given n rectangles on a plane with coordinates of their bottom left and upper right points.
Some ( n − 1) of the given n rectangles have some common point. A point belongs to a rectangle if 
this point is strictly inside the rectangle or belongs to its boundary.  Find any point with integer
coordinates that belongs to at least ( n − 1) given rectangles.
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
#include <algorithm>

#define f(i, N) for(int i=0; i<N; ++i)
using namespace std;
vector<int> m[4];
int main(){
    int n;
    cin >> n;
    int a, b, c, d;
    for(int i=0; i<n; ++i){
        cin >> a >> b >> c >> d;
        m[0].push_back(a);
        m[1].push_back(b);
        m[2].push_back(c);
        m[3].push_back(d);
    }
    priority_queue<int, vector<int>, greater<int>> p2, p3;
    priority_queue<int> p0, p1;
    vector<vector<int>> pref(n, vector<int>(4)), suf(n, vector<int>(4));
    int i = 0;
    f(i, n){
        p0.push(m[0][i]); 
        p1.push(m[1][i]); 
        p2.push(m[2][i]); 
        p3.push(m[3][i]); 
        pref[i] = {p0.top(), p1.top(), p2.top(), p3.top()};
    }
    priority_queue<int, vector<int>, greater<int>> pp2, pp3;
    priority_queue<int> pp0, pp1;
    f(i, n){
        pp0.push(m[0][n-1-i]); 
        pp1.push(m[1][n-1-i]); 
        pp2.push(m[2][n-1-i]); 
        pp3.push(m[3][n-1-i]); 
        suf[n-1-i] = {pp0.top(), pp1.top(), pp2.top(), pp3.top()};
    }
    if(pref[n-2][0] <= pref[n-2][2] && pref[n-2][1] <= pref[n-2][3]){
        //cout << "case 1 here" << endl;
        cout << pref[n-2][0] << " " << pref[n-2][1] << endl;
    }
    else if(suf[1][0] <= suf[1][2] && suf[1][1] <= suf[1][3]){
        //cout << "case 2 here" << endl;
        cout << suf[1][0] << " " << suf[1][1] << endl;
    }
    else{
        //cout << "case 3 here" << endl;
        for(int i=1; i<n-1; ++i){
            int left = max(pref[i-1][0], suf[i+1][0]);
            int down = max(pref[i-1][1], suf[i+1][1]);
            int right = min(pref[i-1][2], suf[i+1][2]);
            int up = min(pref[i-1][3], suf[i+1][3]);
            if(left <= right && down <= up){
                cout << (left + right)/2 << " " << (up + down)/2 << endl;
                break;
            }
        }
    }
    return 0;
}
