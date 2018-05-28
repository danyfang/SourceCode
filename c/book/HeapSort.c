#include "Heap.c"

void heap_sort(heap_elem_t *a, const int n, int(*cmp)(const heap_elem_t*, const heap_elem_t*)){
    int i;
    heap_t *h;
    heap_elem_t tmp;

    h = heap_create(n, cmp);
    for(i = 0; i<n; ++i){
        heap_push(h, a[i]);
    }

    i = (h->size - 2)/2;
    while(i >= 0){
        heap_sift_down(h, i);
        i--;
    }
    /* don't know what this does
    * But I think this part is wrong because it should not deal with heap size directly
    for(i = h->size-1; i>0; i--){
        tmp = h->elems[i];
        h->elems[i] = h->elems[0];
        h->elems[0] = tmp;
        h->size = i;
        heap_sift_down(h, 0);
    }
    */
    for(i = 0; i<n; ++i){
        a[i] = heap_top(h);
        heap_pop(h);
    }
    heap_destroy(h);
}

int main(){
    int arr[] = {1,3,4,6,3,4,2,4,5,7,9,2,4,7,9,8,7,9,7,6,7,6,5,3,5,3,3,4,2,3,4,2,3,4,2,3,4,2,3};
    int n = sizeof(arr) / sizeof(int);
    for(int i=0; i<n; ++i){
        printf("%d ", arr[i]);
    }
    printf("\n");
    heap_sort(arr, n, cmp_int);
    for(int i=0; i<n; ++i){
        printf("%d ", arr[i]);
    }
    printf("\n");
    return 0;
}
