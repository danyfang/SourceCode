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
    int x, y, z, start;
    while((cin>> x >> y) && x && y){
        memset(visited, false, sizeof(visited));
        memset(degree, 0, sizeof(degree));
        memset(&G, 0, sizeof(G));

        start = x < y ? x : y;
        cin >> z;
        G.ne = max(G.ne, z);
        G.nv = max(G.nv, max(x, y));
        G.matrix[x][z] = y;
        G.matrix[y][z] = x;
        ++degree[x];
        ++degree[y];

        while((cin >> x >> y) && x && y){
            cin >> z;
            G.ne = max(G.ne, z);
            G.nv = max(G.nv, max(x, y));
            G.matrix[x][z] = y;
            G.matrix[y][z] = x;
            ++degree[x];
            ++degree[y];
        }

        bool flag = true;
        for(int i=1; i<=G.nv; ++i){
            //this is condition is necessary but not enough
            //there can be at most two vertices that have odd degree
            if(degree[i] & 1){
                flag = false;
                break;
            }
        }
        if(!flag){
            cout << "Round trip does not exist." << endl;
        }
        else{
            euler(start);
            stack_print(s);
        }
    }
    return 0;
}

/*Input

1 2 1
2 3 2
3 1 6
1 2 5
2 3 3
3 1 4
0 0
1 2 1
2 3 2
1 3 3
2 4 4
0 0 
0 0
*/
