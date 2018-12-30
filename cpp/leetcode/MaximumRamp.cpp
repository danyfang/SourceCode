//Leetcode Problem No 962. Maximum Width Ramp
//Solution written by Xuqiang Fang on 30 Dec, 2018

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
  int maxWidthRamp(vector<int>& A){
    int ans = 0;
    const int n = A.size();
    int i= 0, j = n-1;
    while(i < n-ans ){
      if(A[i] <= A[j]){
	ans = max(ans, j-i);
	i++;
	j = n-1;
      }
      else{
	j--;
      }
    }
    return ans;
  }
};

int main(){
    Solution s;
    vector<int> A{6,0,8,2,1,5};
    cout << s.maxWidthRamp(A) << endl;
    A = {9,8,1,0,1,9,4,0,4,1};
    cout << s.maxWidthRamp(A) << endl;
    return 0;
}
