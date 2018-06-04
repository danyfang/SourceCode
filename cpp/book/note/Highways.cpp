/*
* An application using MST(minimum spanning tree)
*/

#include <iostream>

using namespace std; 
/*maximum number of vertices*/
const int MAX_NV = 750;
int n, m, x[MAX_NV], y[MAX_NV];

static int distance(int i, int j){
    return (x[i]-x[j]) * (x[i]-x[j]) + (y[i]-y[j]) * (y[i]-y[j]);
}
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
            if(g.matrix[closedge[k].adjvex][k] > 0){
                cout << closedge[k].adjvex+1 << " " << k+1 << endl;
            }
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
    int i, j;
    cin >> n;
    g.nv = n;
    g.ne = n * (n-1) / 2;

    for(i=0; i<n; ++i){
        cin >> x[i] >> y[i];
    }
    for(i=0; i<n; ++i){
        for(j=i; j<n; ++j){
            g.matrix[i][j] = g.matrix[j][i] = distance(i, j);
        }
    }
    cin >> m;
    for(i=0; i<m; ++i){
        int a, b;
        cin >> a >>b;
        g.matrix[a-1][b-1] = g.matrix[b-1][a-1] = 0;
    }
}

int main(){
    read_graph();
    cout << "Result : " << endl;
    prim(g);
    return 0;
}
/*Input
9
1 5
0 0
3 2
4 5
5 1
0 4
5 2
1 2
5 3
3
1 3
9 7
1 2
*/
