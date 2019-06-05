
//Leetcode Problem No 
//Solution written by Xuqiang Fang on 

#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <unordered_map>
#include <unordered_set>
#include <stack>
#include <queue>

using namespace std;

class Solution {
  
public:
  class Compare{
  public:
    bool operator()(vector<int>& b, vector<int>& a){
      if(a[0] == b[0])
        return a[1] < b[1];
      return a[0] < b[0];
    }
  };  
  /**
   * @param p: the position of the i-th stone
   * @param d: how far the stones can be stone
   * @return: the distance from the start point to the farthest stone.
   */
  int getDistance(vector<int> &p, vector<int> &d) {
    // Write your code here.
    const int n = p.size();
    priority_queue<vector<int>, vector<vector<int>>, Compare> q;
    for(int i=0; i<n; ++i){
      q.push({p[i], d[i]});
    }
    int i = 1;
    int ans = 0;
    while(q.size() > 0){
      auto head = q.top();
      ans = max(ans, head[0]);
      q.pop();            
      if(i % 2 != 0){
        head[0] += head[1];
        q.push(head);
      }

      ++i;
    }
    return ans;
  }
};


int main(){
  Solution s;
  vector<int> p{1,2}, d{5,4};
  cout << s.getDistance(p, d) << endl;
  p = {1,6};
  d = {5,6};
  cout << s.getDistance(p, d) << endl;
string ans;
ans.push_back(8);
  return 0;
}
