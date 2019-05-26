//Leetcode Problem No 1042 Flower Planting With No Adjacent
//Solution written by Xuqiang Fang on 21 May, 2019

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
  vector<int> gardenNoAdj(int N, vector<vector<int>>& paths){
    vector<int> color(N, 0);
    vector<vector<int>> matrix(N);
    for(auto& p : paths){
      matrix[p[1]-1].push_back(p[0]-1);
      matrix[p[0]-1].push_back(p[1]-1);
    }
    for(int i=0; i<min(N, 3); ++i){
      color[i] = i+1;
    }
    for(int i=3; i<N; ++i){
      if(matrix[i].size() > 0){
        int encode[4] = {1,1,1,1};
        for(auto& p : matrix[i]){
          if(color[p] != 0){
            encode[color[p]-1] = 0;
          }
        }
        for(int x=0; x<4; ++x){
          if(encode[x] == 1){
            color[i] = x+1;
            break;
          }
        }
      }
      else{
        color[i] = 1;
      }
    }
    return color;
  }
};

int main(){
  Solution s;
  vector<vector<int>> paths{{1,2},{2,3},{3,1}};
  auto ans = s.gardenNoAdj(3, paths);
  for(auto a : ans){
    cout << a << " ";
  }
  cout << endl;
  paths = {{1,2},{3,4}};
  ans = s.gardenNoAdj(4, paths);
  for(auto a : ans){
    cout << a << " ";
  }
  cout << endl;
  paths = {{1,2},{2,3},{3,4},{4,1},{1,3},{2,4}};
  ans = s.gardenNoAdj(4, paths);
  for(auto a : ans){
    cout << a << " ";
  }
  cout << endl;    
  return 0;
}
