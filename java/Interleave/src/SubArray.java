public class SubArray{
    public int maxSubArray(int[] nums) {
        if (nums.length == 0 ){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        int startIndex = 0;
        int endIndex = 0;
        int finalstartIndex = 0;
        int finalendIndex = 0;
        int maxSum = subSum(nums, startIndex, endIndex);
        for(int i=1; i<=nums.length; i++){//the size of the subArray
            for(int j=0; j<=nums.length-i; j++){//index for each sub array
                startIndex = j;
                endIndex = i+j-1;
                int tempSum = subSum(nums, startIndex, endIndex);
                if(tempSum > maxSum){
                    maxSum = tempSum;
                    finalstartIndex = j;
                    finalendIndex = j+i-1;
                }
            }
        }
        System.out.println("startIndex: "+finalstartIndex+ ", endIndex: "+finalendIndex);
        return maxSum;
    }
    public int subSum(int[] nums, int startIndex, int endIndex){
        int subSum = 0;
        if(startIndex<nums.length && endIndex<nums.length){
            for(int i=startIndex; i<=endIndex; i++){
                subSum+=nums[i];
            }
        }
        return subSum;
    }
}


