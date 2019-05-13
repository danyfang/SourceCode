//Leetcode Problem No 1027. Longest Arithmetic Sequence
//Solution written by Xuqiang Fang on 12 May, 2019

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
    int longestArithSeqLength(vector<int>& A) {
        const int n = A.size();
        vector<unordered_map<int,int>> m(n); // difference and longest seq till present
        m[0][0] = 1;
        int ans = 1;
        for(int i=1; i<n; ++i){
            for(int j=0; j<i; ++j){
                int d = A[i] - A[j];
                if(m[j].count(d) == 0){
                    m[i][d] = 2;
                }
                else{
                    m[i][d] = 1 + m[j][d];
                }
                ans = max(ans, m[i][d]);
            } 
        }
        return ans;    
    }
};

int main(){
  Solution s;
  vector<int> A = {3,6,9,12};
  cout << s.longestArithSeqLength(A) << endl;
  return 0;
}
