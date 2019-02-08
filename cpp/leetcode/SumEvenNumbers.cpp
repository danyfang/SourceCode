//Leetcode Problem No 985 Sum of Even Numbers After Queries
//Solution written by Xuqiang Fang on 5 Feb, 2019

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
    vector<int> sumEvenAfterQueries(vector<int>& A, vector<vector<int>>& queries) {
        int curr = 0;
        for(auto& a : A){
            if(a % 2 == 0){
                curr += a;
            }
        }
        vector<int> ans;
        for(auto& q : queries){
            int val = q[0];
            int index = q[1];
            if(A[index] % 2 == 0){
                if((A[index]+val) % 2 == 0){
                    curr += val;
                }
                else{
                    curr -= A[index];
                }
                ans.push_back(curr);
            }
            else if((A[index]+val) % 2 == 0){
                curr += val;
                curr += A[index];
                ans.push_back(curr);
            }
            else{
                ans.push_back(curr);
            }
            A[index] += val;
        }
        return ans;
    }
};
int main(){
  Solution s;
  vector<int> A{1,2,3,4};
  vector<vector<int>> queries{{1,0},{-3,1},{-4,0},{2,3}};
  auto ans = s.sumEvenAfterQueries(A, queries);
  for(auto a : ans)
    cout << a << "  ";
  cout << endl;
  return 0;
}
