#include <stdio.h>
#include <stdlib.h>

typedef int elem_t;
int partition(elem_t a[], const int start, const int end){
    int i = start;
    int j = end - 1;
    const elem_t pivot = a[i];

    while(i < j){
        while(i < j && a[j] >= pivot){
            j--;
        }
        a[i] = a[j];

        while(i < j && a[i] <= pivot){
            i++;
        }
        a[j] = a[i];
    }
    a[i] = pivot;
    return i;
}

void quick_sort(elem_t a[], const int start, const int end){
    if(start < end - 1){// at least two elements
        const int pivot_pos = partition(a, start, end);
        quick_sort(a, start, pivot_pos);
        quick_sort(a, pivot_pos + 1, end);
    }
}

int main(){
    int arr[] = {1,9,4,6,8,3,7,8,4,4,5,67,8,9,0,9,23,32,23,3};
    int n = sizeof(arr) / sizeof(int);
    quick_sort(arr, 0, n);
    for(int i=0; i<n; ++i){
        printf("%d \t", arr[i]);
    }
    printf("\n");
    return 0;
}
