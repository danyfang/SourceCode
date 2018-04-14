//Leetcode Problem No. 72 Edit Distance
//Solution written by Xuqiang Fang on 12 April, 2018 

#include <iostream>
#include <vector>
#include <string>

using namespace std;

class Solution{
public:
    int minDistance(string word1, string word2){
        int l1 = word1.length();
        int l2 = word2.length();
        dp = vector<vector<int>>(l1+1, vector<int>(l2+1,-1));

        return minDistance(word1, word2, l1, l2);
    }
private:
    vector<vector<int>> dp;
    int minDistance(string word1, string word2, int l1, int l2){
        if(l1 == 0)
            return l2;
        if(l2 == 0)
            return l1;
        if(dp[l1][l2] >= 0)
            return dp[l1][l2];

        int ans;
        if(word1[l1-1] == word2[l2-1])
            ans = minDistance(word1, word2, l1-1, l2-1);
        else
            ans = min(minDistance(word1, word2, l1-1, l2), 
                    min(minDistance(word1, word2, l1, l2-1),
                    minDistance(word1, word2, l1-1, l2-1))) + 1;

        return dp[l1][l2] = ans;
    }
};

int main(){
    Solution s;
    string word1("hellasfsdo");
    string word2("world");
    cout << s.minDistance(word1, word2) << endl;
    return 0;
}
