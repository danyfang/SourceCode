//Leetcode Problem No 1031. Maximum Sum of Two Non-Overlapping Subarrays
//Solution written by Xuqiang Fang on 13 May, 2019

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
    int maxSumTwoNoOverlap(vector<int>& A, int L, int M) {
        const int n = A.size();
        vector<int> sl(n-L+1, 0), sm(n-M+1, 0);
        int t = 0;
        for(int i=0; i<L; ++i){
            t += A[i];
        }
        sl[0] = t;
        for(int i=L; i<n; ++i){
            sl[i-L+1] = sl[i-L] - A[i-L] + A[i];
        }
        t = 0;
        for(int i=0; i<M; ++i){
            t += A[i];
        }
        sm[0] = t;
        for(int i=M; i<n; ++i){
            sm[i-M+1] = sm[i-M] - A[i-M] + A[i];
        }
        int ans = 0;
        for(int i=0; i<n-M+1; ++i){
            for(int j=0; j<i-L; ++j){
                ans = max(ans, sm[i]+sl[j]);
            }
            for(int j=i+M; j<n-L+1; ++j){
                ans = max(ans, sm[i]+sl[j]);
            }
        }
        return ans;
    }
};

int main(){
  Solution s;
  vector<int> A{0,6,5,2,2,5,1,9,4};
  cout << s.maxSumTwoNoOverlap(A, 1, 2) << endl;
  A = {3,8,1,3,2,1,8,9,0};
  cout << s.maxSumTwoNoOverlap(A, 3, 2) << endl;
  return 0;
}
