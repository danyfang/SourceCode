import java.util.*;

/*
* Nowcoder solutions, written by Xuqiang Fang in Aug, 2020
* */
public class Now {
    public void printHelloWorld(){
        System.out.println("Hello, Nowcoder");
        String ans = "Hello World";
        String[] arr = ans.split(" ");
        Set<Integer> set = new HashSet<>();
        for(int k : set){
            System.out.println(k);
        }
    }


    public void readInput(){
        Scanner keyin = new Scanner(System.in);
        while(keyin.hasNextLine()) {
            String putIn = keyin.nextLine();
            System.out.println(putIn);
        }
    }

    public static int hexToInt(String s){
        char[] ch = s.substring(2).toCharArray();
        int n = ch.length;
        int ans = 0;
        for(int i=n-1; i>=0; --i){
            int pow = n-1-i;
            if(ch[i] >= '0' && ch[i] <= '9'){
                ans += (ch[i]-'0')*Math.pow(16, pow);
            } else {
                ans += (ch[i]-'A'+10)*Math.pow(16, pow);
            }
        }
        return ans;
    }

    public static long dateToSeconds(String s){
        int[] mon = new int[]{0,31,28,31,30,31,30,31,31,30,31,30};
        int year = Integer.parseInt(s.substring(0, 4));
        int month = Integer.parseInt(s.substring(5,7));
        int day = Integer.parseInt(s.substring(8,10));
        int hour = Integer.parseInt(s.substring(11,13));
        int minute = Integer.parseInt(s.substring(14,16));
        int second = Integer.parseInt(s.substring(17,19));
        long ans = 0;
        for(int y=2000; y<year; ++y){
            if((y % 4 == 0 && y % 100 != 0) || (y % 400 == 0)){
                ans += 366*24*3600;
            } else {
                ans += 365*24*3600;
            }
        }
        for(int m=1; m<=month; ++m){
            ans += mon[m-1] * 24* 3600;
            if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)){
                if(month > 2){
                    ans += 24 * 3600;
                }
            }
        }
        ans += (day-1) * 24 * 3600;
        ans += hour * 3600;
        ans += minute * 60;
        ans += second;
        return ans;
    }

    public static void maxCoord(int[][] coord) {
        TreeMap<Integer, Integer> left = new TreeMap<>();
        TreeMap<Integer, Integer> right = new TreeMap<>();
        for (int[] ints : coord) {
            if (!left.containsKey(ints[0])) {
                left.put(ints[0], ints[1]);
            } else {
                left.put(ints[0], Math.max(ints[1], left.get(ints[0])));
            }
            if(!right.containsKey(ints[1])){
                right.put(ints[1], ints[0]);
            } else {
                right.put(ints[1], Math.max(ints[0], right.get(ints[1])));
            }
        }
        int current = right.get(right.lastKey());
        for(int k : right.descendingKeySet()) {
            int v = right.get(k);
            if(v < current) {
                continue;
            }
            current = v;
            System.out.println(current + " " + left.get(current));
        }
    }

    public static int maxProduct(int[] nums){
        int n = nums.length;
        int ans = 0;
        for (int i=0; i<n; ++i) {
            int min = nums[i];
            int sum = nums[i];
            ans = Math.max(ans, min * sum);
            for (int j=i+1; j<n; ++j) {
                min = Math.min(min, nums[j]);
                sum += nums[j];
                ans = Math.max(ans, min * sum);
            }
        }
        System.out.println(ans);
        return ans;
    }

    public static int countLR (int[] a, int[] b) {
        int n = a.length;
        int[] sum = new int[n];
        sum[0] = a[0];
        for (int i=1; i<n; ++i) {
            sum[i] = sum[i-1] + a[i];
        }
        int ans = 0;
        for (int i=0; i<n; ++i){
            for (int j=i; j<n; ++j) {
                if (sum[j] - sum[i] + a[i] == b[i] + b[j]) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static int mountainSequence (int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int n = nums.length;
        int[] l = new int[n];
        int[] r = new int[n];
        Arrays.fill(l, 1);
        Arrays.fill(r, 1);
        for (int i=1; i<n; ++i) {
            for (int j=0; j<i; ++j) {
                if (nums[i] > nums[j]) {
                    l[i] = Math.max(l[i], l[j] + 1);
                }
            }
            for (int j=n-1; j>i; --j) {
                if (nums[n-1-i] > nums[j]) {
                    r[n-1-i] = Math.max(r[n-1-i], r[j] + 1);
                }
            }
        }
        int ans = 1;
        for (int i=0; i<n; ++i) {
            ans = Math.max(ans, l[i]+r[i]-1);
        }
        return ans;
    }

    public static int[] solve (int n, int q, int[] a, int[] p) {
        return a;
    }
}


