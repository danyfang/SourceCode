import java.util.*;

public class Main {
    public static void main(String[] args) {
        Leet s = new Leet();
        System.out.println(s.findLengthOfShortestSubarray(new int[]{1,2,3}));
        System.out.println(s.findLengthOfShortestSubarray(new int[]{1,2,3,10,4,2,3,5}));
        System.out.println(s.findLengthOfShortestSubarray(new int[]{5,4,3,2,1}));
        System.out.println(s.findLengthOfShortestSubarray(new int[]{1,2,3,10,4,2,3,5,5,4,3,2,1}));
        Scanner in = new Scanner(System.in);
        int[] nums = {300};
        while (in.hasNext()) {
            process(in.nextLine(), nums);
        }
        System.out.println(nums[0]);
    }
    public static void process(String s, int[] nums) {
        String[] a = s.split(",");
        int[] b = new int[a.length];
        for (int i=0; i<b.length; ++i) {
            b[i] = Integer.parseInt(a[i]);
        }
        if (nums[0] < b[0]) {
            return;
        }
        if (b[0] >= 100) {
            int t = helper(b[1], 5, 3);
            if (t > b[0] || t > nums[0]) {
                return;
            }
            t = helper(b[2], 5, 3);
            if (nums[0] >= t) {
                nums[0] -= t;
            }
            if(b[2] > b[1] && nums[0] > (b[2]-b[1])) {
                nums[0] -= (b[2] - b[1]);
            }
        } else if (b[0] >= 50) {
            int t = helper(b[1], 3, 2);
            if (t > b[0] || t > nums[0]) {
                return;
            }
            t = helper(b[2], 3,2);
            if (nums[0] >= t) {
                nums[0] -= t;
            }
            if(b[2] > b[1] && nums[0] > (b[2]-b[1])) {
                nums[0] -= (b[2] - b[1]);
            }
        } else {
            int t = 0;
            t += b[2];
            if (t > b[0] || t > nums[0]) {
                return;
            }
            t = b[1];
            if (nums[0] >= t) {
                nums[0] -= t;
            }
            if(b[2] > b[1] && nums[0] >= (b[2]-b[1])) {
                nums[0] -= (b[2] - b[1]);
            }
        }
    }

    private static int helper(int b, int c, int d) {
        if (b <= 15) {
            return b * c;
        } else {
            return 15 * c + (b-15)*d;
        }
    }
}
