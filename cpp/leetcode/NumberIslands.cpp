//Leetcode Problem No 200. Number of Islands
//Solution written by Xuqiang Fang on 13 March, 2019

#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <unordered_map>
#include <unordered_set>
#include <stack>
#include <queue>

using namespace std;
/*
A untility union find class
*/
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
  UnionFind(int m, int n, vector<vector<char>>& grid){
    parent = vector<int>(m*n, -1);
    count = 0;
    for(int i=0; i<m; ++i){
      for(int j=0; j<n; ++j){
	if(grid[i][j] == '1'){
	  parent[i*n+j] = i*n+j;
	  count++;
	}
      }
    }
  }
private:
  vector<int> parent;
  int count;
};


class Solution{
public:
  int numIslands(vector<vector<char>>& grid){
    const int m = grid.size();
    if(m == 0)
      return 0;
    const int n = grid[0].size();
    UnionFind uf(m, n, grid);
    for(int i=0; i<m; ++i){
      for(int j=0; j<n; ++j){
	if(grid[i][j] == '1'){
	  for(auto& d : directions){
	    int x = d.first + i;
	    int y = d.second + j;
	    if(x>=0 && x<m && y>=0 && y<n && grid[x][y] == '1'){
	      uf.union_op(i*n+j, x*n+y);
	    }
	  }
	}
      }
    }
    return uf.get();
  }
private:
  vector<pair<int, int>> directions{{-1,0},{0,-1}};
};
class SolutionDFS{
public:
  int numIslands(vector<vector<char>>& grid) {
    const int m = grid.size();
    if(m == 0)
      return 0;
    const int n = grid[0].size();
    int ans = 0;
    for(int i=0; i<m; ++i){
      for(int j=0; j<n; ++j){
	if(grid[i][j] == '1'){
	  ans++;
	  dfs(grid, i, j, m, n);
	}
      }
    }
    return ans;
  }
private:
  void dfs(vector<vector<char>>& grid, int i, int j, int m, int n){
    if(i<0 || i>=m || j<0 || j>=n || grid[i][j] == '0')
      return;
    grid[i][j] = '0';
    dfs(grid, i-1, j, m, n);
    dfs(grid, i, j-1, m, n);
    dfs(grid, i+1, j, m, n);
    dfs(grid, i, j+1, m, n);
  }
};


int main(){
  Solution s;
  string island("11000110000010000011");
  vector<vector<char>> grid;
  for(int i=0; i<4;++i){
    vector<char> tmp;
    for(int j=0; j<5; ++j){
      tmp.push_back(island[i*5+j]);
    }
    grid.push_back(tmp);
  }
  cout << s.numIslands(grid) << endl;
  SolutionDFS c;
  grid.clear();
  for(int i=0; i<4;++i){
    vector<char> tmp;
    for(int j=0; j<5; ++j){
      tmp.push_back(island[i*5+j]);
    }
    grid.push_back(tmp);
  }
  cout << c.numIslands(grid) << endl;
  return 0;
}
