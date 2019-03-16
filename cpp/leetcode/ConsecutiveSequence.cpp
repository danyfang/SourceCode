//Leetcode Problem No 128. Longest Consecutive Sequence
//Solution written by Xuqiang Fang on 13 March, 2019

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
  int longestConsecutive(vector<int>& nums){
    unordered_map<int, int> m;
    int ans = 0;
    for(auto& n : nums){
      if(m.count(n))
	continue;
      else if(m.count(n-1) && m.count(n+1)){
	auto l = m[n-1];
	auto r = m[n+1];
	m[n] = m[n-l] = m[n+r] = l+r+1;
      }
      else if(m.count(n-1)){
	auto l = m[n-1];
	m[n] = m[n-l] = l+1;
      }
      else if(m.count(n+1)){
	auto r = m[n+1];
	m[n] = m[n+r] = r+1;
      }
      else
	m[n] = 1;
      ans = max(ans, m[n]);
    }
    return ans;
  }
};

int main(){
  Solution s;
  vector<int> nums{100, 4, 200, 1, 3, 2};
  cout << s.longestConsecutive(nums) << endl;
  nums = {0,3,7,2,5,8,4,6,0,1};
  cout << s.longestConsecutive(nums) << endl;  
  return 0;
}
