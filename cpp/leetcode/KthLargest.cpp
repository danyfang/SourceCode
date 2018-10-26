//Leetcode Problem No 215 Kth Largest Element in an Array
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
    int findKthLargest(vector<int>& nums, int k) {
        const int n = nums.size();
        priority_queue<int, vector<int>,greater<int>> q;
        for(int i=0; i<k; ++i){
            q.push(nums[i]);
        }
        for(int i=k; i<n; ++i){
            if(nums[i]>q.top()){
                q.pop();
                q.push(nums[i]);
            }
        }
        return q.top();
    }
};

int main(){
    Solution s;
    vector<int> nums{3,2,1,5,6,4};
    cout << s.findKthLargest(nums, 2) << endl;
    nums = {3,2,3,1,2,4,5,5,6};
    cout << s.findKthLargest(nums, 4) << endl;
    return 0;
}
