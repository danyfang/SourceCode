#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void swap(void *a, void *b){
	unsigned char *p = a;
	unsigned char *q = b;
	unsigned char tmp;
	tmp = *p;
	*p = *q;
	*q = tmp;
}

void shuffle(void *x, int size_elem, int total_elem){
	int i = total_elem - 1;
	for(i; i>=0; --i){
		int r = rand()%(i+1);
		swap(x+r*size_elem, x+i*size_elem);
	}
}

int main(int argc, char *argv[]){
	srand((unsigned)time(NULL));
	int l[] = {5,2,1,3,4};
	int n;
	n = sizeof(l)/sizeof(l[0]);

	int isSort = 0;
	int i;
	while(!isSort){
		shuffle(1,sizeof(l[0]), n);
		isSort = 1;
		for(i=0; i<n-1; i++){
			if(l[i] > l[i+1]){
				isSort = 0;
				break;
			}
		}
	}
}
