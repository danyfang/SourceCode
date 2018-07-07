//Leetcode Problem No 300 Patching Array
//Solution written by Xuqiang Fang on 6 July, 2018

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
    int minPatches(vector<int>& nums, int n) {
        const int m = nums.size();
        long miss = 1; int added = 0; int i = 0;
        while(miss <= n){
            if(i < m && nums[i] <= miss){
                miss += nums[i++];
            }
            else{
                miss += miss;
                added++;
            }
        }
        return added;
    }
};

int main(){
    Solution s;
    vector<int> nums{1,5,10};
    cout << s.minPatches(nums, 20) << endl;
    return 0;
}
