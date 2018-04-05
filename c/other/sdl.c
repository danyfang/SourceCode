#include <stdio.h>

int main(int argc, char* argv[]){
    char ch;
    int i = 321;
    ch = i;
    printf("%d\n", ch);
    printf("sizeof char %lu\n", sizeof(char));
    printf("sizeof int %lu\n", sizeof(int));
    printf("sizeof short %lu\n", sizeof(short));
    int intArr[6];
    int* p;
    p = &i;
    intArr[3] = 5;
    p[0] = 4;
    p[4] = 0;
    printf("%d \n", *(p+5));
    getchar();
    return 0;
}
