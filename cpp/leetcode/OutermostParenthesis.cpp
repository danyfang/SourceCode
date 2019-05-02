//Leetcode Problem No 1021. Remove Outermost Parentheses
//Solution written by Xuqiang Fang on 2 may, 2019

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
  string removeOuterParentheses(string S) {
    vector<int> index;
    int count = 0;
    const int n = S.size();
    for(int i=0; i<n; ++i){
      if(count == 0){
        index.push_back(i);
      }
      if(S[i] == '('){
        count++;
      }
      else{
        count--;
      }
    }
    string ans = "";
    int i = 0;
    for(; i<index.size()-1; i++){
      for(int j=index[i]+1; j<index[i+1]-1; ++j){
        ans.push_back(S[j]);
      }
    }
    for(int j=index[i]+1; j<n-1; ++j){
      ans.push_back(S[j]);
    }
    return ans;
  }
};

int main(){
  Solution s;
  string S = "(()())(())";
  cout << s.removeOuterParentheses(S) << endl;
  S = "(()())(())(()(()))";
  cout << s.removeOuterParentheses(S) << endl;
  S = "()()";
  cout << s.removeOuterParentheses(S) << endl;
  S = "()()()()(())";
  cout << s.removeOuterParentheses(S) << endl;  
  return 0;
}
