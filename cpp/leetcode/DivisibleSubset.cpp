//Leetcode Problem No 368 Largest Divisible Subset
//Solution written by Xuqiang Fang on 28 May, 2018

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
    //T[n] the size of the largest divisible subset with the largest element being n
    /*
    *if s is a divisible set, and q is the new element, then either q divides the smallest element 
    * or q is divisible by the largest element
    */
    vector<int> largestDivisibleSubset(vector<int>& nums) {
        int n = nums.size();
        if(n == 0){
            return {};
        }
        vector<int> dp(n, 1);
        vector<int> trace(n, -1);
        sort(nums.begin(), nums.end());
        int m = 1;
        int index = 0;
        for(int i=1; i<n; ++i){
            for(int j=i-1; j>=0; --j){
                if(nums[i] % nums[j] == 0){
                    if(1+dp[j] > dp[i]){
                        dp[i] = dp[j] + 1;
                        trace[i] = j; 
                    }
                }
            }
            if(dp[i] > m){
                m = dp[i];
                index = i;
            }
        }
        /*
        for(auto d : trace){
            cout << d << " ";
        }
        */
        vector<int> ans(m, 0);
        for(int i=m-1; i>=0; --i){
            ans[i] = nums[index];
            index = trace[index];
        }
        return ans;
    }
};

int main(){
    Solution s;
    vector<int> nums{1,2,4,8};
    vector<int> ans = s.largestDivisibleSubset(nums);
    for(auto a : ans){
        cout << a << "  ";
    }
    cout << "\n";
    vector<int> nus{1,2,3};
    vector<int> an = s.largestDivisibleSubset(nus);
    for(auto a : an){
        cout << a << "  ";
    }
    cout << "\n";
    return 0;
}

