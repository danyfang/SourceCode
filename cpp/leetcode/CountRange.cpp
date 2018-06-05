//Leetcode Problem No 327 Count of Range Sum
//Solution written by Xuqiang Fang on 5 June, 2018

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
    //naive algorithm
    int countRangeSum(vector<int>& nums, int lower, int upper) {
        int n = nums.size();
        if(n == 0){
            return 0;
        }
        vector<long> s(n, 0);
        s[0] = (long)nums[0];
        for(int i=1; i<n; ++i){
            s[i] += s[i-1] + (long)nums[i];
        }
        int count = 0;
        for(int i=0; i<n; ++i){
            if(s[i] <= upper && s[i] >= lower){
                count++;
            }
            for(int j=i+1; j<n; ++j){
                int t = s[j] - s[i];
                if(t <= upper && t >= lower){
                    count++;
                }
            }
        }
        return count;
    }
};

int main(){
    Solution s;
    vector<int> nums{-2,5,-1};
    cout << s.countRangeSum(nums, -2, 2) << endl;
    vector<int> num{-2147483647,0,-2147483647,2147483647};
    cout << s.countRangeSum(num, -564, 3864) << endl;
    return 0;
}
