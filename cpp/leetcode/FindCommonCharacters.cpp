//Leetcode Problem No 1002 Find Common Characters
//Solution written by Xuqiang Fang on 5 Mar, 2019

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
  vector<string> commonChars(vector<string>& A){
    const int n = A.size();
    auto ans = helper(A[0]);
    for(int i=1; i<n; ++i){
      auto tmp = helper(A[i]);
      for(int j=0; j<26; ++j){
	ans[j] = min(ans[j], tmp[j]);
      }
    }
    vector<string> ret;
    for(int i=0; i<26; ++i){
      while(ans[i] > 0){
	string s;
	char c = (char)('a'+i);
	s.push_back(c);
	ret.push_back(s);
	ans[i]--;
      }
    }
    return ret;
  }
private:
  vector<int> helper(string& a){
    vector<int> ans(26, 0);
    for(auto& c : a)
      ans[c-'a']++;
    return ans;
  }
};

int main(){
  Solution s;
  vector<string> A {"bella", "label", "roller"};
  auto ans = s.commonChars(A);
  for(auto& a : ans){
    cout << a << "  ";
  }
  cout << endl;
  A = {"cool", "lock", "cook"};
  ans = s.commonChars(A);
  for(auto& a : ans){
    cout << a << "  ";
  }
  cout << endl;
  return 0;
}
