//Leetcode Problem No 115 Distinct Subsequences
//Solution written by Xuqiang Fang on 5 June, 2018

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
    int numDistinct(string s, string t){
        int n = t.length();
        int m = s.length();
        vector<vector<int>> dp(n+1, vector<int>(m+1, 0));   
        fill(dp[0].begin(), dp[0].end(), 1);
        for(int i=1; i<=n; ++i){
            for(int j=1; j<=m; ++j){
                if(s[j-1] == t[i-1]){
                    dp[i][j] = dp[i][j-1] + dp[i-1][j-1]; 
                }
                else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[n][m];
    }
};

int main(){
    Solution s;
    string s1 = "rabbbit";
    string t1 = "rabbit";
    string s2 = "babgbag";
    string t2 = "bag";
    string s3 = "daacaedaceacabbaabdccdaaeaebacddadcaeaacadbceaecddecdeedcebcdacdaebccdeebcbdeaccabcecbeeaadbccbaeccbbdaeadecabbbedceaddcdeabbcdaeadcddedddcececbeeabcbecaeadddeddccbdbcdcbceabcacddbbcedebbcaccac";
    string t3 = "ceadbaa";
    cout << s.numDistinct(s1, t1) << endl;
    cout << s.numDistinct(s2, t2) << endl;
    cout << s.numDistinct(s3, t3) << endl;
    return 0;
}
