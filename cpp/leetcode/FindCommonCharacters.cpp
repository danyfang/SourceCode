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
      for(const auto& e : ans){
	if(tmp.count(e.first) != 0){
	  ans[e.first] = min(ans[e.first], tmp[e.first]);
	}
	else{
	  ans.erase(e.first);
	}
      }
    }
    vector<string> ret;
    for(const auto& e : ans){
      for(int i=0; i<ans[e.first]; ++i){
	string s;
	s.push_back(ans[e.first]);
	ret.push_back(s);
      }
    }
    return ret;
  }
private:
  int[] helper(string& a){
    unordered_map<char, int> ans;
    for(auto& c : a){
      if(ans.find(c) == ans.end()){
	ans[c] = 1;
      }
      else{
	ans[c] += 1;
      }
    }
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
