//Leetcode Problem No 518 Coin Change 2
//Solution written by Xuqiang Fang on 17 June, 2018

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
    int change(int amount, vector<int>& coins) {
    /*
    * dp[i][j] the number of combinations to make up amount j using the first i types of coins
    * dp[i][j] = :
    *           case 1: not using the ith coin, dp[i-1][j]
    *           case 2: using the ith coin, dp[i][j-coins[i]]
    * Initialization:
    *           dp[i][0] = 1
    */
        vector<int> dp(amount+1, 0);
        dp[0] = 1;
        for(int c : coins){
            for(int i=c; i<=amount; ++i){
                dp[i] += dp[i-c];
            }
        }
        return dp[amount];
    }
};

int main(){
    Solution s;
    vector<int> coins{1,2,5};
    cout << s.change(5, coins) << endl;
    return 0;
}
