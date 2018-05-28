//Leetcode Problem No 26 Remove Duplicates from Sorted Array
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
    int removeDuplicates(vector<int>& nums){
        int n = nums.size();
        if(n == 0){
            return 0;
        }
        //s represents the current index of the last unique number
        //and that number is the one that all others compare with
        //it is sorted!
        int s = 0;
        for(int i=1; i<n; ++i){
            if(nums[i] != nums[s]){
                nums[++s] = nums[i];
            } 
        }
        return s+1;
    }
};

int main(){
    Solution s;
    vector<int> nums{1,1,1,2,2,3,4,5,5,6,7,7,8,8,9,10,11,11,11,11,12};
    vector<int> nu{1};
    cout << s.removeDuplicates(nums) << endl;
    cout << s.removeDuplicates(nu) << endl;
    for(auto n : nums){
        cout << n << " ";
    }
    cout << "\n";
    return 0;
}
