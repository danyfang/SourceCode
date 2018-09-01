//Codeforces Problem No. 1027 A Palindromic Twist
//Written by Xuqiang Fang on 30 Aug, 2018
/*
Description:

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
#include <cmath>

using namespace std;

int main(){
    int T, n;
    string s;
    cin >> T;
    while(T-->0){
        cin >> n;
        cin >> s;
        int l = 0; 
        int r = n-1;
        int flag = 1;
        while(l < r){
            int t = abs(s[l]-s[r]);
            if(t != 0 && t != 2){
                cout << "NO" << endl;
                flag = 0;
                break;
            }
            ++l;
            --r;
        }
        if(flag){
            cout << "YES" << endl;
        }
    }
    return 0;
}
