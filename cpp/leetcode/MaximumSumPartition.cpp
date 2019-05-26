//Leetcode Problem No 1043 Partition Array for Maximum Sum
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
  int maxSumAfterPartitioning(vector<int>& A, int K){
    const int n = A.size();
    vector<int> dp(n+1, 0);
    for(int i=1; i<=n; ++i){
      auto m = INT_MIN;      
      for(int k=1; k<=min(i, K); ++k){
        m = max(m, A[i-k]);
        dp[i] = max(dp[i], dp[i-k]+m*k);
      }
    }
    return dp[n];
  }
};

int main(){
  Solution s;
  vector<int> A{1,15,7,9,2,5,10};
  cout << s.maxSumAfterPartitioning(A, 3) << endl;
  return 0;
}
