#include <stdio.h>
#include <stdlib.h>
#include <assert.h>

int main(int argc, char* argv[])
{
    int arr[1000];
    int* prr;
    prr = (int *)malloc(sizeof(int) * 1000);
    assert(prr != NULL);

    arr[23] = 0;
    prr[23]=  0;
    free(prr);
    return 0;
}
