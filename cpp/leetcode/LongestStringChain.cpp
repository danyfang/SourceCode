//Leetcode Problem No 1048. Longest String Chain
//Solution written by Xuqiang Fang on 18 May, 2019

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
  int longestStrChain(vector<string>& words) {
    sort(words.begin(), words.end(), [](string& a , string& b){
        return a.size() < b.size();
      });
    const int n = words.size();
    ans = 0;
    vector<vector<int>> graph(n, vector<int>(n, 0));
    for(int i=0; i<n; ++i){
      for(int j=i+1; j<n; ++j){
        if(ischain(words[i], words[j])){
          graph[i][j] = 1;
        }
      }
    }
    for(int i=0; i<n; ++i){
      for(int j=0; j<n; ++j){
        cout << graph[i][j] << " ";
      }
      cout << endl;
    }
    for(int i=0; i<n; ++i){
      dfs(graph, n, i, 1);
    }
    return ans;
  }
private:
    int ans;
    void dfs(vector<vector<int>>& graph, const int n, int i, int level){
      ans = max(ans, level);
      for(int j=i+1; j<n; ++j){
        if(graph[i][j] == 1){
          dfs(graph, n, j, level+1);
        }
      }
    }
    bool ischain(string& a, string& b){
      if(b.size()-a.size() != 1 ){
        return false;
      }
      int num[26] = {0};
      for(auto& x : a){
        num[x-'a']++;
      }
      for(auto& x : b){
        num[x-'a']--;
      }
      int count = 0;
      for(auto i : num){
        if(i == 0){
          count++;
        }
      }
      return count == 25;
    }
};

int main(){
  Solution s;
  vector<string> words{"a","b","ba","bca","bda","bdca"};
  cout << s.longestStrChain(words) << endl;
  return 0;
}
