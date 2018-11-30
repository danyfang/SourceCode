//Codeforces Problem No. 1073 B Vasya and Books
//Written by Xuqiang Fang on 14 Nov, 2018
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
    int n;
    vector<int> a, b;
    cin >> n;
    for(int i=0; i<n; ++i){
        int t;
        cin >> t;
        a.push_back(t);
    }
    for(int i=0; i<n; ++i){
        int t;
        cin >> t;
        b.push_back(t);
    }
    unordered_map<int, int> m;
    for(int i=0; i<n; ++i){
        m[a[i]]  = i;
    }
    vector<int> ans;
    unordered_set<int> s;
    int curr = 0;
    for(int i=0; i<n; ++i){
        curr = max(curr, i);
        int index = m[b[i]];
        if(index == curr){
            ans.push_back(1);
            curr++;
        }
        else if(index > curr){
            ans.push_back(index+1-curr);
            curr = index + 1;
        }
        else{
            ans.push_back(0);
        }
    }
    for(auto x : ans)
        cout << x << "  ";
    cout << endl;
    return 0;
}
