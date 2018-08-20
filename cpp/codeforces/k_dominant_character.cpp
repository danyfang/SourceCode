//Codeforces Problem No. 888 C 
//Written by Xuqiang Fang on 16 Aug, 2018
/*
Description:  K-Dominant Character
You are given a string s consisting of lowercase Latin letters. Character c is called k-dominant iff 
each substring of s with length at least k contains this character c.

You have to find minimum k such that there exists at least one k-dominant character.
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

/**
solution min(max(gap of each letter))
*/
int main(){
    string s;
    cin >> s;
    const int n = s.size();
    vector<vector<int>> arr(26, vector<int>(1, -1));
    for(int i=0; i<n; ++i){
        arr[(int)(s[i]-'a')].push_back(i); 
    }
    int ans = 1 << 20;
    for(int i=0; i<26; ++i){
        if(arr[i].size() > 1){
            int gap = 0;
            for(int j=1; j<arr[i].size(); ++j){
                gap = max(gap, arr[i][j]-arr[i][j-1]); 
            }
            gap = max(gap, n-arr[i][arr[i].size()-1]);
            ans = min(gap, ans);
        }
    }
    cout << ans << endl;
    return 0;
}
