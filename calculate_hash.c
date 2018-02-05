/*
very small piece of c code, created by xuqiang fang on Jan, 8th, 2018
All rights reserved.
*/
#include<stdio.h>


/* 	Internal funcion to calculate hash for keys.
	It's based on the DJB algorithm from Daniel J. Bernstein.
	The key must be ended by '\0' character.*/
static unsigned int hash_table_calc_hash(char* str)
{
	unsigned int hash = 5381;
	int c;
	while ((c = *str++) != 0)
		hash = ((hash << 5) + hash) + c;

	return hash;
}

int main()
{
	unsigned int r = 0;
	char *c = "h";
	char hash[] = "hashtable";
	r = hash_table_calc_hash(c);
	printf("%lu\n",sizeof(hash));
	for (int i=0; i<sizeof(hash); i++)
	{
		r = hash_table_calc_hash(&hash[i]);
		printf("hash value is %u\n",r);
	}
	return 0;
}
