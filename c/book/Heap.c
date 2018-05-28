#include <stdlib.h>
#include <string.h>
#include <stdio.h>

typedef int heap_elem_t;

typedef struct heap_t{
    int size;
    int capacity;
    heap_elem_t *elems;//heap array
    int (*cmp)(const heap_elem_t*, const heap_elem_t*);//comparator
} heap_t;

int cmp_int(const int *x, const int *y){
    const int sub = *x - *y;
    if(sub > 0){
        return 1;
    }else if(sub < 0){
        return -1;
    }
    else{
        return 0;
    }
}

heap_t* heap_create(const int capacity, int (*cmp)(const heap_elem_t*, const heap_elem_t*)){
    heap_t *h = (heap_t*) malloc(sizeof(heap_t));
    h->size = 0;
    h->capacity = capacity;
    h->elems = (heap_elem_t*)malloc(capacity*sizeof(heap_elem_t));
    h->cmp = cmp;
    return h;
}

void heap_destroy(heap_t *h){
    free(h->elems);
    free(h);
}

int heap_empty(const heap_t *h){
    return h->size == 0;
}

int heap_size(const heap_t *h){
    return h->size;
}

void heap_sift_down(const heap_t *h, const int start){
    int i = start;
    int j;
    const heap_elem_t tmp = h->elems[start];

    for(j = 2*i+1; j<h->size; j=2*j+1){
        if(j < (h->size-1) && h->cmp(&(h->elems[j]), &(h->elems[j+1]))>0){
            j++;
        }
        if(h->cmp(&tmp, &(h->elems[j])) <= 0){
            break;
        }
        else{
            h->elems[i] = h->elems[j];
            i = j;
        }
    }
    h->elems[i] = tmp;
}


void heap_sift_up(const heap_t *h, const int start){
    int j = start;
    int i = (j-1) / 2;
    const heap_elem_t tmp = h->elems[start];
    while(j > 0){
        if(h->cmp(&(h->elems[i]), &tmp) <= 0){
            break;
        }
        else{
            h->elems[j] = h->elems[i];
            j = i;
            i = (i - 1) / 2;
        }
    }
    h->elems[j] = tmp;
}

void heap_push(heap_t *h, const heap_elem_t x){
    if(h->size == h->capacity){//full , resize
        heap_elem_t* tmp = (heap_elem_t*)realloc(h->elems, h->capacity*2*sizeof(heap_elem_t));
        h->elems = tmp;
        h->capacity *= 2;
    }

    h->elems[h->size] = x;
    h->size++;

    heap_sift_up(h, h->size-1);
}

void heap_pop(heap_t *h){
    h->elems[0] = h->elems[h->size-1];
    h->size--;
    heap_sift_down(h, 0);
}

heap_elem_t heap_top(const heap_t *h){
    return h->elems[0];
}




