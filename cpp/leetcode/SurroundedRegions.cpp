//Leetcode Problem No 130 Surrounded Regions
//Solution written by Xuqiang Fang on 23 Oct, 2018

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
    void solve(vector<vector<char>>& board) {
        if(board.size() == 0 || board[0].size() == 0) return;
        b = board;
        const int m = board.size();
        const int n = board[0].size();
        for(int i=0; i<m; ++i){
            if(b[i][0] == 'O' && s.count(to_string(i)+","+to_string(0)) == 0){
                dfs(i, 0, m, n);
            }
            if(b[i][n-1] == 'O' && s.count(to_string(i)+","+to_string(n-1)) == 0){
                dfs(i, n-1, m, n);
            }
        }
        for(int i=0; i<n; ++i){
            if(b[0][i] == 'O' && s.count(to_string(0)+","+to_string(i)) == 0){
                dfs(0, i, m, n);
            }
            if(b[m-1][i] == 'O' && s.count(to_string(m-1)+","+to_string(i)) == 0){
                dfs(m-1, i, m, n);
            }
        }
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                if(board[i][j] == 'O' && s.count(to_string(i)+","+to_string(j)) == 0){
                    board[i][j] = 'X';
                }
            }
        }
    }
private:
    unordered_set<string> s;
    vector<vector<char>> b;
    vector<pair<int, int>> dir{{1,0},{-1,0},{0,1},{0,-1}};
    void dfs(int x, int y, int m, int n){
        if(x<0 || x>= m || y < 0 || y >= n || b[x][y] != 'O' ||s.count(to_string(x)+","+to_string(y)) != 0) return;
        if(b[x][y] == 'O') s.insert(to_string(x)+","+to_string(y));
        for(auto d : dir){
            dfs(d.first+x, d.second+y, m, n);
        }
    }
};
int main(){
    Solution s;
    vector<vector<char>> b{{'X','X','X','X'},{'X','X','O','X'},{'X','O','X','X'},{'X','X','O','X'}};
    for(auto t : b){
        for(auto x : t){
            cout << x << "\t";
        }
        cout << endl;
    }
    s.solve(b);
    for(auto t : b){
        for(auto x : t){
            cout << x << "\t";
        }
        cout << endl;
    }
    return 0;
}
