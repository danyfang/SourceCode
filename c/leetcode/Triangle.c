// Leetcode probelm No  120 Triangle
//Solution written by Xuqiang Fang on 4 April
#include <stdio.h>
#include <stdlib.h>

int minimumTotal(int** triangle, int triangleRowSize, int* triangleColSize);

int main(int argc, char* argv[])
{
    int row = 4;
    int* triangle[row];
    int colSize[row];
    for(int i=0; i<row; i++){
        colSize[i] = i + 1;
        triangle[i] = (int*)malloc(sizeof(int) * colSize[i]);
    }
    triangle[0][0] = 2;
    triangle[1][0] = 3;
    triangle[1][1] = 4;
    triangle[2][0] = 6;
    triangle[2][1] = 5;
    triangle[2][2] = 7;
    triangle[3][0] = 4;
    triangle[3][1] = 1;
    triangle[3][2] = 8;
    triangle[3][3] = 3;
    int result = minimumTotal(triangle, row, colSize);
    printf("The result is %d\n", result);
    for(int i=0; i<row; i++){
        free(triangle[i]);
    }
    return 0;
}

int minimumTotal(int** triangle, int triangleRowSize, int* triangleColSize)
{
    int* prev = triangle[0];
    int* next = triangle[0];
    int size = 0;
    for(int i=1; i<triangleRowSize; i++)
    {
        next = triangle[i];
        size = triangleColSize[i];
        next[0] = prev[0] + next[0];
        next[size-1] = prev[size-2] + next[size-1];
        for(int j=1; j<size-1; j++)
        {
            int temp = prev[j-1] > prev[j] ? prev[j] : prev[j-1];
            next[j] = temp + next[j];
        }
        prev = next;
    }

    int result = next[0];
    for(int i=1; i<size; i++)
    {
        result = next[i] > result ? result : next[i]; 
    }
    return result;
}
