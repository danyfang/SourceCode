//Merge sort written by Xuqiang Fang

#include <stdio.h>

void MergeSort(int* a, int len_a, int* b, int len_b, int* result);
void QuickSort(int* a, int len);
int main(int argc, char** argv){
	int a[] = {1,4,6,76,8768,8879879,873,3};
	int b[] = {354,354,65,765,7,5876,8,6797,3};

	const int len_a = sizeof(a)/sizeof(a[0]);
	const int len_b = sizeof(b)/sizeof(a[0]);

	QuickSort(a, len_a);
	QuickSort(b, len_b);
	
	int result[len_a+len_b] = {}; 
	MergeSort(a,len_a,b,len_b,result);
	for(int i=0; i<len_a+len_b; i++){
		printf("%d\t", result[i]);
		printf("\n");
	}
}

void MergeSort(int* a, int len_a, int* b, int len_b, int* result){
	int foot_a = 0;
	int foot_b = 0;
//	printf("length of a is %d \n",len_a);
//	printf("length of b is %d \n",len_b);
	for(int i=0; i<len_a+len_b; i++){
		if(foot_a==len_a){
			*(result+i) = *(b+foot_b++);
			continue;
		}
		else if(foot_b==len_b){
			*(result+i) = *(a+foot_a++);
			continue;
		}
		if(*(a+foot_a) < *(b+foot_b)){
				*(result+i) = *(a+foot_a++);
			}else{
				*(result+i) = *(b+foot_b++);
			}
	}		
//	printf("length of a is %d \n",foot_a);
//	printf("length of b is %d \n",foot_b);
}
void QuickSort(int* a, int len){
	for(int i=0; i<len; i++){
		for(int j=i+1; j<len; j++){
			if(*(a+i) > *(a+j)){
				int tmp = *(a+i);
				*(a+i) = *(a+j);
				*(a+j) = tmp;
//				printf("exchange %d and %d \n",*(a+i),*(a+j));
			}
		}
	}
//	puts("after quicksort \n");
//	for(int i=0; i<len; i++){
//		printf("%d\n",*(a+i));
//	}
}
