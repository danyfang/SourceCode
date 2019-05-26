//Leetcode Problem No 1053. Previous Permutation With One Swap
//Solution written by Xuqiang Fang on 26 May, 2019

#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <unordered_map>
#include <unordered_set>
#include <stack>
#include <queue>

using namespace std;
class Solution {
public:
    vector<int> prevPermOpt1(vector<int>& A) {
        const int n = A.size();
        vector<vector<int>> m(n);
        int ma = -1;
        for(int i=n-1; i>=1; --i){
            for(int j=i-1; j>=0; --j){
                if(A[j] > A[i]){
                    m[j].push_back(i);
                    ma = max(j, ma);
                    break;
                }
            }
        }
        if(ma != -1){
          int x = A[m[ma][0]];
          A[m[ma][0]] = A[ma];
          A[ma] = x;
        }
        return A;
    }
};

void print(vector<int>& nums){
  for(auto n : nums){
    cout << n << " ";
  }
  cout << endl;
}


int main(){
  Solution s;
  vector<int> A{1,9,4,6,7};
  vector<int> ans = s.prevPermOpt1(A);
  print(ans);
  return 0;
}
