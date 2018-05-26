//Leetcode Problem No. 5 Longest Palindromic Substring 
//Solution written by Xuqiang Fang on 24 May, 2018

#include <iostream>
#include <string>
#include <vector>

using namespace std;

class Solution{
public:
    string longestPalindrome(string s) {
        int n = s.length();
        if(n == 0){
            return s;
        }
        vector<int> dp(n, 0);
        dp[0] = 1;
        string ans = s.substr(0,1);
        //dp[i], longest parlin ending with character s[i]
        for(int i=1; i<n; ++i){
            int c = dp[i-1];        
            if(i-c-1 >= 0 && s[i] == s[i-c-1]){
                dp[i] = dp[i-1] + 2;
            }
            else{
                for(int j=i-c; j<=i; ++j){
                    if(isPalin(s.substr(j,i+1-j))){
                        dp[i] = i-j+1;
                        break;
                    }
                }
            }
            if(dp[i] > ans.length()){
                ans = s.substr(i+1-dp[i], dp[i]);
            }
        }
        return ans;
    }

private:
    int isPalin(string s){
        int l = 0;
        int r = s.length()-1;
        while(l < r){
            if(s[l++] != s[r--]){
                return 0;
            }
        }
        return 1;
    }
};

int main(){
    Solution s;
    string s1 = "babad";
    cout << s.longestPalindrome(s1) << endl;
    string s2 = "cbbd";
    cout << s.longestPalindrome(s2) << endl;
    string s3 = "a";
    cout << s.longestPalindrome(s3) << endl;
    return 0;
}
