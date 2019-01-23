//Leetcode Problem No 973 K Closest Points to Origin
//Solution written by Xuqiang Fang on 18 Jan, 2019

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
  vector<vector<int>> kClosest(vector<vector<int>>& p, int K) {
    unordered_map<int, vector<vector<int>>> m;
    vector<int> order;
    const int n = p.size();
    for(int i=0; i<n; ++i){
      int t = p[i][0]*p[i][0] + p[i][1]*p[i][1];
      if(m.count(t) == 0){
        order.push_back(t);
      }
      m[t].push_back({p[i][0], p[i][1]});
    }
    sort(order.begin(), order.end());
    int i = 0;
    vector<vector<int>> ans;
    while(i < order.size()){
      int j = 0;
      auto v = m[order[i]];
      while(ans.size() < K && j < v.size()){
        ans.push_back({v[j][0], v[j][1]});
        j++;
      }
      i++;
    }
    return ans;
  }
};

int main(){
    Solution s;
    vector<vector<int>> points{{1,3},{-2,2}};
    auto ans = s.kClosest(points, 1);
    for(auto& a : ans){
      cout << a[0] << " " << a[1] << endl;
    }
    points = {{3,3,},{5,-1}, {-2,4}};
    ans = s.kClosest(points, 2);    
    for(auto& a : ans){
      cout << a[0] << " " << a[1] << endl;
    }    
    return 0;
}
