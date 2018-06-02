//Leetcode Problem No 823 Binary Trees With Factors
//Solution written by Xuqiang Fang on 1 June, 2018

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
    int numFactoredBinaryTrees(vector<int>& A) {
        long mod = pow(10,9) + 7;
        sort(A.begin(), A.end());
        /*
        for(auto i : A){
            cout << i << endl;
        }
        */
        int n = A.size();
        vector<long> dp(n,1);//dp[i] is the number of trees with A[i] as root
        unordered_map<int, int> visited;
        visited[A[0]] = 0;
        int ans = dp[0];
        for(int i=1; i<n; ++i){
            for(int j=0; j<i; ++j){
                if(A[i]%A[j] == 0 && visited.count(A[i]/A[j])){
                    dp[i] += dp[j] * dp[visited[A[i]/A[j]]] ;
                    dp[i] %= mod;
                }
            } 
            visited[A[i]] = i;
            ans += dp[i];
            ans %= mod;
        }
        /*
        for(auto i : dp){
            cout << i << endl;
        }
        */
        return ans;
    }
};

int main(){
    Solution s;
    vector<int> nums{2,4};
    vector<int> num{2,3,4,5,8,10,12,16,20,24,28,30,32,36,40,50};
    cout << s.numFactoredBinaryTrees(nums) << endl;
    cout << s.numFactoredBinaryTrees(num) << endl;
    return 0;
}
