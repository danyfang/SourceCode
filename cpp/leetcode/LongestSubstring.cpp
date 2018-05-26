//Leetcode Problem No. 3 Longest Substring Without Repeating Characters
//Solution written by Xuqiang Fang on 24 May, 2018

#include <iostream>
#include <string>
#include <vector>

using namespace std;

class Solution{
public:
    int lengthOfLongestSubstring(string s) {
        if (s.length() == 0){
            return 0;
        }
        //dp[i] is the longest substring end with character s[i]
        int n = s.length();
        vector<int> dp(n, 0);
        dp[0] = 1;
        int updated = 0;
        int ans = 1;
        for(int i=1; i<dp.size(); ++i){
            updated = 0;
            for(int j=i-dp[i-1]; j<i; ++j){
                if(s[j] == s[i]){
                    dp[i] = i-j;
                    updated = 1;
                    break;
                }
            }
            if(!updated){
                dp[i] = dp[i-1]+1;
            }
            ans = max(ans, dp[i]);
        }
        /**
        for(auto i : dp){
            cout << i << "\t";
        }
        cout << endl;
        */
        return ans;
    }
};

int main(){
    Solution s;
    string s1 = "abcabcbb";
    cout << s.lengthOfLongestSubstring(s1) << endl;
    string s2 = "bbbbb";
    cout << s.lengthOfLongestSubstring(s2) << endl;
    string s3 = "pwwkew";
    cout << s.lengthOfLongestSubstring(s3) << endl;
    return 0;
}
