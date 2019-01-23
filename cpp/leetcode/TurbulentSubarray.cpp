//Leetcode Problem No 978 Longest Turbulent Subarray
//Solution written by Xuqiang Fang on 23 Jan, 2019

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
    int maxTurbulenceSize(vector<int>& A) {
        const int n = A.size();
        vector<int> B(n, 1);
        for(int i=1; i<n; ++i){
            if(A[i] == A[i-1]){
                continue;
            }
            else if(A[i] > A[i-1]){
                if(i-2 >=0 && A[i-1] < A[i-2]){
                    B[i] = B[i-1] + 1;
                }
                else{
                    B[i] = 2;
                }
            }
            else{
                if(i-2 >= 0 && A[i-1] > A[i-2]){
                    B[i] = B[i-1] + 1;
                }
                else{
                    B[i] = 2;
                }
            }
        }
        int ans = 1;
        for(auto b : B){   
            //cout << b <<  "  ";
            ans = max(ans, b);
        }
        //cout << endl;
        return ans;
    }
};
int main(){
    Solution s;
    vector<int> A{9,4,2,10,7,8,8,1,9};
    cout << s.maxTurbulenceSize(A) << endl;
    return 0;
}
