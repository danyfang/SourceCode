#include <stdio.h>
#include <string.h>

#define MAXN 10
int N;
int history[MAXN];
int count;

void dfs(int i){
    int j, k;
    if(i == N){
        count++;
        for(j=0; j<N; j++){
            printf("%d ", history[j]);
        }
        printf("\n");
        return;
    }
    for(k=1; k<=N; k++){
        int ok = 1;
        for(j=0; j<i; j++){
            if(history[j] == k)
                ok = 0;
        }
        if(ok){
            history[i] = k;
            dfs(i+1);
        }
    }
}
int main()
{
    scanf("%d", &N);
    dfs(0);
    printf("Total %d permutations \n", count);
    return 0;
}
