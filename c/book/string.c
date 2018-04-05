#include <stdio.h>
#include <string.h>

int main(int argc, char* argv[])
{
    /*
    char* string = "I love C programming";
    char charr[21];
    strcpy(charr,string);
    printf("%lu\n", strlen(string));
    for(int i=0; i<20; i++)
    {
        printf("%c \n", charr[i]);
        if(charr[i] == '\0')
            break;
    }
    */
    char str[1000];
    int len;

    strcpy(str, "binky");
    len = strlen(str);
    int i, j;
    char temp;
    for(i=0, j=len-1; i< j; i++, j--)
    {
        temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

    printf("the length is %d \n", len);
    for(int x=0; x<len; x++)
    {
        printf("%c \n", str[x]);
        /*
        if(str[x] != '\0')
            printf("%c \n", str[x]);
        */
    }
    return 0;
}
