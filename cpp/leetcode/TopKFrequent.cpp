//Leetcode Problem No 347 Top K Frequent Elements
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
    vector<int> topKFrequent(vector<int>& nums, int k) {
        const int n = nums.size();
        unordered_map<int, int> m;
        int mx = 0;
        for(auto&a : nums){
            m[a]++;
            mx = max(mx, m[a]);
        }
        vector<unordered_set<int>> f(mx+1);
        for(auto it=m.begin(); it!=m.end(); ++it){
            f[it->second].insert(it->first);
        }
        vector<int> ans;
        for(int i=mx; i>=0; --i){
            for(auto it=f[i].begin(); it!=f[i].end(); ++it){
                if(ans.size() < k){
                    ans.push_back(*it);
                }
                else if(ans.size() == k){
                    return ans;
                }
            }
        }
        return ans;
    }
};

int main(){
    Solution s;
    vector<int> nums{1,1,1,2,2,3};
    vector<int> ans = s.topKFrequent(nums, 2) ;
    for(auto a : ans){
        cout << a << "\t";
    }
    cout << endl;
    return 0;
}
