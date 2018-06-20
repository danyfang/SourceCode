//Leetcode Problem No 719 Find K-th Smallest Pair Distance
//Solution written by Xuqiang Fang on 19 June, 2018

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
    int smallestDistancePair(vector<int>& nums, int k) {
        const int n = nums.size();
        sort(nums.begin(), nums.end());
        int l = 0;
        int r = nums[n-1];
        while(l <= r){
            int m = (l + r) / 2;
            int count = 0;
            int dis = 0;
            int j = n-1;
            for(int i=n-2; i>=0; --i){
                while(j > i && nums[j] - nums[i] > m){
                    --j;
                }
                count += j - i;
                if(nums[j] - nums[i] > dis){
                    dis = nums[j] - nums[i];
                }
            }
            if(count == k || l == r){
                return dis;
            }
            else if(count > k){
                r = m;
            }
            else{
                l = m + 1;
            }
        }
        return 0;
    }
};

int main(){
    Solution s;
    vector<int> nums{1,3,1};
    vector<int> num{9,10,7,10,6,1,5,4,9,8};
    cout << s.smallestDistancePair(nums, 1) << endl;
    cout << s.smallestDistancePair(nums, 2) << endl;
    cout << s.smallestDistancePair(nums, 3) << endl;
    cout << s.smallestDistancePair(num, 18) << endl;
    cout << s.smallestDistancePair(num, 19) << endl;
    return 0;
}
