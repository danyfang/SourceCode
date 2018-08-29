//Codeforces Problem No. 1023 A
//Written by Xuqiang Fang on 27 Aug, 2018
/*
Description:
You are given two strings s and t . The string s consists of lowercase Latin letters and at most one wildcard 
character '*', the string t consists only of lowercase Latin letters. The length of the string s equals n , 
the length of the string t equals m .  The wildcard character '*' in the string s (if any) can be replaced with 
an arbitrary sequence (possibly empty) of lowercase Latin letters. No other character of s can be replaced with
anything. If it is possible to replace a wildcard character '*' in s to obtain a string t , then the string t
matches the pattern s .  For example, if s = "aba*aba" then the following strings match it "abaaba", "abacaba"
and "abazzzaba", but the following strings do not match: "ababa", "abcaaba", "codeforces", "aba1aba", "aba?aba". 
If the given string t matches the given string s , print "YES", otherwise print "NO".
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
    int n, m;
    cin >> n >> m;
    string s, t;
    cin >> s;
    cin >> t;
    if(n > m + 1){
        cout << "NO" << endl;
        return 0;
    }
    int i = 0;
    while(i < n && s[i] != '*'){
        i++;
    }
    if(i == n){
        if(m != n){
            cout << "NO" << endl;
            return 0;
        }
        else{
            for(int x=0; x<m; ++x){
                if(s[x] != t[x]){
                    cout << "NO" << endl;
                    return 0;
                }
            }
            cout << "YES" << endl;
        }
    }
    else{
        int x = 0;
        while(x < i && s[x] == t[x]){
            ++x;
        }
        if(x != i){
            cout << "NO" << endl;
            return 0;
        }
        while(n-1 > i && s[n-1] == t[m-1]){
            --n;
            --m;
        }
        if(n-1 > i){
            cout << "NO" << endl;
        }
        else{
            cout << "YES" << endl; 
        }
    }
    return 0;
}
