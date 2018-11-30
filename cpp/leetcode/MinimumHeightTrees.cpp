//Leetcode Problem No 310 Minimum Height Trees
//Solution written by Xuqiang Fang on 14 Nov, 2018

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
    vector<int> findMinHeightTrees(int n, vector<pair<int, int>>& edges) {
        vector<vector<int>> graph(n, vector<int>(n, 0));
        for(auto& e : edges){
            graph[e.first][e.second] = 1;
            graph[e.second][e.first] = 1;
        }
        int h = INT_MAX;
        unordered_map<int, vector<int>> m;
        for(int i=0; i<n; ++i){
            unordered_set<int> visited;
            int tmp = height(graph, n, i, visited);
            h = min(h, tmp);
            m[tmp].push_back(i);
        }
        return m[h];
    }
private:
    int height(vector<vector<int>>& graph, int n, int node, unordered_set<int>& visited){
        queue<int> q;
        q.push(node);
        visited.insert(node);
        int step = 0;
        while(!q.empty()){
            int size = q.size();
            step++;
            for(int i=0; i<size; ++i){
                auto p = q.front();
                q.pop();
                for(int j=0; j<n; ++j){
                    if(graph[p][j] ==1 && visited.count(j) == 0){
                        visited.insert(j);
                        q.push(j);
                    }
                }
            }
        }
        return step;
    }
};
int main(){
    Solution s;
    vector<pair<int, int>> edges = {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
    auto ans = s.findMinHeightTrees(6, edges);
    for(auto a : ans )
        cout << a << "\t";
    cout << endl;
    return 0;
}
