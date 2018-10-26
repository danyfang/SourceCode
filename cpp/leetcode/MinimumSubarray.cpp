//Leetcode Problem No 209 Minimum Size Subarray Sum
//Solution written by Xuqiang Fang on 25 Oct, 2018

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
    int minSubArrayLen(int s, vector<int>& nums) {
        const int n = nums.size();
        vector<int> sum(n+1, 0);
        for(int i=0; i<n; ++i){
            sum[i+1] = sum[i] + nums[i];
        }
        int l = 0, r = 1, ans = n;
        if(sum[n] < s) return 0;
        while(r <= n){
            if(sum[r]-sum[l] < s){
                r++;
            }
            else{
                while(l < r && sum[r]-sum[l] >= s){
                    ans = min(r-l, ans);
                    l++;
                }
            }
        }
        return ans;
    }
};

int main(){
    Solution s;
    vector<int> nums{2,3,1,2,4,3};
    cout << s.minSubArrayLen(7, nums) << endl;
    return 0;
}
