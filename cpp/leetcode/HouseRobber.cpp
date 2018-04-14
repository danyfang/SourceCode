//Leetcode Problem No. 198 House Robber 
//Solution written by Xuqiang Fang on 11 April, 2018 

#include <iostream>
#include <vector>

using namespace std;

class Solution{
public:
    int rob(vector<int>& nums){
        if(nums.empty()) return 0;
        const int n = nums.size();
        vector<int> dp(n, 0);
        if(n == 1)
            return nums[0];
        if(n == 2)
            return max(nums[0], nums[1]);
        dp[0] = nums[0];
        dp[1] = max(nums[1], nums[0]);
        for(int i=2; i<n; i++){
            dp[i] = max(dp[i-2]+nums[i], dp[i-1]);
        }

        return dp.back();
    }
};

int main(){
    Solution s;
    vector<int> nums{1,2,3,4,5,6,7};
    cout << s.rob(nums) << endl;
    return 0;
}
