#include<stdio.h>
#include<stdlib.h>

static void print_permutation(int n, int cur, int p[]){
    int i, j;
    if(cur == n){
        for(i = 0; i<n; ++i){
            printf("%d", p[i]);
        }
        printf("\n");
    }
    else{
        for(i = 1; i<=n; ++i){
            int used = 0;
            for(j = 0; j<cur; ++j){
                if(p[j] == i){
                    used = 1;
                }
            }
            if(!used){
                p[cur] = i;
                print_permutation(n, cur+1, p);
            }
        }
    }
}

void print(int n){
    int *p = (int*) malloc(n * sizeof(int));
    print_permutation(n, 0, p);
    free(p);
    return;
}

int main(){
    print(3);
    return 0;
}
