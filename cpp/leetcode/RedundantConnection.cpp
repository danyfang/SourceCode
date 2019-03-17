//Leetcode Problem No 684. Redundant Connection
//Solution written by Xuqiang Fang on 16 March, 2019

#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <unordered_map>
#include <unordered_set>
#include <stack>
#include <queue>

using namespace std;
class UnionFind{
public:
  int find(int i){
    auto p = parent[i];
    if(i == p){
      return i;
    }
    return parent[i] = find(p);
  } 

  void union_op(int i, int j){
    int p1 = find(i);
    int p2 = find(j);
    if(p1 != p2){
      parent[p1] = p2;
    }
  }
  int get(){
    return 0;
  }
  UnionFind(int n){
    parent = vector<int>(n, -1);
    for(int i=0; i<n; ++i){
      parent[i] = i;
    }
  }
private:
  vector<int> parent;
};

class Solution{
public:
  vector<int> findRedundantConnection(vector<vector<int>>& edges) {
    const int n = edges.size();
    UnionFind uf(n+1);
    vector<int> ans;
    for(auto& e : edges){
      if(uf.find(e[0]) == uf.find(e[1]))
	ans = e;
      uf.union_op(e[0], e[1]);
    }
    return ans;
  }
};

int main(){
  Solution s;
  vector<vector<int>> edges {{1,2},{1,3},{2,3}};
  edges = {{1,2},{2,3},{3,4},{1,4},{1,5}};
  auto ans = s.findRedundantConnection(edges);
  for(auto a : ans)
    cout << a << " ";
  cout << endl;
  return 0;
}
