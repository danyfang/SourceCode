//Leetcode Problem No 907 Sum of Subarray Minimums
//Solution written by Xuqiang Fang on 17 Sep, 2018

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
    //O(n^2 solution)
    int sumSubarrayMins(vector<int>& A) {
        const int n = A.size();
        const int mod = 1000000007;
        if(n == 0){
            return 0;
        }
        int ans = A[0];
        for(int i=1; i<n; ++i){
            int j = i;
            int m = A[j];
            while(j >= 0){
                m = min(m, A[j]);
                ans += m;
                j--;
            }
            ans %= mod;
        }
        return ans;
    }
};

int main(){
    Solution s;
    vector<int> A{3,1,2,4};
    cout << s.sumSubarrayMins(A) << endl;
    return 0;
}
