import java.util.*;

public class Solution {
    public static void preprocess(String[] input) {
        if (input.length != 6) {
            System.out.println("ERROR");
            return;
        }
        int index = 0;
        // check if integer
        for (int i=0; i<4; ++i) {
            if((int)Double.parseDouble(input[i]) != Integer.parseInt(input[i])) {
                System.out.println("ERROR");
                return;
            }
        }
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]);
        int d = Integer.parseInt(input[3]);
        // check if greater than 0
        if (a <=0 || b <= 0 || c <= 0 || d <= 0) {
            System.out.println("ERROR");
            return;
        }
        Map<String, Integer> map = new HashMap<>();
        String[] valid = {"HKD", "CNY", "USD", "GBP", "MIN", "MAX"};
        index = 0;
        for (String s : valid) {
            map.put(s, index++);
        }
        for (int i=4; i<6; ++i) {
            if (!map.containsKey(input[i])) {
                System.out.println("ERROR");
                return;
            }
        }
        process(a, b, c, d, map.get(input[4]), input[5].equals("MAX"));
    }

    public static void process(int a, int b, int c, int d, int type, boolean big) {
        int ans = 0;
        if (type == 3) {
            ans += d * c * b * a;
        } else if (type == 2) {
            ans += d * b * a;
        } else if (type == 1) {
            ans += d * a;
        } else {
            ans += d;
        }
        StringBuilder sb = new StringBuilder();
        if (!big) {
            sb.append(ans);
            sb.append(" ");
            sb.append("HKD");
        } else {
            int x = ans / (a * b * c);
            if (x > 0) {
                sb.append(x);
                sb.append(" ");
                sb.append("GBP");
                sb.append(" ");
                ans %= a * b * c;
            }
            int y = ans / a * b;
            if (y > 0) {
                sb.append(y);
                sb.append(" ");
                sb.append("USD");
                sb.append(" ");
                ans %= a * b;
            }
            int z = ans / a;
            if (z > 0) {
                sb.append(z);
                sb.append(" ");
                sb.append("CHN");
                sb.append(" ");
                ans %= a;
            }
            if (ans > 0) {
                sb.append(ans);
                sb.append(" ");
                sb.append("HKD");
                sb.append(" ");
            }
        }
        while(sb.charAt(sb.length()-1) == ' ') {
            sb.deleteCharAt(sb.length()-1);
        }
        System.out.println(sb.toString());
    }
}
