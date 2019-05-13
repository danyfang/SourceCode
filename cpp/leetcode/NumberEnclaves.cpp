//Leetcode Problem No 1020. Number of Enclaves
//Solution written by Xuqiang Fang on 3 May, 2019

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
    int numEnclaves(vector<vector<int>>& A) {
      const int m = A.size();
      const int n = A[0].size();

      for(int i=0; i<m; ++i){
        for(int j=0; j<n; ++j){
          if(A[i][j] == 1 && (i == 0 || j == 0 || i==m-1 || j == n-1)){
            dfs(A, i, j, m, n);
          }
        }
      }
      int total = 0;
      for(int i=0; i<m; ++i){
        for(int j=0; j<n; ++j){
          if(A[i][j]){
            total++;
          }
        }
      }
      return total;
    }
private:
  void dfs(vector<vector<int>>& A, int i, int j, const int m, const int n){
    A[i][j] = 0;
    for(auto&d : dirs){
      int x = i+d[0];
      int y = j+d[1];
      if(x>=0 && x<m && y>=0 && y<n && A[x][y] == 1){
        dfs(A, x, y, m, n);
      }
    }
  }
  vector<vector<int>> dirs = {{0,1},{1,0},{0,-1},{-1,0}};
};

int main(){
  Solution s;
  vector<vector<int>> A({{0,1,1,0},{0,0,1,0},{0,0,1,0},{0,0,0,0}});
  cout << s.numEnclaves(A) << endl;
  A = {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
  cout << s.numEnclaves(A) << endl;
  return 0;
}
