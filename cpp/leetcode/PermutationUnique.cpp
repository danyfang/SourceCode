//Leetcode Problem No 47. Permutations II
//Solution written by Xuqiang Fang on 26 May, 2019

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
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        const int n = nums.size();
        sort(nums.begin(), nums.end());
        vector<vector<int>> ans;
        vector<int> tmp, used(n,0);
        backtrack(ans, nums, tmp, used);
        return ans;
    }
private:
    void backtrack(vector<vector<int>>& ans, const vector<int>& nums, vector<int>& tmp, vector<int>& used){
        if(tmp.size() == nums.size()){
            ans.push_back(tmp);
        }
        else{
            for(int i=0; i<nums.size(); ++i){
                if(used[i] || (i>0 && nums[i] == nums[i-1] && used[i-1]))
                    continue;
                used[i] = 1;
                tmp.push_back(nums[i]);
                backtrack(ans, nums, tmp, used);
                used[i] = 0;
                tmp.pop_back();
            }
        }
    }
};
void print(vector<int>& nums){
  for(auto n : nums){
    cout << n << " ";
  }
  cout << endl;
}
int main(){
  Solution s;
  vector<int> nums{9,9,8,8,7,6,3,2};
  auto ans = s.permuteUnique(nums);
  for(auto a : ans){
    print(a);
  }
  return 0;
}
