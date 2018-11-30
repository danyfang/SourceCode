//Leetcode Problem No 422 Find All Duplicates in an Array
//Solution written by Xuqiang Fang on 13 Nov, 2018

#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <unordered_map>
#include <unordered_set>
#include <stack>
#include <queue>

using namespace std;
class Solution {
public:
    vector<int> findDuplicates(vector<int>& nums) {
        const int n = nums.size();
        vector<int> ans;
        for(int i=0; i<n; ++i){
            int index = abs(nums[i])-1;
            if(nums[index] < 0) ans.push_back(index+1);
            nums[index] = - nums[index];
        }
        return ans;
    }
};
int main(){
    Solution s;
    vector<int> nums{4,3,2,7,8,2,3,1};
    for(auto a : s.findDuplicates(nums))
        cout << a << endl;
    return 0;
}
