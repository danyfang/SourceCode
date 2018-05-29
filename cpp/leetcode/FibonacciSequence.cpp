//Leetcode Problem No  842 Split Array into Fibonacci Sequence
//Solution written by Xuqiang Fang on 28 May, 2018

#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <unordered_map>
#include <unordered_set>
#include <stack>
#include <queue>

using namespace std;
class Solution{
public:
    vector<int> splitIntoFibonacci(string S) {
        if(S.length() < 3){
            return {};
        }    
        int n = S.length();
        vector<int> ans;
        for(int i=1; i<=n/2 && i<=10; ++i){
            for(int j=1; j<=(n-i)/2 && j<=10; ++j){
                if(dfs(ans, S, i, j)){
                    return ans;
                }
                ans.clear();
            }
        }
        return {};
    }

private:
    bool dfs(vector<int> &ans, string s, int i, int j){
        string a = s.substr(0,i);
        string b = s.substr(i,j);
        //cout << "a = " << a << ", b = " << b << endl;
        if(i > 1 && a[0] == '0'){
            return false;
        }
        if(j > 1 && b[0] == '0'){
            return false;
        }
        long x = stol(a);
        long y = stol(b);
        if(x + y > (long)INT_MAX){
            return false;
        }
        ans.push_back(x);
        string c = to_string(x+y);
        if(c == s.substr(i+j)){
            ans.push_back(y);
            ans.push_back(stol(c));
            return true; 
        }
        else if(s.substr(i+j).length() < c.length() || s.substr(i+j).substr(0,c.length()).compare(c) != 0){
            return false;
        }
        return dfs(ans, s.substr(i), j, c.length());
    }
};

int main(){
    Solution s;
    string s1 = "123456579";
    vector<int> ans = s.splitIntoFibonacci(s1);
    for(int a : ans){
        cout << a << " ";
    }
    cout << "\n";
    string s2 = "11235813";
    vector<int> ans2 = s.splitIntoFibonacci(s2);
    for(int a : ans2){
        cout << a << " ";
    }
    cout << "\n";
    string s3 = "74912134825162255812723932620170946950766784234934";
    vector<int> ans3 = s.splitIntoFibonacci(s3);
    for(int a : ans3){
        cout << a << " ";
    }
    cout << "\n";
    return 0;
}
