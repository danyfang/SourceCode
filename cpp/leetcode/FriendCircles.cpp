//Leetcode Problem No 547 Friend Circles
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
      count--;
    }
  }
  int get(){
    return count;
  }
  UnionFind(vector<vector<int>>& M){
    const int n = M.size();
    count = n;
    parent = vector<int>(n, -1);
    for(int i=0; i<n; ++i){
      parent[i] = i;
    }
  }
private:
  vector<int> parent;
  int count;
};

class Solution{
public:
  int findCircleNum(vector<vector<int>>& M) {
    const int n = M.size();
    UnionFind uf(M);
    for(int i=0; i<n; ++i){
      for(int j=0; j<n; ++j){
	if(M[i][j] == 1){
	  uf.union_op(i, j);
	}
      }
    }
    return uf.get();
  }
};

int main(){
  Solution s;
  vector<vector<int>> M{{1,1,0},{1,1,0},{0,0,1}};
  cout << s.findCircleNum(M) << endl;
  M = {{1,1,0},{1,1,1},{0,1,1}};
  cout << s.findCircleNum(M) << endl;
  return 0;
}
