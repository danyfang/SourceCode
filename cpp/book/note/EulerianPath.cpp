#include <iostream>
#include <cstring>
#include <algorithm>
#include <stack>

using namespace std;
const int MAX_NV = 45;
const int MAX_NE = 1996;

struct graph_t{
    int nv;//number of vertices
    int ne;//number of edges
    //G[vertex][edge] = vertex
    int matrix[MAX_NV][MAX_NE];
};

graph_t G;

bool visited[MAX_NE];
int degree[MAX_NV];

stack<int> s;

void stack_print(stack<int> &s){
    while(!s.empty()){
        cout << s.top() << endl;
        s.pop();
    }
    cout << endl;
}

void euler(int u){
    for(int e=1; e<=G.ne; e++){
        if(!visited[e] && G.matrix[u][e]){
            visited[e] = true;
            euler(G.matrix[u][e]);
            s.push(e);
        }
    }
}

int main(){
    memset(visited, false, sizeof(visited));
    memset(degree, 0, sizeof(degree));
    memset(&G, 0, sizeof(G));
    return 0;
}
