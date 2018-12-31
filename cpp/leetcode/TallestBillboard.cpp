//Leetcode Problem No 956 Tallest Billboard
//Solution written by Xuqiang Fang on 18 Dec, 2018

#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <unordered_map>
#include <unordered_set>
#include <stack>
#include <queue>
#include <bitset>

using namespace std;
class Solution{
public:
  /*
    dp[d] means the maximum pair of sum we can get with the pair
    difference d. If we have dp[d] = a, it means we have a pair of 
    sum (a, d+d) and this is the biggest pair with differece d.
    for each new element, we update the dp table.
    we have three choice for the new element, add it to first group
    or add it to second group or do not use it.
   */
  int tallestBillboard(vector<int>& rods) {
      unordered_map<int, int> dp;
      dp[0] = 0;
      for(int x : rods){
        unordered_map<int, int> cur(dp);
        for(auto it : cur){
          int d = it.first;
          dp[d+x] = max(dp[d+x], cur[d]);
          dp[abs(d-x)] = max(dp[abs(d-x)], cur[d]+min(d,x));
        }
      }
      return dp[0];
    }
};

int main(){
    Solution s;
    vector<int> rods{1,2,3,6};
    cout << s.tallestBillboard(rods) << endl;;
    rods = {1,2,3,4,5,6};
    cout << s.tallestBillboard(rods) << endl;;
    return 0;
}
