// Leetcode probelm No 416 Parition Equal Subset Sum
//Solution written by Xuqiang Fang on 4 April, 2018 
#include <stdio.h>
#include <stdbool.h>
bool canPartition(int* nums, int numsSize)
{
    int sum = 0;
    for(int i=0; i<numsSize; i++)
    {
        sum += nums[i];
    }
    if((sum & 1) == 1)
        return 0;
    sum >>= 1;
    int dp[sum+1];
    for(int i=0; i<=sum; i++)
    {
        dp[i] = 0;
    }
    dp[0] = 1;
    for(int i=0; i<numsSize; i++)
    {
        for(int j=sum; j>=nums[i]; j--)
            dp[j] += dp[j-nums[i]];
    }
    return dp[sum] == 0 ? false: true;
}
int main(int argc, char* argv[])
{
    int nums1[] = {1,5,11,5};
    int nums2[] = {1,2,3,5};
    printf("%d\n", canPartition(nums1, 4));
    printf("%d\n", canPartition(nums2, 4));
    return 0;
}
