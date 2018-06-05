/*
* This program is an implementation of union find algorithm
*/

#include <stdlib.h>
typedef struct ufs_t{
    int *p;
    int size;
} ufs_t;

ufs_t* ufs_create(int n){
    ufs_t *ufs = (ufs_t*) malloc (sizeof(ufs_t));
    int i;
    ufs->p = (int*)malloc(n*sizeof(int));
    for(int i=0; i<n; ++i){
        ufs->p[i] = -1;
    }
    return ufs;
}

void ufs_destroy(ufs_t *ufs){
    free(ufs->p);
    free(ufs);
}

//find operation, with route compression
int ufs_find(ufs_t *ufs, int x){
    if(ufs->p[x] < 0){
        return x;
    }
    return ufs->p[x] = ufs_find(ufs, ufs->p[x]);
}

/*
//the following two find methods are alternatives to the find function above, but without route compression
static int ufs_find_naive(ufs_t *ufs, int x){
    while(ufs->p[x] >= 0){
        x = ufs->p[x];
    }
    return x;
}

static int ufs_find_iterative(ufs_t *ufs, int x){
    int oldx = x;
    while(ufs->p[x] >= 0){
        x = ufs->p[x];
    }
    while(oldx != x){
        int temp = ufs->p[oldx];
        ufs->p[oldx] = x;
        oldx = temp;
    }
    return x;
}
*/

/*
* Union operation, union y into the same set as x
*/
int ufs_union(ufs_t *ufs, int x, int y){
    const int rx = ufs_find(ufs, x);
    const int ry = ufs_find(ufs, y);
    if(rx == ry){
        return -1;
    }

    ufs->p[rx] += ufs->p[ry];
    ufs->p[ry] = rx;
    return 0;
}

int ufs_set_size(ufs_t *ufs, int x){
    const int rx = ufs_find(ufs, x);
    return -ufs->p[rx];
}


