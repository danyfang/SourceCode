// Leetcode probelm No 8 String to Integer(atoi)
//Solution taken from book 手写代码必备手册
#include <string.h>
#include <stdio.h>
#include <limits.h>

int atoi(const char* str){
    int num = 0;
    int sign = 1;
    const int len = strlen(str);
    int i = 0;
    while(str[i] == ' ' && i < len)
        i++;
    if(str[i] == '+'){
        i++;
        if(i < len && str[i] == '-')
            return 0;
    }
    if(str[i] == '-'){
        sign = -1;
        i++;
        if(i < len && str[i] == '+')
            return 0;
    }

    for(; i < len; i++){
        if(str[i] < '0' || str[i] > '9')
            break;
        if(num > INT_MAX/10 ||(num == INT_MAX /10 && (str[i] - '0') > INT_MAX % 10)){
            return sign == -1 ? INT_MIN : INT_MAX;
        }
        num = num * 10 + str[i] - '0';
    }
    return num * sign;
}

int main(int argc, char* argv[])
{
    printf("%d\n", atoi(argv[1]));
    return 0;
}
