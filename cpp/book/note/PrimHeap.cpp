/*
* This program is a implementation of Minimum Spanning Tree using Prim algorithm
* Here minimum means the minimization of weights of edges
* It is another implementation of prim algorithm using heap
* 4 June, 2018
*/
#include <iostream>
#include <queue>
#include <algorithm>
#include <vector>

using namespace std; 

/*maximum number of vertices*/
const int MAX_NV = 100;

typedef int graph_weight_t;
const graph_weight_t GRAPH_INF = INT_MAX;

struct graph_t{
    int nv;
    int ne;
    graph_weight_t matrix[MAX_NV][MAX_NV];
};

graph_t g;

/*define a edge type, to store in a heap*/
struct edge_t{
    int u;
    int v;
    graph_weight_t w;
    /*Important: to use priority_queue we have to overload this > operator*/
    /*doesn't even work with < */
    bool operator>(const edge_t &other) const{
        return w > other.w;
    }
};

int prim(const graph_t &g){
    graph_weight_t sum = 0;
    /*using std::greater<T> would cause the smallest element to appear as the top().*/
    priority_queue<edge_t, vector<edge_t>, greater<edge_t>> q;
    const int n = g.nv;
    bool* used = new bool[n];
    std::fill(used, used+n, false);

    int count = 1;
    int u = 0;
    used[u] = true;
    while(count < n){
        for(int v=0; v<n; ++v){
            if(!used[v]){
                edge_t e = {u, v, g.matrix[u][v]};
                q.push(e);
            }
        }
        while(!q.empty() && count < n){
            const edge_t e = q.top();
            q.pop();
            if(!used[e.v]){
                cout << (char)('A'+e.u) << " - " << (char)('A' + e.v) << " : " 
                    << g.matrix[e.u][e.v] << endl;
                sum += g.matrix[e.u][e.v];
                u = e.v;
                used[u] = true;
                count++;
                break;
            }
        }
    }
    delete[] used;
    return sum;
}

void read_graph(){
    int m, n;
    cin >> m >> n;
    g.nv = m;
    g.ne = n;
    for(int i=0; i<m; ++i){
        for(int j=0; j<n; ++j){
            g.matrix[i][j] = GRAPH_INF;
        }
    }
    for(int k=0; k<n; ++k){
        char chx, chy;
        int w;
        cin >> chx >> chy >> w;
        const int i = chx - 'A';
        const int j = chy - 'A';
        g.matrix[i][j] = w;
        g.matrix[j][i] = w;
    }
}

int main(){
    read_graph();
    int ans = prim(g);
    cout << "Total : " << ans << endl;
    return 0;
}

