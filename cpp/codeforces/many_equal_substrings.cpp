//Codeforces Problem No. 1029 A
//Written by Xuqiang Fang on 24 Aug, 2018
/*
Description:
ou are given a string 
t consisting of n lowercase Latin letters and an integer number k .  Let's define a substring of some string 
s with indices from l to r as s [ l … r ] .  Your task is to construct such string s
 of minimum possible length that there are exactly k positions i such that s [ i … i + n − 1 ] = t . In other words
 , your task is to construct such string 
s of minimum possible length that there are exactly k substrings of s equal to t
.  It is guaranteed that the answer is always unique.  
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
    int n, k;
    cin >> n >> k;
    string t;
    cin >> t;
    int i = 1;
    while (i < n){
        int j = 0;
        for(; j<n-i; ++j){
            if(t[j] != t[j+i]){
                break;     
            }
        }
        if(j == n-i){
            break;
        }
        i++;
    }
    string s = t;
    if(i < n){
        string w = t.substr(n-i, i);
        while(k-->1){
            s += w;
        } 
    }
    else{
        while(k-->1){
            s += t;
        }
    }
    cout << s << endl;
    return 0;
}
