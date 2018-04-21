//Codebook DFS

#include <iostream>
#define MAX 19
int N;
int history[MAX];
int count;
using namespace std;
void dfs(int i);

int main(){
    cin >> N;
    dfs(0);
    return 0;
}

void dfs(int i){
    int j, k;
    if(i == N){
        for(int i=0; i<N; i++){
            cout << history[i] ;
        }
        cout << endl;
        return;
    }

    for(k=1; k<=N; ++k){
        int ok = 1;
        for(j=0; j<i; ++j){//look if k is in previous i items in the history
            if(history[j] == k)
                ok = 0;
        }

        if(ok == 1){//if not in, put k at position i
            history[i] = k;
            dfs(i+1);
        }
    }
}
