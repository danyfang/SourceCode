//Leetcode Problem No 1003. Check If Word Is Valid After Substitutions
//Solution written by Xuqiang Fang on 12 March, 2019
/*
A classic problem with classic stack solution!!!
*/
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
  bool isValid(string S){
    vector<int> s;
    for(auto& c : S){
      if(c == 'c'){
	const int n = s.size();
	if(n < 2 || s[n-1] != 'b' || s[n-2] != 'a')
	  return false;
	s.pop_back();
	s.pop_back();
      }
      else{
	s.push_back(c);
      }
    }
    return s.empty();
  }
};

int main(){
  Solution s;
  string S = "aabbcc";
  cout << s.isValid(S) << endl;
  S = "abcabcababcc";
  cout << s.isValid(S) << endl;
  return 0;
}
