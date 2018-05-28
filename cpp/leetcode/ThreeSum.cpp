//Leetcode Problem No. 15 3Sum
//Solution written by Xuqiang Fang on 25 May, 2018

#include <iostream>
#include <vector>
#include <string>

using namespace std;
class Solution{
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        vector<vector<int>> res; 
        if(nums.size() < 3){
            return {};
        }
        sort(nums.begin(), nums.end());
        int i = 0;
        while(i < nums.size() - 2){
            if(nums[i] > 0){
                break;
            }
            int j = i+1;
            int k = nums.size() - 1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    res.push_back({nums[i], nums[j], nums[k]});
                }
                if(sum <= 0){
                    ++j;
                    while(nums[j] == nums[j-1] && j < k){
                        ++j;
                    }
                }
                if(sum >= 0){
                    --k;
                    while(nums[k+1] == nums[k] && j < k){
                        --k;
                    }
                }
            }
            ++i;
            while(nums[i] == nums[i-1] && i < nums.size() - 2){
                ++i;
            }
        }
        return res;
    }
};

int main(){
    Solution s;
    vector<int> nums{-1, 0, 1, 2, -1, -4};
    vector<vector<int>> ans = s.threeSum(nums);
    for(auto v : ans){
        for(auto w : v){
            cout << w << " ";
        }
        cout << "\n";
    }
    return 0;
}
