//Leetcode Problem No 851 Loud and Rich
//Solution written by Xuqiang Fang on 10 June, 2018

#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <unordered_map>
#include <unordered_set>
#include <stack>
#include <queue>

using namespace std;
/*
* Use plain DFS is going to TLE, so we have to use DFS with memorization
*/
class Solution{
public:
    vector<int> loudAndRich(vector<vector<int>>& richer, vector<int>& quiet) {
        const int N = quiet.size();
        for(auto& r : richer){
            m[r[1]].insert(r[0]);
        }
        for(int i=0; i<N; ++i){
            q[quiet[i]] = i;
        }
        vector<int> ans(N, -1);
        for(int i=0; i<N; ++i){
            ans[i] = q[dfs(quiet, ans, i)];
        }
        return ans;
    }
private:
    //return the quietness of a person
    int dfs(const vector<int>& quiet, vector<int>& ans, int i){
        if(m[i].empty() || i == q[0]){
            return quiet[i];
        }
        if(ans[i] != -1){
            return quiet[ans[i]];
        }
        int t = quiet[i];
        for(auto k : m[i]){
            t = min(t, quiet[k]);//direct parent
            t = min(t, dfs(quiet, ans, k));//more ancestors
        }
        return t;
    }
    unordered_map<int, unordered_set<int>> m;
    unordered_map<int, int> q;
};

/*
* Here is another thought of using Union Find
*/
class Xuqiang{
public:
    vector<int> loudAndRich(vector<vector<int>>& richer, vector<int>& quiet){
        int N = quiet.size();
        vector<int> ans(N, N);
        return ans;
    }
};
int main(){
    Solution s;
    vector<vector<int>> richer{{1,0},{2,1},{3,1},{3,7},{4,3},{5,3},{6,3}};
    vector<int> quiet{3,2,5,4,6,1,7,0};
    vector<int> ans = s.loudAndRich(richer, quiet);
    for(auto i : ans){
        cout << i << " ";
    }
    cout << endl;
    return 0;
}
