#include<stdio.h>
void swap(int *a, int *b);
int main(){
    int a = 9;
    int b = 8;
    printf("before swap: a = %d, b = %d \n", a, b);
    swap(&a,&b);
    printf("after swap: a = %d, b = %d \n", a, b);
}

void swap(int *a, int *b){
    int temp = *a;
    *a = *b;
    *b = temp;
}
