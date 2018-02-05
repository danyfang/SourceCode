/*
This program is a small DFA representation
*/

#define M 2
#define N 3

#include <stdio.h>
int main(){
    char table[M][N];
    // initialize the table
    for(int i=0; i<M; i++)
        for (int j=0;j<N;j++)
            table[i][j] = 0;
    // get the table representation of dfa
    table[0][0] = 1;
    table[1][1] = 1;
    table[1][2] = 1;

    int array[10] = {};
    printf("%d\n", array[0]);

    return 0;


}