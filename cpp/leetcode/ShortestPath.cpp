#include <iostream>
#include <vector>
#include <cstring>

using namespace std;
//solution provided by user@site1997
class Solution{
public:
    /*
     * the first part is trivial, try to calculate the minimum distance between every pair of nodes, 
     * if two nodes are not connected by any route, the distance is infinitive
     */
    int shortestPathLength(vector<vector<int>> &graph){
        int n = graph.size();
        memset(dis, 0x3f, sizeof(dis));
        for(int i=0; i<n; ++i){
            int to_size = graph[i].size();
            for(int j=0; j<to_size; ++j){
                int u = i;
                int v = graph[i][j];
                dis[u][v] = 1;
            }
        }
        floyd(n);
        int min_dis = dpfunc(n);
        return min_dis;
    }
private:
    /*
     * there are total 2^n number of groups at first, let x be a group, each node can be in it or not
     * To calculate dp[][], enumerate every possible state (which is "group". For example, If group only 
     *has node 0 and node 2, the value of group is 101 in binary). Pick a node that is in the "group"(for example, node u), 
     *and pick a node that is not in the "group"(for example, node v). Then update dp[group+v][v] by getting the minimum 
     *value between dp[group+v][v] and dp[group][u] + dis[u][v].
     */
    int dpfunc(int n){
        memset(dp, 0x3f, sizeof(dp));
        for(int i=0; i<n; ++i){
            dp[1<<i][i] = 0;
        }
        for(int group=1; group<(1<<n); group++){
            for(int u=0; u<n; ++u){
                for(int v=0; v<n; ++v){
                    int src = 1 << u;
                    int dst = 1 << v;
                    if((group & src) && !(group & dst)){
                        cout << "src : " << src << ", dst : " << dst << endl;
                        dp[group|dst][v] = min(dp[group][u]+ dis[u][v], dp[group|dst][v]);
                    }
                }
            }
        }
        int min_dis = 0x3f3f3f;
        for(int i=0; i<n; ++i){
            min_dis = min(dp[(1 << n)-1][1], min_dis);
        }
        return min_dis;
    }

    void floyd(int n){
        for(int k=0; k<n; ++k){
            for(int i=0; i<n; ++i){
                for(int j=0; j<n; ++j){
                    dis[i][j] = min(dis[i][j], dis[i][k] + dis[k][j]);
                }
            }
        }
    }

    int dis[15][15];
    int dp[1<<13][13];
};

int main(){
    Solution s;
    vector<vector<int>> graph{{1,2,3},{0},{0},{0}};
    cout << s.shortestPathLength(graph) << endl;
    return 0;
}
