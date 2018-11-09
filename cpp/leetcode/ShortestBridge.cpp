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
class Solution{
public:
    int shortestBridge(vector<vector<int>>& A) {
        first.clear();
        second.clear();
        step = -1;
        found = false;
        bool flag = false;
        const int n = A.size(); 
        for(int i=0; i<n; ++i){
            for(int j=0; j<n; ++j){
                if(A[i][j] == 1 && !flag){
                    string t = to_string(i) + "," + to_string(j);
                    if(first.empty()){
                        dfs(A, n, i, j, first);
                    }
                    else if(first.count(t) == 0){
                        dfs(A, n, i, j, second);
                        flag = true;
                        break;
                    }
                }
            }
            if(flag){
                break;
            }
        }
        while(!found){
            expand(n);
            step++;
            //cout << "second.size() = " << second.size() << endl;
            //cout << "first.size() = " << first.size() << endl;
        }
        return step;
    }
private:
    void dfs(vector<vector<int>>& A, int n, int i, int j, unordered_set<string>& f){
        string t = to_string(i)+","+to_string(j);
        f.insert(t);
        for(auto& d : dir){
            int x = i + d.first;
            int y = j + d.second;
            t = to_string(x) + "," + to_string(y);
            if(x>=0 && x<n && y>=0 && y<n&&A[x][y] == 1 && f.count(t) == 0){
                dfs(A, n, x, y, f);
            }
        }
    }
    void expand(int n){
        unordered_set<string> tmp = second;
        for(auto& s : second){
            int index = s.find(",");
            int i = stoi(s.substr(0, index));
            int j = stoi(s.substr(index+1, s.length()-index));
            for(auto& d : dir){
                int x = i + d.first;
                int y = j + d.second;
                string t = to_string(x) + "," + to_string(y);
                if(first.count(t) != 0){
                    found = true;
                    return;
                }
                if(x>=0 && x<n && y>=0 && y<n){
                    tmp.insert(t);
                }
            }
        }
        second = tmp;
    }
    int step;
    bool found;
    unordered_set<string> first; 
    unordered_set<string> second; 
    vector<pair<int, int>> dir = {{1,0},{-1, 0},{0, 1},{0,-1}};
};

int main(){
    Solution s;
    vector<vector<int>> A = {{1,1,1,1,1},{1,0,0,0,1},{1,0,1,0,1},{1,0,0,0,1},{1,1,1,1,1}};
    cout << s.shortestBridge(A) << endl;
    A = {{0,1,0},{0,0,0},{0,0,1}};
    cout << s.shortestBridge(A) << endl;
    A = {{0,1,0,0,0},{0,1,0,1,1},{0,0,0,0,1},{0,0,0,0,0},{0,0,0,0,0}};
    cout << s.shortestBridge(A) << endl;
    return 0;
}
