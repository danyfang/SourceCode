/*
* An optimal layout problem that uses kruskal algorithm
*/

#include <iostream>
#include <queue>
#include <algorithm>
#include "Ufs.cpp"
using namespace std;

const int MAX_NV = 100001;
const int MAX_NE = 100000;

typedef long long graph_weight_t;

struct edge_t{
    int u;
    int v;
    graph_weight_t w;
    bool operator>(const edge_t &other) const{
        return w > other.w ;
    }
};

edge_t edges[MAX_NE];

graph_weight_t kruskal(const edge_t edges[], int n, int m){
    graph_weight_t sum = 0;
    priority_queue<edge_t, vector<edge_t>, greater<edge_t>> q;
    ufs_t *s = ufs_create(MAX_NV);
    if(n < m-1){
        return -1;
    }
    for(int i=0; i<n; ++i){
        q.push(edges[i]);
    }
    for(int i=0; i<n; ++i){
        const edge_t e = q.top();
        q.pop();
        const int u = ufs_find(s, e.u);
        const int v = ufs_find(s, e.v);
        /*u and v belong to different connnected subgraph*/
        if(u != v){
            ufs_union(s, u, v);
            sum += e.w;
        }
    }
    ufs_destroy(s);
    return sum;
}
bool operator<(const edge_t &e1, const edge_t &e2){
    return e1.w < e2.w;
}

int main(){
    int m, n;
    cin >> m >> n;
    for(int i=0; i<n; ++i){
        int chx, chy;
        int w;
        cin >> chx >> chy >> w;
        edges[i].u = chx;
        edges[i].v = chy;
        edges[i].w = w;
    }
    int ans = kruskal(edges, n, m);
    cout << "Total : " << ans << endl;
    return 0;
}
/*Input
3 3 
1 2 1
1 3 2
2 3 1
*/

