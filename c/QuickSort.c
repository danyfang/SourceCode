#include <stdio.h>


void quickSort(int *p, int length){
	for(int i=0; i<length; i++){
		for(int j=i+1; j<length; j++){
			if(*(p+j) < *(p+i)){
				//printf(" exchange %d and %d\n", *(p+i), *(p+j));
				int tmp = *(p+i);
				*(p+i) = *(p+j);
				*(p+j) = tmp;
			}
		}
	}
}

int main(int argc, char*argv[]){
	puts("hello world");
	int nums[] = {4,5,76,678,8,4,3,57,57,63,4,6,78,89,8219};
	int n = sizeof(nums)/sizeof(nums[0]);

	quickSort(nums, n);

	for(int i=0; i<n; i++){
		printf("%d\n",nums[i]);
	}
	return 0;
}
