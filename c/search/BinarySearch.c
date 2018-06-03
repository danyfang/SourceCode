#include <stdio.h>
typedef int elem_t;
/*
* Binary Search, the elements are sorted
*/
int binary_search(const elem_t a[], const int n, const elem_t x){
    int left = 0;
    int right = n-1;
    int mid;
    while(left < right){
        mid = left + (right - left)/2;
        if(x > a[mid]){
            left = mid + 1;
        }
        else if(x < a[mid]){
            right = mid - 1;
        }
        else{
            return mid;
        }
    }
    return -(left+1);
}

int main(){
    int a[] = {1,3,5,7,9};
    printf("%d\n", binary_search(a, sizeof(a)/sizeof(int), 7));
}
