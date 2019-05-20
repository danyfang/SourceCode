//Leetcode Problem No 983 Minimum Cost For Tickets
//Solution written by Xuqiang Fang on 20 May, 2019

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
  int mincostTickets(vector<int>& days, vector<int>& costs){
    vector<int> d(366, 0), e(366, 0);
    for(auto& da : days){
      d[da] = 1;
    }
    for(int i=1; i<=365; ++i){
      e[i] = e[i-1] + d[i]*costs[0];
      if(i>=7){
        e[i] = min(e[i-7]+costs[1], e[i]);
      }
      if(i>=30){
        e[i] = min(e[i], e[i-30]+costs[2]);
      }
    }
    return e[365];
  }
};

int main(){
  Solution s;
  vector<int> days{1,4,6,7,8,20}, costs{2,7,15};
  cout << s.mincostTickets(days, costs) << endl;
  days = {1,2,3,4,5,6,7,8,9,10,30,31};
  costs = {2,7,15};
  cout << s.mincostTickets(days, costs) << endl;
  return 0;
}
