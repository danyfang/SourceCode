#include <stdio.h>
#define f(x) (x*x)

int main()
{
	int i1, i2;
	i1 = f(8)/f(4);
	i2 = f(4+4);
	printf("%d,%d\n",i1,i2);
	return 0;
}
