#include <stdio.h>
#define f(x) (x*x)
// Marcos only do textual replacement
int main()
{
	int i1, i2;
	i1 = f(8)/f(4);
	i2 = f(4+4);//it is 4+4*4+4 = 16+8 = 24
	printf("%d,%d\n",i1,i2);
	return 0;
}
