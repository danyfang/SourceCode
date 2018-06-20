//Leetcode Problem No 300 Longest Increasing Subsequence
//Solution written by Xuqiang Fang on 20 June, 2018

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
    int lengthOfLIS(vector<int>& nums) {
        const int n = nums.size();
        vector<int> t(n, 0);
        int ans = 0;
        for(int x : nums){
            int i = 0, j = ans;
            while(i < j){
                int m = (i+j) / 2;
                if(x > t[m]){
                    i = m + 1;
                }
                else{
                    j = m;
                }
            }
            t[i] = x;
            if (i == ans){
                ans++;
            }
        }
        return ans;
    }
};

int main(){
    Solution s;
    vector<int> nums{10,9,2,5,3,7,101,18};
    cout << s.lengthOfLIS(nums) << endl;
    return 0;
}
