#include <stdio.h>
#include <stdlib.h>

typedef int elem_t;

static void merge(elem_t a[], elem_t tmp[], const int start, const int mid, const int end){
    int i, j, k;
    for(i = 0; i < end; i++){
        tmp[i] = a[i];
    }

    for(i = start, j = mid, k = start; i < mid && j < end; k++){
        if (tmp[i] < tmp[j]){
            a[k] = tmp[i++];
        }
        else{
            a[k] = tmp[j++];
        }
    }

    while(i < mid){
        a[k++] = tmp[i++];
    }
    while(j < end){
        a[k++] = tmp[j++];
    }
}

void merge_sort(elem_t a[], elem_t tmp[], const int start, const int end){
    if(start < end - 1){
        const int mid = (start + end) / 2;
        merge_sort(a, tmp, start, mid);
        merge_sort(a, tmp, mid, end);
        merge(a, tmp, start, mid, end);
    }
}

int main(){
    int arr[] = {1,9,4,6,8,3,7,8,4,4,5,67,8,9,0,9,23,32,23,3};
    int n = sizeof(arr) / sizeof(int);
    printf("n = %d \n", n);
    int *copy = malloc(sizeof(int) * n );
    merge_sort(arr, copy, 0, n);
    for(int i=0; i<n; ++i){
        printf("%d \t", arr[i]);
    }
    printf("\n");
    free(copy);
    return 0; 
}
