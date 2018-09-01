//Codeforces Problem No. 1023 C
//Written by Xuqiang Fang on 27 Aug, 2018
/*
Description:
A bracket sequence is a string containing only characters "(" and ")". A regular bracket sequence is a
bracket sequence that can be transformed into a correct arithmetic expression by inserting characters
"1" and "+" between the original characters of the sequence. For example, bracket sequences "()()" and
"(())" are regular (the resulting expressions are: "(1)+(1)" and "((1+1)+1)"), and ")(", "(" and ")" are not.  
Subsequence is a sequence that can be derived from another sequence by deleting some elements without
changing the order of the remaining elements.  You are given a regular bracket sequence s and an 
integer number k . Your task is to find a regular bracket sequence of length exactly k such that it is
also a subsequence of s .  
It is guaranteed that such sequence always exists.
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

//the first helper() function got TLE
/*
string helper(string& s, int l, int r, int k){
    if(k == 2){
        return "()";
    }
    int i = 0;
    for(int x=l; x<r; ++x){
        if(s[x] == '('){
            ++i;
        }
        else{
            --i;
        }
        if(i == 0){
            int len = x+1-l;
            if(len == k){
                return s.substr(l, len);
            } 
            else if(len < k){
                return s.substr(l, len) + helper(s, l+len, r,  k-len);
            }
            else{
                if(len > 2 * k){
                    return "(" + helper(s, l+1, l+len-1, k-2) + ")";
                }
                return helper(s, l+1, l+len-1, k);
            }
        }
    }
    return "";
}
*/
string helper(string& s, vector<int>& used, int k){
    stack<int> st;
    int c = 0;
    string ans;
    for(int i=0; i<s.size(); ++i){
        if(s[i] == '('){
            st.push(i);
        }
        else{
            used[i] = 1;
            used[st.top()] = 1;
            c += 2;
            st.pop();
        }
        if(c == k){
            for(int j=0; j<=i; ++j){
                if(used[j]){
                    ans.push_back(s[j]);
                }
            } 
            break;
        }
    }
    return ans;
}
int main(){
    int n, k;
    cin >> n >> k;
    string s;
    cin >> s;
    if(n == k){
        cout << s << endl;
    }
    else{
        vector<int> used(n, 0);
        cout << helper(s, used, k) << endl;
    }
    return 0;
}
