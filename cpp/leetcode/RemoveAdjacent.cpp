//Leetcode Problem No 1047 Remove All Adjacent Duplicate in String
//Solution written by Xuqiang Fang on 20 May, 2019

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
  string removeDuplicates(string s){
    stack<char> st;
    for(int i=0; i<s.size(); ++i){
      if(st.size() > 0 && s[i] == st.top()){
        st.pop();
      }
      else{
        st.push(s[i]);
      }
    }
    string ans;
    while(st.size() > 0){
      ans.push_back(st.top());
      st.pop();
    }
    reverse(ans.begin(), ans.end());
    return ans;    
  }
};

int main(){
  Solution s;
  string input{"abbaca"};
  cout << s.removeDuplicates(input) << endl;
  return 0;
}
