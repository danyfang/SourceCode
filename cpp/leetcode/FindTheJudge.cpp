//Leetcode Problem No 997 Find the Town Judge
//Solution written by Xuqiang Fang on 10 March, 2019

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
  int findJudge(int N, vector<vector<int>>& trust){
    vector<unordered_set<int>> m(N), n(N);
    for(auto& t : trust){
      m[t[1]-1].insert(t[0]);
      n[t[0]-1].insert(t[1]);
    }
    for(int i=0; i<N; ++i){
      if(m[i].size() == N-1 && m[i].count(i+1) == 0 && n[i].size() == 0)
	return i+1;
    }
    return -1;
  }
};

int main(){
  Solution s;
  vector<vector<int>> trust = {{1,3},{1,4},{2,3},{2,4},{4,3}};
  cout << s.findJudge(4, trust) << endl;
  trust = {{1,2},{2,3}};
  cout << s.findJudge(3, trust) << endl;
  trust = {{1,3},{2,3}};
  cout << s.findJudge(3, trust) << endl;  
  return 0;
}
