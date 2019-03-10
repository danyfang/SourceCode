//Leetcode Problem No 1005. Maximize Sum Of Array After K Negations
//Solution written by Xuqiang Fang on 19 March, 2019

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
  int largestSumAfterKNegations(vector<int>& A, int K) {
    vector<int> pos, neg;
    for(auto& a : A){
      if(a >= 0)
	pos.push_back(a);
      else
	neg.push_back(a);
    }
    const int n = neg.size();
    int ans = 0;
    if(K <= n){
      ans += accumulate(pos.begin(), pos.end(), 0);
      sort(neg.begin(), neg.end());
      for(int i=0; i<n; ++i){
	if(i < K)
	  ans -= neg[i];
	else
	  ans += neg[i];
      }
    }
    else{
      K -= n;
      for(auto& a : neg)
	pos.push_back(-a);
      sort(pos.begin(), pos.end(), std::greater<int>());
      ans += accumulate(pos.begin(), pos.end(), 0);
      if(K % 2 != 0)
	ans -= 2*pos[pos.size()-1];
    }
    return ans;
  }
};

int main(){
  Solution s;
  vector<int> nums{4,2,3};
  cout << s.largestSumAfterKNegations(nums, 1) << endl;
  nums = {3,-1,0,2};
  cout << s.largestSumAfterKNegations(nums, 3) << endl;
  nums = {2,-3,-1,5,-4};
  cout << s.largestSumAfterKNegations(nums, 2) << endl;
  return 0;
}
