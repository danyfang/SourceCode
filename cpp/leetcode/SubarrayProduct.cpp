//Leetcode Problem No 713 Subarray Product Less Than K
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
    int numSubarrayProductLessThanK(vector<int>& nums, int k) {
        const int n = nums.size();
        int ans = 0;
        int prod = 1;
        int l = 0, r = 0;
        for(int i=0; i<n; ++i){
            if(nums[i] < k){
                r++;
                prod *= nums[i];
                while(l <= r && prod >= k){
                    prod /= nums[l];
                    l++;
                }
                ans += r-l;
            } 
            else{
                l = i+1;
                r = i+1;
                prod = 1;
            }
            cout << "ans = " << ans << endl;
            cout << "prod = " << prod << endl;
        }
        return ans;
    }
};

int main(){
    Solution s;
    vector<int> nums{10,5,2,6,10,3,4,5,6,7,3,8};
    cout << s.numSubarrayProductLessThanK(nums, 100) << endl;
    return 0;
}
