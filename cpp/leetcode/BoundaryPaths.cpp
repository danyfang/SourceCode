//Leetcode Problem No 576 Out of Boundary Paths
//Solution written by Xuqiang Fang on 16 June, 2018

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
    int findPaths(int m, int n, int N, int i, int j) {
        const int mod = 1000000007;
        vector<vector<vector<int>>> dp(N+1, vector<vector<int>>(m, vector<int>(n, 0)));
        const int dir[] = {1,0,-1,0,1};
        for(int s=1; s<=N; ++s){
            for(int x=0; x<m; ++x){
                for(int y=0; y<n; ++y){
                    for(int d=0; d<4; ++d){
                        int tx = dir[d] + x;
                        int ty = dir[d+1] + y;
                        if(tx < 0 || tx >= m || ty < 0 || ty >= n){
                            dp[s][x][y] += 1;
                        }
                        else{
                            dp[s][x][y] += dp[s-1][tx][ty];
                            dp[s][x][y] %= mod;
                        }
                    }
                }
            }
        }
        return dp[N][i][j];
    }
};

int main(){
    Solution s;
    cout << s.findPaths(2,2,2,0,0) << endl;
    cout << s.findPaths(1,3,3,0,1) << endl;
    return 0;
}
