//Leetcode Problem No 494 Target Sum
//Solution written by Xuqiang Fang on 24 Oct, 2018 

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
    int findTargetSumWays(vector<int>& nums, int S) {
        const int n = nums.size();
        int sum = 0;
        for(auto &s : nums){
            sum += s;
        }
        if(sum < S) return 0;
        vector<vector<int>> dp(n+1, vector<int>(2*sum+1, 0));
        dp[0][sum] = 1;
        for(int i=0; i<n; ++i){
            for(int j=nums[i]; j<2*sum+1-nums[i]; ++j){
                if(dp[i][j]){
                    dp[i+1][j+nums[i]] += dp[i][j];
                    dp[i+1][j-nums[i]] += dp[i][j];
                }
            }
        }
        return dp[n][S+sum];
    }
};

int main(){
    Solution s;
    vector<int> nums{1,1,1,1,1};
    cout << s.findTargetSumWays(nums, 3) << endl;
    cout << s.findTargetSumWays(nums, -3) << endl;
    cout << s.findTargetSumWays(nums, -5) << endl;
    return 0;
}
