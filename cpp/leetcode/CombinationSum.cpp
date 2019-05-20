//Leetcode problem 39 Combination Sum 
//Solution written by Xuqiang Fang on 4 April, 2018

#include <vector>
#include <iostream>
using namespace std;
class Solution{
public:
    vector<vector<int> > combinationSum(vector<int> &nums, int target){
        sort(nums.begin(), nums.end());
        vector<vector<int> > result;
        vector<int> intermediate;
        dfs(nums, target, 0, intermediate, result);
        return result;
    }
private:
    void dfs(vector<int>& nums, int gap, int level, vector<int>& intermediate, vector<vector<int> >& result){
        if(gap == 0){
            result.push_back(intermediate);
            return;
        }

        for(size_t i = level; i<nums.size(); i++){
            if(gap < nums[i])
                return;

            intermediate.push_back(nums[i]);
            dfs(nums, gap-nums[i],i,intermediate, result);
            intermediate.pop_back();
        }
    }
};

int main(int argc, char* argv[]){
    Solution s;
    vector<int> nums{1,2,3};
    int target = 4;
    vector<vector<int> > result = s.combinationSum(nums, target);
    for(vector<int> v : result){
        for(int i : v){
            cout << i << "\t";
        }
        cout << "\n";
    }
    return 0;
}
