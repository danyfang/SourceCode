//Leetcode Problem No 994 Rotting Oranges
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
  int orangesRotting(vector<vector<int>>& grid) {
    int fresh = 0, rot = 0;
    const int m = grid.size();
    const int n = grid[0].size();
    queue<pair<int, int>> q;
    for(int i=0; i<m; ++i){
      for(int j=0; j<n; ++j){
	if(grid[i][j] == 1){
	  fresh++;
	}
	else if(grid[i][j] == 2){
	  rot++;
	  q.push({i, j});
	}
      }
    }
    int ans = 0;
    int original_fresh = fresh;
    while(!q.empty()){
      int size = q.size();
      bool hasRot = false;
      for(int i=0; i<size; ++i){
	auto p = q.front();
	q.pop();
	for(auto& d : direction){
	  int x = p.first + d.first;
	  int y = p.second + d.second;
	  if(x>=0 && x<m && y>=0 && y<n && grid[x][y] == 1){
	    q.push({x, y});
	    grid[x][y] = 2;
	    hasRot = true;
	    fresh--;
	  }
	}
      }
      if(hasRot)
	ans++;
    }
    if(rot == 0){
      if(original_fresh == 0)
	return 0;
      return -1;
    }
    if(fresh == 0)
      return ans;
    return -1;
  }
private:
  vector<pair<int, int>> direction{{-1,0}, {1,0}, {0,-1}, {0,1}};
};

int main(){
  Solution s;
  vector<vector<int>> grid {{2,1,1},{1,1,0},{0,1,1}};
  cout << s.orangesRotting(grid) << endl;
  grid = {{2,1,1},{0,1,1},{1,0,1}};
  cout << s.orangesRotting(grid) << endl;
  grid = {{0,2}};
  cout << s.orangesRotting(grid) << endl;
  grid = {{1}};
  cout << s.orangesRotting(grid) << endl;
  return 0;
}
