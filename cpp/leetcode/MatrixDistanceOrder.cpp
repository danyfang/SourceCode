//Leetcode Problem No 1030. Matrix Cells in Distance Order
//Solution written by Xuqiang Fang on 12 May, 2019

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
  vector<vector<int>> allCellsDistOrder(int R, int C, int r0, int c0) {
    unordered_map<int, vector<int>> m;
    vector<vector<int>> v;
    for(int i=0; i<R; ++i){
      for(int j=0; j<C; ++j){
        int index = j + i * C;
        int d = abs(i-r0) + abs(j-c0);
        m[index] = {i, j};
        v.push_back({index, d});
      }
    }
    sort(v.begin(), v.end(), [](vector<int>& a, vector<int>&b){
        return a[1] < b[1];
      });
    vector<vector<int>> ans;
    for(int i=0; i<v.size(); ++i){
      ans.push_back(m[v[i][0]]);
    }
    return ans;
  }
};

int main(){
  Solution s;
  auto ans = s.allCellsDistOrder(2,2,0,1);
  for(auto a : ans){
    cout << a[0] << " " << a[1] << endl;
  }
  return 0;
}
