//Leetcode Problem No 1034. Coloring A Border
//Solution written by Xuqiang Fang on 14 May, 2019

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
    vector<vector<int>> colorBorder(vector<vector<int>>& grid, int r0, int c0, int color) {
        if(grid[r0][c0] == color){
            return grid;
        }    
        const int m = grid.size();
        const int n = grid[0].size();
        int old = grid[r0][c0];
        dfs(grid, r0, c0, old, color, m, n);
        vector<vector<int>> ans;
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                if(grid[i][j] == -1){
                    if(i==0 || j==0 || i==m-1 || j==n-1 || inborder(grid, i, j, old)){
                        ans.push_back({i,j});
                    }
                }
            }
        }
        for(auto& a : ans){
            grid[a[0]][a[1]] = color;
        }
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                if(grid[i][j] == -1){
                    grid[i][j] = old;
                }
            }
        }
        return grid;
    }
    
private:
    vector<vector<int>> dirs{{0,1},{1,0},{0,-1},{-1,0}};
    void dfs(vector<vector<int>>& grid, int r0, int c0, int old, int color, int m, int n){
        grid[r0][c0] = -1;
        for(auto& d : dirs){
            int r = r0 + d[0];
            int c = c0 + d[1];
            if(r>=0&&r<m&&c>=0&&c<n&&grid[r][c]==old){
                dfs(grid, r, c, old, color, m, n);
            }
        }
    }
    bool inborder(vector<vector<int>>& grid, int i, int j, int old){
        for(auto& d : dirs){
            int r = i + d[0];
            int c = j + d[1];
            if(grid[r][c] != old && grid[r][c] != -1)
                return true;
        }
        return false;
    }
};

int main(){
  Solution s;
  vector<vector<int>> grid{{1,1,1},{1,1,1},{1,1,1}};
  auto ans = s.colorBorder(grid, 1, 1, 2);
  for(auto a : ans){
    for(auto b : a){
      cout << b << " ";
    }
    cout << endl;
  }
  return 0;
}
