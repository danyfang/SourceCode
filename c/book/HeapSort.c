/**
this program is incomplete
*/
#include <heap.c>
#include <stdio.h>

void heap_sort(heap_elem_t *a, const int n, int(*cmp)(const heap_elem_t*, const heap_elem_t*)){
    int i;
    heap_t *h;
    heap_elem_t tmp;

    h = heap_create(n, cmp);
    h-> elems = a;

    i = (h->size - 2)/2;
    while(i >= 0){
        heap_sift_down(h, i);
        i--;
    }

    for(i = h->size-1; i>0; i--){
        tmp = h->elems[i];
        h->elems[i] = h->elems[0];
        h->elems[0] = tmp;
        h->size = i;
        heap_sift_down(h, 0);
    }

    heap_destroy(h);
}
