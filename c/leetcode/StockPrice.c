// Leetcode probelm No 121 Best Time to Buy and Sell Stock
//Solution written by Xuqiang Fang on 5 April, 2018 
#include <stdio.h>
int maxProfit(int* prices, int pricesSize)
{
    if(prices == NULL || pricesSize <= 0)
        return 0;
    int low = prices[0];
    int profit = 0;
    for(int i=1; i<pricesSize; i++)
    {
       low = prices[i] >= low ? low : prices[i]; 
       int temp = prices[i] - low;
       profit = profit >= temp ? profit : temp;
    }
    return profit;
}
int main(int argc, char* argv[])
{
    int prices[] = {7,1,5,3,6,4};
    printf("Max profit is %d\n",maxProfit(prices, 6));
    return 0;
}
