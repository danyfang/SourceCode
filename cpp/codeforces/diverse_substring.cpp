//Codeforces Problem No. 1073 A
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

string valid(string s){
    int count[26] = {0};
    int m = 0;
    for(auto c : s){
        count[c-'a']++;
    }
    if(*max_element(count, count+26) * 2 <= s.length()){
        return s;
    }
    return "";
}
int main(){
    int n;
    string s;
    cin >> n;
    cin >> s;
    for(int i=0; i<s.length(); ++i){
        for(int j=2; i+j<=s.length(); ++j){
            auto ans = valid(s.substr(i, j));
            if(ans != ""){
                cout << "YES" << endl;
                cout << ans << endl;
                return 0;
            }
        }
    }
    cout << "NO" << endl;
    return 0;
}
