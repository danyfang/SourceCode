/*
Use DFS to do topological sort, c style
*/
#include <iostream>
#include <stack>

using namespace std;
const int MAX_NV = 100;
typedef int graph_weight_t;
const graph_weight_t GRAPH_INF = INT_MAX;

struct graph_t{
    int nv;
    int ne;
    graph_weight_t matrix[MAX_NV][MAX_NV];
};

graph_t g;
int topological[MAX_NV];

bool topo_sort(const graph_t& g, int topoloigcal[]){
    const int n = g.nv;
    int *in_degree = new int[n]();
    for(int i=0; i<n; ++i){
        for(int j=0; j<n; ++j){
            if(g.matrix[i][j] < GRAPH_INF){
                in_degree[j]++; 
            }
        }
    }

    stack<int> s;
    for(int i=0; i<n; ++i){
        if(in_degree[i]==0){
            s.push(i); 
        } 
    }
    int count = 0;
    while(!s.empty()){
        const int u = s.top();
        s.pop();
        topological[count++] = u;
        for(int i=0; i<n; ++i){
            if(g.matrix[u][i] < GRAPH_INF){
                if(--in_degree[i] == 0){
                    s.push(i);
                }
            }
        }
    }

    delete[] in_degree;

    if(count != n){//there is a loop
        return false;
    }
    else{
        return true;
    }
}


void read_graph(){
    cin >> g.nv >> g.ne;
    for(int i=0; i<g.nv; ++i){
        for(int j=0; j<g.nv; ++j){
            g.matrix[i][j] = GRAPH_INF;
        }
    }
    for(int k=0; k<g.ne; ++k){
        char chx, chy;
        graph_weight_t w;
        cin >> chx >> chy >> w;
        g.matrix[chx-'A'][chy-'A'] = w;
    }
}

//C++ class
#include <vector>
class Topo{
public:
    bool topo_sort(){
        return false; 
    }
private:
    struct graph{
        int nv;
        int ne;
    };
};
int main(){
    read_graph();
    topo_sort(g, topological);
    for(int i=0; i<g.nv; ++i){
        cout << (char)('A'+topological[i]) << " ";
    }
    cout << endl;
    return 0;
}

/*Input
6 8
A C 10
A E 30
A F 100
B C 5
C D 50
D 5 10
E D 20
E F 60
*/
