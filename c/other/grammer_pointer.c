#include <stdio.h>

void swap(int* x, int* y);
int main(int argc, char** argv){
	int aa = 1;
	int bb = 2;
	int *a = &aa;
	int *b = &bb;

	
	printf("before exchange: a = %d, b = %d \n", *a, *b );		
	swap(a,b);
	printf("after exchange: a = %d, b = %d \n", *a, *b );

	return 0;
}
void swap(int *x, int *y){
	int temp = *x;
	*x = *y;
	*y = temp;
}

