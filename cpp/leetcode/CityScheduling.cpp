//Leetcode Problem No 1029 Two city Scheduling
//Solution written by Xuqiang Fang on 10 May, 2019

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
    int twoCitySchedCost(vector<vector<int>>& costs) {
      const int n = costs.size();
      int ans = 0;
      for(int i=0; i<n; ++i){
        ans += costs[i][0]; //suppose choose all A
      }
      sort(costs.begin(), costs.end(), [](vector<int>& a, vector<int>&b){
          int ad = a[1] - a[0];
          int bd = b[1] - b[0];
          return ad < bd;
      });
      //for(auto c : costs){
      //  cout << c[0] << " " << c[1] << " " << c[1] - c[0]<< endl;
      //}
      //cout << ans << endl;
      for(int i=0; i<n/2; ++i){
        ans += costs[i][1]-costs[i][0];
      }
      return ans;
    }
};

int main(){
  Solution s;
  vector<vector<int>> costs = {{259,770},{448,54},{926,667},{184,139},{840,118},{577,469}};
  cout << s.twoCitySchedCost(costs) << endl;
  costs = {{10,20},{30,200},{400,50},{30,20}};
  cout << s.twoCitySchedCost(costs) << endl;  
  return 0;
}
