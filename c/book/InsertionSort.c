#include <stdio.h>
#include <stdlib.h>

typedef int elem_t;

void straight_insertion_sort(elem_t a[], const int start, const int end){
    elem_t tmp;
    int i, j;
    for(i = start+1; i<end; ++i){
        tmp = a[i];
        for(j = i-1; tmp < a[j] && j >= start; j--){
            a[j+1] = a[j];
        }
        a[j+1] = tmp;
    }
}


void binary_insertion_sort(elem_t a[], const int start, const int end){
    elem_t tmp;
    int i, j, left, right, mid;
    for(i = start + 1; i < end; ++i){
        tmp = a[i];
        left = start;
        right = i-1;
        while(left <= right){
            mid = left + (right - left) / 2;
            if(tmp < a[mid]){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        for(j = i-1; j >= left; j--){
            a[j+1] = a[j];
        }
        a[left] = tmp;
    }
}

int main(){
    int arr[] = {1,9,4,6,8,3,7,8,4,4,5,67,8,9,0,9,23,32,23,3};
    int n = sizeof(arr) / sizeof(int);
    int *copy = malloc(n * sizeof(int));
    for(int i=0; i<n; ++i){
        copy[i] = arr[i];
    }
    straight_insertion_sort(arr, 0, n);
    printf("straight insertion sort: \n");
    for(int i=0; i<n; ++i){
        printf("%d \t", arr[i]);
    }
    printf("\n");
    printf("binary insertion sort: \n");
    binary_insertion_sort(copy, 0, n);
    for(int i=0; i<n; ++i){
        printf("%d \t", arr[i]);
    }
    printf("\n");
    free(copy);
    return 0;
}
