// C template

#include <stdio.h>

int main(int arc, char ** argv)
{
	
	printf("****ASCII CODE PROGRAM****\n");
	int ascii;
	printf("Enter an ASCII code: ");
	scanf("%d", &ascii);
	/*
	problems with the following line, %c does not work?
	*/
	printf("%d is the ASCII code for %c \n", ascii, (char)ascii);


	printf("****FLOATING NUMBER PROGRAM****\n");
	float num;
	printf("Enter a floating point value: ");
	scanf("%f", &num);
	printf("fixed point notation : %f\n", num);
	printf("exponential notation : %e\n", num);
	printf("p notation : %a\n", num);


	printf("****STRING INPUT&OUTPUT PROGRAM****\n");
	char fname[40];
	char lname[40];
	printf("Enter your first name : ");
	scanf("%s", fname);
	printf("Enter your last name : ");
	scanf("%s", lname);
	printf("%s, %s\n", fname, lname);


	printf("****ASCII PROGRAM****\n");
	#define SIZE 26
	char lcase[SIZE];
	for(int i=0; i<SIZE; i++)
	{
		lcase[i] = 'a' + i;	
	}

	for(int i=0; i<SIZE; i++)
	{
		printf("%c", lcase[i]);
	}
	printf("\n");
	



	return 0;
}

