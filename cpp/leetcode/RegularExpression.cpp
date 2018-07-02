//Leetcode Problem No 10 Regular Expression Matching
//Solution written by Xuqiang Fang on 26 June, 2018

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
    bool isMatch(string s, string p) {
        const int len_s = s.length();
        const int len_p = p.length();
        vector<vector<int>> dp(len_s+1, vector<int>(len_p+1, 0));
        dp[0][0] = 1;
        for(int i=0; i<len_p; ++i){
            if(p[i] == '*' && dp[0][i-1]){
                dp[0][i+1] = 1;
            }
        }
        for(int i=0; i<len_s; ++i){
            for(int j=0; j<len_p; ++j){
                if(p[j] == '.' || p[j] == s[i]){
                    dp[i+1][j+1] = dp[i][j];
                }
                if(p[j] == '*'){
                    if(p[j-1] != s[i] && p[j-1] != '.'){
                        dp[i+1][j+1] = dp[i+1][j-1];
                    }
                    else{
                        dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
                    }
                }
            }
        }
        return dp[len_s][len_p];
    }
};

int main(){
    Solution s;
    cout << s.isMatch("aa", "a*") << endl;
    cout << s.isMatch("ab", ".*") << endl;
    cout << s.isMatch("aab", "c*a*b") << endl;
    cout << s.isMatch("mississippi", "mis*is*p*") << endl;
    return 0;
}
