//Leetcode Problem No 354 Russian Doll ENvelopes
//Solution written by Xuqiang Fang on 19 June, 2018

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
    //first sort the envelopes and then use dp
    //using dp to find the longest increasing subsequence
    int maxEnvelopes(vector<pair<int, int>>& envelopes) {
        sort(envelopes.begin(), envelopes.end()); 
        const int n = envelopes.size();
        vector<int> dp(n, 1);
        int ans = 1;
        for(int i=1; i<n; ++i){
            for(int j=0; j<i; ++j){
                if(envelopes[i].second > envelopes[j].second && envelopes[i].first > envelopes[j].first){
                    dp[i] = max(dp[i], dp[j]+1);
                }
            }
            ans = max(ans, dp[i]);
        }
        return ans;
    }
};

int main(){
    Solution s;
    vector<pair<int, int>> envelopes{{5,4},{6,4},{6,7},{2,3}};
    cout << s.maxEnvelopes(envelopes) << endl;
    return 0;
}
