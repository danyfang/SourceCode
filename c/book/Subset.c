#include<stdio.h>
#include<stdlib.h>

void print_subset1(int *S, int n, int *P, int cur, int ed){
    for(int i=ed; i<n; ++i){
        P[cur] = S[i];
        for(int j=0; j<=cur; ++j){
            printf("%d ", P[j]);
        }
        printf("\n");
        print_subset1(S, n, P, cur+1, i+1);
    }
}

int main(){
    int arr[] = {1,2,3,4,5,6};
    int n = sizeof(arr) / sizeof(int);
    int *P = (int*)malloc(sizeof(int)*n);
    print_subset1(arr, n, P, 0, 0);
}
