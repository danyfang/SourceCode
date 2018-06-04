/*
* This program is a implementation of Minimum Spanning Tree using Prim algorithm
* Here minimum means the minimization of weights of edges
* 4 June, 2018
*/

#include <iostream>

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

struct closedge_t{
    int adjvex;
    graph_weight_t lowcost;
};

static int min_element(const closedge_t closedge[], int n){
    int min_value = GRAPH_INF;
    int min_pos = -1;
    for(int i=0; i<n; ++i){
        if(closedge[i].lowcost > -GRAPH_INF){
            if(min_value > closedge[i].lowcost){
                min_value = closedge[i].lowcost;
                min_pos = i;
            }
        }
    }
    return min_pos;
}

graph_weight_t prim(const graph_t &g){
    graph_weight_t sum = 0;
    int u = 0;
    const int n = g.nv;
    closedge_t* const closedge = new closedge_t[n];
    
    /*adjacent array initialization*/
    for(int i=0; i<n; ++i){
        closedge[i].adjvex = u;
        closedge[i].lowcost = g.matrix[u][i];
    }

    closedge[u].lowcost = -GRAPH_INF;
    for(int i=0; i<n; ++i){
        if(i != u){
            /*find the next edge that has minimum weight*/
            const int k = min_element(closedge, n);
            cout << (char)('A' + closedge[k].adjvex) << " - " << (char)('A' + k)
                << " : " << g.matrix[closedge[k].adjvex][k] << endl;

            sum += g.matrix[closedge[k].adjvex][k];

            /*this line means vertex k is included in U*/
            closedge[k].lowcost = -GRAPH_INF;
            /*updates adjacent vertex weight, infinite when not adjacent*/
            for(int j=0; j<n; ++j){
                const graph_weight_t w = g.matrix[k][j];
                if(w < closedge[j].lowcost){
                    closedge[j].adjvex = k;
                    closedge[j].lowcost = w;
                }
            }
        }
    }

    delete [] closedge;
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

/* Input
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

Output
A - D : 5
D - F : 6
A - B : 7
B - E : 7
E - C : 5
E - G : 9
Total : 39
*/
