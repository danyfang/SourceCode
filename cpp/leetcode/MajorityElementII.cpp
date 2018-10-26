//Leetcode Problem No 229 Majority Element II
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
    vector<int> majorityElement(vector<int>& nums) {
        vector<int> ans;
        const int m = nums.size();
        if(m == 0) return ans;
        int a = 0, b = 1, ca = 0, cb = 0;
        for(auto n : nums){
            if(n == a){
                ca++; 
            } 
            else if(n == b){
                cb++;
            }
            else if(ca == 0){
                a = n;
                ca = 1;
            }
            else if(cb == 0){
                b = n;
                cb = 1;
            }
            else{
                ca--;
                cb--;
            }
        }
        ca = 0;
        cb = 0;
        for(auto n : nums){
            if(n == a) ca++; 
            else if(n == b) cb++; 
        }
        if(ca > m/3) ans.push_back(a);
        if(cb > m/3) ans.push_back(b);
        return ans;
    }
};

int main(){
    Solution s;
    vector<int> nums{1,1,1,3,3,2,2,2};
    vector<int> ans = s.majorityElement(nums);
    for(auto a : ans){
        cout << a << "\t";
    }
    cout << endl;
    nums = {3,2,3};
    ans = s.majorityElement(nums);
    for(auto a : ans){
        cout << a << "\t";
    }
    cout << endl;
    return 0;
}
