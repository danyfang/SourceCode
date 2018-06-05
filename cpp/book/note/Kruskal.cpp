#include <iostream>
#include <queue>
#include <algorithm>
#include "Ufs.cpp"
using namespace std;

const int MAX_NV = 11;
const int MAX_NE = 100;

typedef int graph_weight_t;

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
        if(u != v){
            ufs_union(s, u, v);
            cout << (char)('A' + e.u) << " - " << (char)('A' + e.v) << endl;
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
        char chx, chy;
        int w;
        cin >> chx >> chy >> w;
        edges[i].u = chx - 'A';
        edges[i].v = chy - 'A';
        edges[i].w = w;
    }
    int ans = kruskal(edges, n, m);
    cout << "Total : " << ans << endl;
    return 0;
}
/*Input
7 11
A B 7
A D 5
B C 8
B D 9
B E 7
C E 5
D E 15
D F 6
E F 8
E G 9
F G 11
*/
