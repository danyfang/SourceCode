import java.util.LinkedList;
import java.util.Stack;

public class Book {
    public int maxArea(int[][] nums) {
        if(nums == null || nums.length == 0 || nums[0].length == 0) {
            return 0;
        }
        int ans = 0;
        int[] height = new int[nums[0].length];
        for(int i=0; i<nums.length; ++i) {
            for(int j=0; j<height.length; ++j) {
                height[j] = nums[i][j] == 0 ? 0 : nums[i][j] + height[j];
            }
            ans = Math.max(ans, maxRectangle(height));
        }
        return ans;
    }

    public int maxAreaChar(char[][] nums) {
        if(nums == null || nums.length == 0 || nums[0].length == 0) {
            return 0;
        }
        int ans = 0;
        int[] height = new int[nums[0].length];
        for(int i=0; i<nums.length; ++i) {
            for(int j=0; j<height.length; ++j) {
                height[j] = nums[i][j] == '0' ? 0 : height[j]+1;
                System.out.print(height[j] + "  ");
            }
            System.out.println("\n");
            ans = Math.max(ans, maxRectangle(height));
        }
        return ans;
    }

    public int maxRectangle(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for(int i=0; i<height.length; ++i) {
            while (!stack.isEmpty()  && height[i] <= height[stack.peek()]) {
                int j = stack.pop();
                int k = stack.isEmpty() ? -1 : stack.peek();
                ans = Math.max(ans, (i - k - 1) * height[j]);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            int j = stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek();
            ans = Math.max(ans, (height.length - k - 1) * height[j]);
        }
        return ans;
    }

    /*return the # of subarrays s.t. max([i,j])-min([i,j]) <= n*/
    public int getNum(int[] nums, int n){
        if(nums == null || nums.length == 0){
            return 0;
        }
        LinkedList<Integer> qmax = new LinkedList<>();//max at head
        LinkedList<Integer> qmin = new LinkedList<>();//min at head
        int i = 0;
        int j = 0;
        int ans = 0;
        while(i < nums.length) {
            while(j < nums.length) {
                if(!qmax.isEmpty() && nums[qmax.peekLast()] <= nums[j]) {
                    qmax.pollLast();
                }
                qmax.addLast(j);
                if(!qmin.isEmpty() && nums[qmin.peekLast()] >= nums[j]) {
                    qmin.pollLast();
                }
                qmin.addLast(j);
                if((nums[qmax.getFirst()])-(nums[qmin.getFirst()]) > n){
                    break;
                }
                j++;
            }
            if(qmin.peekFirst() == i){
                qmin.pollFirst();
            }
            if(qmax.peekFirst() == i){
                qmax.pollFirst();
            }
            ans += j-i;
        }
        return ans;
    }
}
