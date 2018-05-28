//Leetcode Problem No 27 Remove Element
//Solution written by Xuqiang Fang on 26 May, 2018

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
    //the idea is to use two pointer
    int removeElement(vector<int>& nums, int v){
        int n = nums.size();
        if(n == 0){
            return 0;
        }
        int f = 0;
        int s = 0;
        while(f < n){
            if(nums[f] == v){
                ++f;
            }
            else{
                nums[s++] = nums[f++];
            }
        }
        return s;
    }
};

int main(){
    Solution s;
    vector<int> nums = {0,1,2,2,3,0,4,2};
    cout << s.removeElement(nums, 2) << endl;
    for(auto n : nums){
        cout << n << " ";
    }
    cout << "\n";
    return 0;
}
