//small demo

#include <stdio.h>

int main(int argc, char** argv){
	int arr[200000] = {};
	for(int i=37; i!=0; i=(i+37)%100)
	{
		arr[i] = 1;	
	}
	for(int i=0; i<100; i++){
		if(arr[i] != 1)
			printf("%d\n",arr[i]);
	}
	return 0;
}
