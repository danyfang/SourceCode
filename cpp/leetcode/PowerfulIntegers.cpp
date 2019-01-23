//Leetcode Problem No 970 Powerful Integers
//Solution written by Xuqiang Fang on 18 Jan, 2019

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
  vector<int> powerfulIntegers(int x, int y, int bound) {
    int m = x != 1 ? (int)(log(bound)/log(x))+1 : 1, n = y != 1 ?(int)(log(bound)/log(y))+1 : 1;
    vector<int> mx(m,1), ny(n,1);
    for(int i=1; i<m; ++i){
      mx[i] = x * mx[i-1];
    }
    for(int i=1; i<n; ++i){
      ny[i] = y * ny[i-1];
    }
    unordered_set<int> s;
    for(int i=0; i<m; ++i){
      for(int j=0; j<n; ++j){
        auto t = mx[i] + ny[j];
        if(t <= bound){
          s.insert(t);
        }
      }
    }
    vector<int> ans;
    ans.insert(ans.end(), s.begin(), s.end());
    return ans;
  }
};

int main(){
    Solution s;
    auto ans = s.powerfulIntegers(2, 3, 10);
    for(auto a : ans){
      cout << a << " " << endl;
    }
    ans = s.powerfulIntegers(3, 5, 15);
    for(auto a : ans){
      cout << a << " " << endl;
    }    
    return 0;
}
