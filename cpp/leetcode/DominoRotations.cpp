//Leetcode Problem No 1007. Minimum Domino Rotations For Equal Row
//Solution written by Xuqiang Fang on 18 March, 2019

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
  int minDominoRotations(vector<int>& A, vector<int>& B){
    const int n = A.size();
    int ans = n;
    for(int i=1; i<=6; ++i){
      auto t = helper(A, B, i);
      if(t != -1){
        ans = min(ans, t);
      }
      t = helper(B, A, i);
      if(t != -1){
        ans = min(ans, t);
      }
    }
    return ans == n ? -1 : ans;
  }
private:
  int helper(vector<int>& A, vector<int>& B, int x){
    const int n = A.size();
    int count = 0;
    for(int i=0; i<n; ++i){
      if(A[i] != x && B[i] != x){
          return -1;
      }
      else if(A[i] != x && B[i] == x){
        count++;
      }
    }
    return count;
  }
};

int main(){
  Solution s;
  vector<int> A{2,1,2,4,2,2}, B {5,2,6,2,3,2};
  cout << s.minDominoRotations(A, B) << endl;
  A = {3,5,1,2,3};
  B = {3,6,3,3,4};
  cout << s.minDominoRotations(A, B) << endl;  
  return 0;
}
