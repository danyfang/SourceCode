//Leetcode Problem No. 329 Longest Increasing Path in a Matrix
//Solution written by Xuqiang Fang on 23 May, 2018

#include <iostream>
#include <vector>

using namespace std;

class Solution{
public:
    int longestIncreasingPath(vector<vector<int>>& matrix) {
        if(matrix.size() == 0 || matrix[0].size() == 0){
            return 0;
        } 
        int m = matrix.size();
        int n = matrix[0].size();
        vector<vector<int>> dp(m, vector<int>(n, 0));
        int ans = 0;
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                dp[i][j] = dfs(matrix, m, n, i, j, dp);
                ans = max(ans, dp[i][j]);
            }
        }
        return ans;
    }
private:
    int dfs(vector<vector<int>> &matrix, int m, int n, int i, int j, vector<vector<int>> &dp){
        if(i<0 || i>=m || j<0 || j>=n || matrix[i][j] == INT_MIN){
            return 0;
        } 
        else if(dp[i][j] > 0){
            return dp[i][j];
        }
        int s = 1;
        int c = matrix[i][j];
        matrix[i][j] = INT_MIN;
        int u = 0, d = 0, l = 0, r = 0;
        if(i-1 >= 0 && matrix[i-1][j] > c){
            u = dfs(matrix, m, n, i-1, j, dp);
        }
        if(i+1 < m && matrix[i+1][j] > c){
            d = dfs(matrix, m, n, i+1, j, dp);
        }
        if(j-1 >= 0 && matrix[i][j-1] > c){
            l = dfs(matrix, m, n, i, j-1, dp);
        }
        if(j+1 < n && matrix[i][j+1] > c){
            r = dfs(matrix, m, n, i, j+1, dp);
        }
        matrix[i][j] = c;
        s += max(max(u,d), max(l,r));
        dp[i][j] = s;
        return s;
    }
};

int main(){
    Solution s;
    vector<vector<int>> matrix{{7,6,1,1},{2,7,6,0},{1,3,5,1},{6,6,3,2}};
    vector<vector<int>> mat = {{9,9,4},{6,6,8},{2,1,1}};
    cout << s.longestIncreasingPath(matrix) << endl;
    cout << s.longestIncreasingPath(mat) << endl;
    return 0;
}
