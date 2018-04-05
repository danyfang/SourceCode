// Leetcode probelm No  494 Target Sum
//Solution written by Xuqiang Fang on 4 April 
#include <stdio.h>


int subsetSum(int* nums, int numsSize, int S);
int findTargetSumWays(int* nums, int numsSize, int S);


int main(int argc, char* argv[])
{
    int nums[] = {1,1,1,1,1};
    printf("The numer of ways is %d\n", findTargetSumWays(nums, 5, 3));
    return 0;
}

int findTargetSumWays(int* nums, int numsSize, int S)
{
    int sum = 0;
    for(int i=0; i<numsSize; i++)
    {
        sum += nums[i];
    }

    return sum < S || (sum + S) % 2 > 0 ? 0 : subsetSum(nums, numsSize, (S+sum)>>1);
}

int subsetSum(int* nums, int numsSize, int S)
{
    int dp[S+1];
    for(int i=0; i<=S; i++)
    {
        dp[i] = 0;
    }
    dp[0] = 1;
    for(int i=0; i<numsSize; i++)
    {
        for(int j=S; j>=nums[i]; j--)
        {
            dp[j] += dp[j-nums[i]];
        }
    }
    return dp[S];
}


