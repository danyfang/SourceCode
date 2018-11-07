//Leetcode Problem No 934 Shortest Bridge
//Solution written by Xuqiang Fang on 7 November 2018

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
    int shortestBridge(vector<vector<int>>& A) {
        const int m = A.size();
        const int n = A[0].size();
        int ans = INT_MAX;
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                if(A[i][j] == 1){
                    string t = to_string(i)+","+to_string(j);
                    if(s.empty()){
                        helper(A, m, n, i, j);
                    }
                    else if(s.find(t) == s.end()){
                    }
                }
            }
        }
        return ans;
    }
private:
    void helper(vector<vector<int>>& A, const int m, const int n, int i, int j){
        string t = to_string(i)+","+to_string(j);
        s.insert(t);
        for(auto &d : dir){
            i +=d.first;
            j += d.second;
            t = to_string(i)+","+to_string(j);
            if(i >= 0&&i < m&&j >= 0&&j < n&&s.find(t) == s.end()&&A[i][j] == 1)
                helper(A, m, n, i, j);
        }
    }
    int bfs(vector<vector<int>>& A, const int m, const int n, int i, int j, int curr, unordered_set<string> visited){
        int ans = INT_MAX;
        string t = to_string(i)+","+to_string(j);
        if(visited.count(t) != 0){
            return ans;
        }
        visited.insert(t);
        for(auto& d : dir){
            i += d.first;
            j += d.second;
            if(i >= 0&&i < m&&j >= 0&&j < n){
                t = to_string(i) + "," + to_string(j);
                if(A[i][j] == 1 && s.find(t) != s.end()){
                    ans = min(ans, curr);
                }    
                else{
                    ans = min(ans, bfs(A, m, n, i, j, curr+1, visited)); 
                }
            }
        }
        return ans;
    }
    unordered_set<string> s;
    unordered_set<string> visited;
    vector<pair<int, int>> dir = {{1,0},{-1, 0},{0, 1},{0,-1}};
};
int main(){
    Solution s;
    vector<vector<int>> A = {{1,1,1,1,1},{1,0,0,0,1},{1,0,1,0,1},{1,0,0,0,1},{1,1,1,1,1}};
    cout << s.shortestBridge(A) << endl;
    A = {{0,1,0},{0,0,0},{0,0,1}};
    cout << s.shortestBridge(A) << endl;
    return 0;
}
