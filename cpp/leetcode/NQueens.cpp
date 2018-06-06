//Leetcode Problem No 51 N-Queens
//Leetcode Problem No 52 N-Queens II
//Solution written by Xuqiang Fang on 5 June, 2018

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
    vector<vector<string>> solveNQueens(int n) {
        vector<vector<int>> per;
        vector<int> t;
        dfs(per, t, n);
        vector<vector<string>> res;
        string s;
        for(int i=0; i<n; ++i){
            s.push_back('.');
        }
        for(auto p : per){
            vector<string> a;
            for(auto i : p){
                s[i] = 'Q';
                a.push_back(s);
                s[i] = '.';
            }
            res.push_back(a);
        }
        cout << "In total there are " << res.size() << " solutions" << endl;
        return res;
    }
private:
    void dfs(vector<vector<int>> &ans, vector<int> &t, int n){
        if(t.size() == n && check(t, n)){
            ans.push_back(t); 
            return;
        } 
        for(int i=0; i<n; ++i){
            int flag = 1;
            for(int j=0; j<t.size(); ++j){
                if(t[j] == i){
                    flag = 0;
                    break;
                }
            }
            if(flag && check(t, n)){
                t.push_back(i);
                dfs(ans, t, n);
                t.pop_back();
            }
        }
    }
    bool check(vector<int> &v, int n){
        //check two diagnals to see if there is any attacks possible
        vector<int> diag(2*n-1,0);
        vector<int> diagg(2*n-1,0);
        for(int i=0; i<v.size(); ++i){
            int x = i+v[i];
            int y = n-1+i-v[i];
            if(diag[x] || diagg[y]){
                return false;
            }
            else{
                diag[x] = 1;
                diagg[y] = 1;
            }
        }
        return true;
    }
};

int main(){
    Solution s;
    auto a = s.solveNQueens(6);
    for(auto b : a){
        for(auto c : b){
            cout << c << ", ";
        }
        cout << "\n";
    }
    cout << a.size() << endl;
    return 0;
}
