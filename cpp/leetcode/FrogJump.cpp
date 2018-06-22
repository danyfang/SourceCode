//Leetcode Problem No 403 Frog Jump
//Solution written by Xuqiang Fang on 22 June, 2018

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
    bool canCross(vector<int>& stones) {
        if(stones[1] != 1){
            return false;
        }
        const int n = stones.size();
        unordered_map<int, unordered_set<int>> dp;
        for(const int& s : stones){
            dp.emplace(s, unordered_set<int>());
        }
        dp[1].emplace(1);
        for(int i=1; i<n-1; ++i){
            for(const int j : dp[stones[i]]){
                for(const int k : {j-1, j, j+1}){
                    if(k > 0 && dp.count(stones[i]+k)){
                        dp[stones[i]+k].emplace(k);
                    }
                }
            }
        }
        return !dp[stones[n-1]].empty();
    }
};

int main(){
    Solution s;
    vector<int> stones{0,1,3,5,6,8,12,17};
    cout << s.canCross(stones) << endl;
    stones = {0,1,2,3,4,8,9,11};
    cout << s.canCross(stones) << endl;
    return 0;
}
