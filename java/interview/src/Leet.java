import javafx.util.Pair;
import org.junit.Test;

import java.util.*;

public class Leet {
    public String makeGood(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else {
                char top = Character.toLowerCase(stack.peek());
                char down = Character.toLowerCase(s.charAt(i));
                if (top == down && stack.peek() != s.charAt(i)) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public char findKthBit(int n, int k) {
        if (k == 1) {
            return '0';
        }
        StringBuilder sb = new StringBuilder();
        sb.append('0');
        while (n-- > 1) {
            sb = help(sb);
        }
        //System.out.println(sb.toString());
        return sb.charAt(k - 1);
    }

    private StringBuilder help(StringBuilder sb) {
        StringBuilder ans = new StringBuilder(sb);
        ans.append('1');
        for (int i = sb.length() - 1; i >= 0; --i) {
            ans.append('1' - sb.charAt(i));
        }
        return ans;
    }

    public int maxNonOverlapping(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int temp = 0;
            for (int j = 0; i + j < nums.length; ++j) {
                temp += nums[i + j];
                if (temp == target) {
                    map.put(i, i + j);
                }
            }
        }
        List<int[]> intervals = new ArrayList<>();
        for (int key : map.keySet()) {
            intervals.add(new int[]{key, map.get(key)});
        }
        intervals.sort(Comparator.comparingInt((int[] a) -> a[1]));

        int ans = 0;
        int[] dummy = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
        for (int i = 0; i < intervals.size(); ++i) {
            int[] t = intervals.get(i);
            if (t[0] <= dummy[1]) {
                dummy = dummy[1] < t[1] ? dummy : t;
            } else {
                dummy = t;
                ans++;
            }
        }
        return ans;
    }

    public String restoreString(String s, int[] indices) {
        if (s == null || s.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < indices.length; ++i) {
            sb.setCharAt(indices[i], s.charAt(i));
        }
        return sb.toString();
    }


    public static long process(String s){
        int[] mon = new int[]{0,31,59,90,120, 151, 181, 212, 243, 273, 304, 334};
        int year = Integer.parseInt(s.substring(0, 4));
        int month = Integer.parseInt(s.substring(5,7));
        int day = Integer.parseInt(s.substring(8,10));
        int hour = Integer.parseInt(s.substring(11,13));
        int minute = Integer.parseInt(s.substring(14,16));
        int second = Integer.parseInt(s.substring(17,19));
        int number = Integer.parseInt(s.substring(20));
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
        ans += day * 24 * 3600;
        return ans*1000;
    }

    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i != nums.length; ++i) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        int ans = 0;
        for (int key : map.keySet()) {
            ans += combination(map.get(key));
        }
        return ans;
    }

    private int combination(int x) {
        return x * (x - 1) / 2;
    }

    public String reformatDate(String date) {
        String[] day_arr = new String[]{"1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th", "9th",
                "10th", "11th", "12th", "13th", "14th", "15th", "16th", "17th", "18th", "19th",
                "20th", "21st", "22nd", "23rd", "24th", "25th", "26th", "27th", "28th", "29th", "30th", "31st"};

        String[] month_arr = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep",
                "Oct", "Nov", "Dec"};
        HashMap<String, String> day = new HashMap<>();
        for (int i = 0; i < day_arr.length; ++i) {
            day.put(day_arr[i], i < 9 ? "0" + String.valueOf(i + 1) : String.valueOf(i + 1));
        }
        HashMap<String, String> month = new HashMap<>();
        for (int i = 0; i < month_arr.length; ++i) {
            month.put(month_arr[i], i < 9 ? "0" + String.valueOf(i + 1) : String.valueOf(i + 1));
        }
        String[] d = date.split(" ");
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.valueOf(d[2]));
        sb.append("-");
        sb.append(month.get(d[1]));
        sb.append("-");
        sb.append(day.get(d[0]));
        return sb.toString();
    }

    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        for (int i = 1; i + 1 < arr.length; ++i) {
            if (arr[i + 1] - arr[i] != arr[i] - arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public boolean isPathCrossing(String path) {
        int x = 0;
        int y = 0;
        char[] ch = path.toCharArray();
        HashSet<Pair<Integer, Integer>> set = new HashSet<>();
        set.add(new Pair<>(0, 0));
        for (int i = 0; i < ch.length; ++i) {
            if (ch[i] == 'N') {
                y++;
            } else if (ch[i] == 'E') {
                x++;
            } else if (ch[i] == 'S') {
                y--;
            } else {
                x--;
            }
            Pair<Integer, Integer> t = new Pair<>(x, y);
            if (set.contains(t)) {
                return true;
            } else {
                set.add(t);
            }
        }
        return false;
    }

    public double average(int[] salary) {
        Arrays.sort(salary);
        double ans = 0;
        for (int i = 1; i < salary.length - 1; ++i) {
            ans += salary[i];
        }
        return ans / (salary.length - 2);
    }

    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2 * n];
        for (int i = 0; i < n; ++i) {
            ans[2 * i] = nums[i];
            ans[2 * i + 1] = nums[n + i];
        }
        return ans;
    }

    public int isPrefixOfWord(String sentence, String w) {
        String s[] = sentence.split(" ");
        for(int i=0; i<s.length; ++i) {
            if(s[i].startsWith(w)) {
                return i+1;
            }
        }
        return -1;
    }

    public int maxPower(String s) {
        int n = s.length();
        int[] dp = new int[n];
        int ans = 1;
        dp[0] = 1;
        for(int i=1; i<n; ++i) {
            if(s.charAt(i) == s.charAt(i-1)) {
                dp[i] = dp[i-1]+1;
                ans = Math.max(ans, dp[i]);
            } else {
                dp[i] = 1;
            }
        }
        return ans;
    }

    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int[] row = new int[m];
        for(int i=0; i<m; ++i) {
            row[i] = matrix[i][0];
            for(int j=1; j<n; ++j){
                row[i] = matrix[i][j] < row[i] ? matrix[i][j] : row[i];
            }
        }
        int[] col = new int[n];
        for(int j=0; j<n; ++j) {
            col[j] = matrix[0][j];
            for(int i=0; i<m; ++i){
                col[j] = matrix[i][j] > col[j] ? matrix[i][j] : col[j];
            }
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<m; ++i) {
            set.add(row[i]);
        }
        for(int j=0; j<n; ++j) {
            if(set.contains(col[j])) {
                ans.add(col[j]);
            }
        }
        return ans;
    }

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int ans = 0;
        for(int i=0; i<arr1.length; ++i) {
            boolean flag = true;
            for(int j=0; j<arr2.length; ++j){
                if(Math.abs(arr1[i] - arr2[j]) <= d) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                ans++;
            }
        }
        return ans;
    }

    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        if(n%2 != 0){
            while(n-- > 0){
                sb.append('s');
            }
        } else {
            while(n-- > 1){
                sb.append('s');
            }
            sb.append('b');
        }
        return sb.toString();
    }

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        System.arraycopy(nums, 0, ans, 0, n);
        Arrays.sort(nums);
        Stack<Integer> s = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; ++i){
            if(s.isEmpty()) {
                map.put(nums[i], 0);
            } else {
                if(s.peek() < nums[i]){
                    map.put(nums[i], s.size());
                }
            }
            s.push(nums[i]);
        }
        for(int i=0; i<n; ++i) {
            ans[i] = map.get(ans[i]);
        }
        return ans;
    }

    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        int index = 1;
        for(int i=0; i<target.length; ++i) {
            while(index++ < target[i]) {
                ans.add("Push");
                ans.add("Pop");
            }
            ans.add("Push");
        }
        return ans;
    }

    public String sortString(String s) {
        int[] count = new int[26];
        char[] ch = new char[]{'a','b','c','d','e','f','g','h','i','j','k',
            'l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        for(char c : s.toCharArray()) {
            count[c-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        boolean changed = true;
        while(changed) {
            changed = false;
            for(int i=0; i<26; ++i) {
                if(count[i]-- > 0) {
                    changed = true;
                    sb.append(ch[i]);
                }
            }
            for(int i=25; i>=0; --i) {
                if(count[i]-- > 0) {
                    changed = true;
                    sb.append(ch[i]);
                }
            }
        }
        return sb.toString();
    }

    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(absDate(date2) - absDate(date1));
    }
    public int absDate(String date) {
        int[] month = new int[]{0, 31,28,31,30,31,30,31,31,30,31,30,31};
        int ans = 0;
        String[] s = date.split("-");
        int y = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int d = Integer.parseInt(s[2]);
        for(int i=1970; i<y; ++i) {
            if((i%4 == 0 && i%100 != 0) || (i%400 == 0)) {
                ans += 366;
            } else {
                ans += 365;
            }
        }
        for(int i=1; i<m; ++i) {
            if(i == 2 && ((y%4 == 0&&y%100 != 0) || (y%400 == 0))) {
                ans += month[i] + 1;
            } else {
                ans += month[i];
            }
        }
        ans += d;
        return ans;
    }

    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for(int i=0; i<n; ++i){
            int x = countBit(arr[i]);
            if(!map.containsKey(x)) {
                map.put(x, new ArrayList<>());
            }
            map.get(x).add(arr[i]);
        }
        List<Integer> ans = new ArrayList<>();
        for(int k : map.keySet()) {
            map.get(k).sort(Comparator.comparingInt(Integer::intValue));
        }
        for(int k : map.keySet()) {
            ans.addAll(map.get(k));
        }
        for(int i=0; i<ans.size(); ++i){
            arr[i] = ans.get(i);
        }
        return arr;
    }
    private int countBit(int n) {
        int ans = 0;
        while(n > 0){
            ans += n&1;
            n >>= 1;
        }
        return ans;
    }

    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        for(int i=0; i<m; ++i){
            ans += (n - binarySearch(grid[i]));
        }
        return ans;
    }
    private int binarySearch(int[] nums){
        int n = nums.length;
        int l = 0, r = n;

        while (l < r){
            int m = l + (r-l)/2;
            if(nums[m] < 0){
                r = m;
            } else {
                l = m+1;
            }
        }
        return l;
    }

    public boolean checkIfExist(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; ++i) {
            if(map.containsKey(2*arr[i]) && map.get(2*arr[i])!= i ){
                return true;
            } else if(arr[i]%2 == 0 && map.containsKey(arr[i]/2) && map.get(arr[i]/2) != i) {
                return true;
            }
            else{
                map.put(arr[i], i);
            }
        }
        return false;
    }

    public int numberOfSteps (int num) {
        int ans = 0;
        while(num > 0) {
            if(num % 2 == 0) {
                num /= 2;
            } else {
                num -= 1;
            }
            ans++;
        }
        return ans;
    }


    public int removePalindromeSub(String s) {
        if(s.length() == 0) {
            return 0;
        } else if(isParlindromic(s)){
            return 1;
        }
        return 2;
    }
    private boolean isParlindromic(String s){
        int l = 0, r = s.length()-1;
        while(l <= r){
            if(s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }


    public int[] arrayRankTransform(int[] arr) {
        if(arr == null || arr.length == 0){
            return arr;
        }
        int[] copy = new int[arr.length];
        System.arraycopy(arr,0, copy, 0, arr.length);
        Arrays.sort(copy);
        int[] rank = new int[arr.length];
        rank[0] = 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(copy[0], 1);
        for(int i=1; i<arr.length; ++i){
            if(copy[i] > copy[i-1]){
                map.put(copy[i], map.get(copy[i-1])+1);
            }
        }
        for(int i=0; i<arr.length; ++i){
            rank[i] = map.get(arr[i]);
        }
        return rank;
    }

    public void duplicateZeros(int[] arr) {
        Queue<Integer> q = new LinkedList<>();
        int n = arr.length;
        for(int i=0; i<n; ++i){
            q.offer(arr[i]);
        }
        for(int i=0; i<n; ++i){
            if(q.peek() == 0){
                arr[i] = q.peek();
                ++i;
            }
            if(i < n){
                arr[i] = q.poll();
            }
        }
    }


    public int maximum69Number (int num) {
        StringBuilder sb = new StringBuilder();
        String s = String.valueOf(num);
        boolean changed = false;
        for(int i=0; i<s.length(); ++i){
            if(s.charAt(i) == '6' && !changed){
                sb.append('9');
                changed = true;
            } else {
                sb.append(s.charAt(i));
            }
        }
        return Integer.parseInt(sb.toString());
    }


    public List<String> stringMatching(String[] words) {
        int n = words.length;
        HashSet<String> set = new HashSet<>();
        for(int i=0; i<n; ++i){
            for(int j=0; j<n; ++j){
                if(i != j && words[i].contains(words[j])) {
                    set.add(words[j]);
                }
            }
        }
        List<String> ans = new ArrayList<>(set);
        return ans;
    }

    public boolean checkStraightLine(int[][] coordinates) {
        int m = coordinates.length;
        if(m == 2) {
            return true;
        } else {
            int[] a = coordinates[0];
            int[] b = coordinates[1];
            for(int i=2; i<m; ++i) {
                int[] c = coordinates[i];
                if((b[1]-a[1])*(c[0]-a[0]) != (c[1]-a[1])*(b[0]-a[0])) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean uniqueOccurrences(int[] arr) {
        int[] count = new int[2001];
        for(int i=0; i<arr.length; ++i){
            count[1000+arr[i]]++;
        }
        Set<Integer> s = new HashSet<>();
        for(int i=0; i<count.length; ++i){
            if(count[i] != 0){
                if(s.contains(count[i])){
                    return false;
                } else {
                    s.add(count[i]);
                }
            }
        }
        return true;
    }


    public String dayOfTheWeek(int d, int m, int y) {
        String[] date = {"Thursday", "Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday"};
        int[] month = new int[]{0, 31,28,31,30,31,30,31,31,30,31,30,31};
        int ans = 0;
        for(int i=1971; i<y; ++i) {
            if((i%4 == 0 && i%100 != 0) || (i%400 == 0)) {
                ans += 366;
            } else {
                ans += 365;
            }
        }
        for(int i=1; i<m; ++i) {
            if(i == 2 && ((y%4 == 0&&y%100 != 0) || (y%400 == 0))) {
                ans += month[i] + 1;
            } else {
                ans += month[i];
            }
        }
        ans += d;
        return date[ans%7];
    }

    public int[] getNoZeroIntegers(int n) {
        int[] ans = new int[2];
        for(int i=1; i<=n/2; ++i){
            if(valid(i) && valid(n-i)) {
                ans[0] = i;
                ans[1] = n-i;
                break;
            }
        }
        return ans;
    }
    private boolean valid(int x){
        char[] ch = String.valueOf(x).toCharArray();
        for(int i=0; i<ch.length; ++i){
            if(ch[i] == '0'){
                return false;
            }
        }
        return true;
    }


    public int findNumbers(int[] nums) {
        int ans = 0;
        for(int n : nums){
            if(String.valueOf(n).length() % 2 == 0){
                ans++;
            }
        }
        return ans;
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0) {
            return image;
        }
        int r = image.length;
        int c = image[0].length;
        if (sr < 0 || sr >= r || sc < 0 || sc >= c) {
            return image;
        }
        floodFillHelper(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }

    private void floodFillHelper(int[][] image, int sr, int sc, int newColor, int oldColor) {
        int r = image.length;
        int c = image[0].length;
        if (sr < 0 || sr >= r || sc < 0 || sc >= c || image[sr][sc] != oldColor) {
            return;
        }
        image[sr][sc] = newColor;
        int[][] direcs = {{0,1},{1,0},{0,-1},{-1,0}};
        for (int[] d : direcs) {
            int x = sr + d[0];
            int y = sc + d[1];
            if (x >= 0 && x < r && y >=0 && y < c && image[x][y] == oldColor) {
                floodFillHelper(image, x, y, newColor, oldColor);
            }
        }
    }


    public int[] replaceElements(int[] arr) {
        int maxFromRight = -1;
        int n = arr.length;
        int[] ans = new int[n];
        ans[n-1] = maxFromRight;
        for(int i=n-2; i>=0; --i){
            if(arr[i+1] > maxFromRight){
                ans[i] = arr[i+1];
                maxFromRight = arr[i+1];
            } else  {
                ans[i] = maxFromRight;
            }
        }
        return ans;
    }

    public int[] sumZero(int n) {
        int[] ans = new int[n];
        for(int i=1; i<=n/2; ++i){
            ans[2*(i-1)] = i;
            ans[2*(i-1)+1] = -i;
        }
        if(n % 2 != 0){
            ans[n-1] = 0;
        }
        return ans;
    }

    public String freqAlphabets(String s) {
        char[] chars = new char[]{'a','b','c','d','e','f','g','h','i','j','k',
                'l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        Stack<Integer> stack = new Stack<>();
        for(int i=s.length()-1; i>=0; --i){
            if(s.charAt(i) == '#'){
                stack.push(Integer.parseInt(s.substring(i-2,i)));
                i = i-2;
            }else{
                stack.push(Integer.parseInt(s.substring(i, i+1)));
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(chars[stack.pop()-1]);
        }
        return sb.toString();
    }


    public int[] decompressRLElist(int[] nums) {
        int n = nums.length;
        int l = 0;
        for(int i=0; i<n/2; ++i){
            l += nums[2*i];
        }
        int[] ans = new int[l];
        int index = 0;
        for(int i=0; i<n/2; ++i){
            while(nums[2*i]-- > 0){
                ans[index++] = nums[2*i+1];
            }
        }
        return ans;
    }


    public String destCity(List<List<String>> paths) {
        HashSet<String> s = new HashSet<>();
        HashSet<String> d = new HashSet<>();
        for(List<String> path : paths){
            s.add(path.get(0));
            d.add(path.get(1));
        }
        for(String t : d){
            if(!s.contains(t)){
                return t;
            }
        }
        return null;
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extra) {
        int n = candies.length;
        int max = candies[0];
        for(int i=0; i<n; ++i){
            max = Math.max(candies[i], max);
        }
        List<Boolean> ans = new ArrayList<>();
        for(int i=0; i<n; ++i){
            if(candies[i]+extra >= max){
                ans.add(true);
            } else {
                ans.add(false);
            }
        }
        return ans;
    }

    public String reformat(String s) {
        List<Character> chars = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        for(int i=0; i<s.length(); ++i){
            if('a' <= s.charAt(i) && s.charAt(i) <= 'z'){
                chars.add(s.charAt(i));
            } else {
                nums.add(s.charAt(i)-'0');
            }
        }
        if((nums.size() == 0 && chars.size() >= 2)
                || nums.size() >= 2 && chars.size() == 0
                || Math.abs(nums.size() - chars.size()) > 2) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if(chars.size() > nums.size()){
            int i = 0;
            for(; i<nums.size(); ++i){
                sb.append(chars.get(i));
                sb.append(nums.get(i));
            }
            while(i < chars.size()){
                sb.append(chars.get(i++));
            }
        } else {
            int i = 0;
            for(; i<chars.size(); ++i){
                sb.append(nums.get(i));
                sb.append(chars.get(i));
            }
            while(i < nums.size()){
                sb.append(nums.get(i++));
            }
        }
        return sb.toString();
    }

    public int fib(int N) {
        if(N == 0){
            return 0;
        } else if(N == 1){
            return 1;
        }
        int[] ans = new int[N+1];
        ans[0] = 0;
        ans[1] = 1;
        for(int i=2; i<=N; ++i){
           ans[i] = ans[i-1] + ans[i-2];
        }
        return ans[N];
    }

    public int balancedStringSplit(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for(int i=0; i<s.length(); ++i) {
            if(!stack.isEmpty()) {
                if(stack.peek() == s.charAt(i)){
                    stack.push(s.charAt(i));
                } else {
                    stack.pop();
                    if(stack.isEmpty()){
                        count++;
                    }
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        return count;
    }

    public int subtractProductAndSum(int n) {
        int product = 1;
        int sum = 0;
        int unit = 10;
        while(n >= 10) {
            int t = n % unit;
            product *= t;
            sum += t;
            n = n / 10;
        }
        product *= n;
        sum += n;
        return product - sum;
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr2.length; ++i){
            map.put(arr2[i], i);
        }
        int[] nums = new int[arr1.length];
        for(int i=0; i<arr1.length; ++i){
            if(map.containsKey(arr1[i])){
                nums[i] = map.get(arr1[i]);
            } else {
                nums[i] = arr2.length + arr1[i];
            }
        }
        Arrays.sort(nums);
        for(int i=0; i<nums.length; ++i){
            if(nums[i] < arr2.length){
                arr1[i] = arr2[nums[i]];
            } else {
                arr1[i] = nums[i] - arr2.length;
            }
        }
        return arr1;
    }


    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        /*
        * First Method, use tree map
        TreeMap<Integer, List<List<Integer>>> map = new TreeMap<>();
        Arrays.sort(arr);
        for(int i=1; i<arr.length; ++i){
            if(!map.containsKey(arr[i]-arr[i-1])){
                map.put(arr[i]-arr[i-1], new ArrayList<>());
            }
            map.get(arr[i]-arr[i-1]).add(Arrays.asList(arr[i-1], arr[i]));
        }
        return map.firstEntry().getValue();
        * */
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        int d = Integer.MAX_VALUE;
        for(int i=1; i<arr.length; ++i){
            if(arr[i]-arr[i-1] < d){
                ans.clear();
                ans.add(Arrays.asList(arr[i-1], arr[i]));
                d = arr[i]-arr[i-1];
            } else if (arr[i]-arr[i-1] == d){
                ans.add(Arrays.asList(arr[i-1], arr[i]));
            }
        }
        return ans;
    }


    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int a = 0, b = 0;
        for(int i=0; i<distance.length; ++i){
            b += distance[i];
            if((i >= start && i < destination) || (i >= destination && i <start)){
                a += distance[i];
            }
        }
        return Math.min(a, b-a);
    }


    public int[] kWeakestRows(int[][] mat, int k) {
        List<int[]> list = new ArrayList<>();
        for(int i=0; i<mat.length; ++i){
            list.add(new int[]{i, sumMat(mat[i])});
        }
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){
                    return Integer.compare(o1[0], o2[0]);
                }
                return Integer.compare(o1[1], o2[1]);
            }
        });
        int[] ans = new int[k];
        for(int i=0; i<k; ++i){
            ans[i] = list.get(i)[0];
        }
        return ans;
    }

    private int sumMat(int[] m){
        int ans = 0;
        for(int n : m){
            ans += n;
        }
        return ans;
    }


    public int maxScore(String s) {
        int ones = 0;
        for(int i=0; i<s.length(); ++i){
            if(s.charAt(i) == '1'){
                ones++;
            }
        }
        int max = 0;
        int t_ones = 0;
        int t_zeros = 0;
        for(int i=0; i<s.length()-1; ++i){
            if(s.charAt(i) == '0'){
                t_zeros++;
            } else {
                t_ones++;
            }
            max = Math.max(max, t_zeros + ones-t_ones);
        }
        return max;
    }

    public int minStartValue(int[] nums) {
        int min = nums[0] > 0 ? 0 : nums[0];
        int sum = nums[0];
        for(int i=1; i<nums.length; ++i){
            sum += nums[i];
            min = Math.min(sum, min);
        }
        return 1-min;
    }

    public List<Integer> minSubsequence(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int sum = 0;
        for(int i=0; i<n; ++i){
            sum += nums[i];
        }
        int s = 0;
        List<Integer> ans = new ArrayList<>();
        for(int i=n-1; i>=0; --i){
            s += nums[i];
            ans.add(nums[i]);
            if (s > sum -s){
                return ans;
            }
        }
        return null;
    }


    public int[] createTargetArray(int[] nums, int[] index) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i=0; i<nums.length; ++i){
            linkedList.add(index[i], nums[i]);
        }
        for(int i=0; i<nums.length; ++i){
            nums[i] = linkedList.get(i);
        }
        return nums;
    }


    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); ++i){
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                st.push(s.charAt(i));
            } else {
                if(st.isEmpty()) {
                    return false;
                } else {
                    char ch = st.peek();
                    char c = s.charAt(i);
                    if((c == ')' && ch == '(') || (c == ']' && ch == '[') || (c == '}' && ch == '{')){
                        st.pop();
                    }
                    else{
                        return false;
                    }
                }
            }
        }
        return st.isEmpty();
    }


    public boolean isSymmetric(Tree.TreeNode root) {
        return (root == null || isSymmetricHelper(root.left, root.right));
    }
    private boolean isSymmetricHelper(Tree.TreeNode left, Tree.TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetricHelper(left.right, right.left) && isSymmetricHelper(left.left, right.right);
    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sumSoFar = nums[0];
        int ans = nums[0];
        for (int i=1; i<nums.length; ++i) {
            if (sumSoFar > 0) {
                sumSoFar += nums[i];
            } else {
                sumSoFar = nums[i];
            }
            ans = Math.max(ans, sumSoFar);
        }
        return ans;
    }

    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return digits;
        }
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<digits.length; ++i) {
            stack.push(digits[i]);
        }
        int forward = 1;
        while(!stack.isEmpty()) {
            int x = forward + stack.pop();
            list.add(x % 10);
            forward = x / 10;
        }
        if(forward > 0){
            list.add(1);
        }
        int[] ans = new int[list.size()];
        int n = ans.length;
        for(int i=0; i<n; ++i) {
            ans[i] = list.get(n-1-i);
        }
        return ans;
    }

    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            sb.append((char)('A'+ n % 26));
            n /= 26;
        }
        sb.reverse();
        return sb.toString();
    }

    public int titleToNumber(String s) {
        int ans = 0;
        for(int i=0; i<s.length(); ++i) {
            ans *= 26;
            ans += s.charAt(i)-'A'+1;
        }
        return ans;
    }

    public int trailingZeroes(int n) {
        int ans = 0;
        long u = 5;
        while (n >= u) {
            ans += n / u;
            u *= 5;
        }
        return ans;
    }

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int n = nums.length;
        int y, x;
        while (k-- > 0) {
            y = nums[n-1];
            x = nums[0];
            for (int i=0; i<n; ++i) {
                x = nums[i];
                nums[i] = y;
                y = x;
            }
        }
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        if (n == 1) {
            return nums[n-1];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = nums[1];
        for (int i=2; i<n; ++i) {
            dp[i] = nums[i] + Math.max(dp[i-2], i-3>=0 ? dp[i-3] : 0);
        }
        return Math.max(dp[n-1], dp[n-2]);
    }

    public int countPrimes(int n){
        int c = 0;
        boolean[] arr = new boolean[n];
        Arrays.fill(arr, true);
        for(int i=2; i*i<n; i++){
            if(arr[i]){
                for(int j=i*i; j<n; j+=i)
                    arr[j] = false;
            }
        }
        for(int i=2; i<n; i++){
            if(arr[i])
                c++;
        }
        return c;
    }

    public boolean isIsomorphic(String s, String t) {
        int[] num = new int[256];
        int n = s.length();
        for (int i=0; i<n; ++i) {
            int x = s.charAt(i) - '!';
            int y = t.charAt(i) - '!';
            if (num[x] != 0 && num[x] != y) {
                return false;
            }
            num[x] = y;
        }
        return true;
    }
    // Leetcode medium level

    public int minOperations(int n) {
        int ans = 0;
        for(int i=0; i<n; ++i){
            ans += Math.abs(n-(2*i+1));
        }
        return ans/2;
    }
    public int minInsertions(String s) {
        Stack<Character> stack = new Stack<>();
        int i = 0;
        int ans = 0;
        while(i+1 < s.length()) {
            if(s.charAt(i) == '('){
                stack.push('(');
                i++;
            } else {
                if(s.charAt(i+1) == ')'){
                    if(stack.isEmpty()) {
                        ans++;
                    } else {
                        stack.pop();
                    }
                    i += 2;
                } else {
                    ans++;
                    if(stack.isEmpty()){
                        ans++;
                    } else {
                        stack.pop();
                    }
                    i++;
                }
            }
        }
        if(i == s.length()-1){
            if(s.charAt(i) == '('){
                stack.push('(');
            } else {
                ans++;
                if(stack.isEmpty()){
                    ans++;
                } else {
                    stack.pop();
                }
            }
        }
        ans += 2*stack.size();
        return ans;
    }

    public int numSplits(String s) {
        int ans = 0;
        HashMap<Character, Integer> left = new HashMap<>();
        HashMap<Character, Integer> right = new HashMap<>();
        for(int i=0; i<s.length(); ++i) {
            right.put(s.charAt(i), right.getOrDefault(s.charAt(i), 0)+1);
        }
        for(int i=0; i<s.length(); ++i){
            left.put(s.charAt(i), left.getOrDefault(s.charAt(i), 0)+1);
            right.put(s.charAt(i), right.get(s.charAt(i))-1);
            if(right.get(s.charAt(i)) == 0) {
                right.remove(s.charAt(i));
            }
            if(left.size() == right.size()){
                ans++;
            }
        }
        return ans;
    }

    public int longestAwesomeExceedTimeLimit(String s) {
        int ans = 0;
        Map<Integer, Integer> odd = new HashMap<>();
        Map<Integer, Integer> even = new HashMap<>();
        for(int i=0; i<s.length(); ++i){
            for(int j=i; j<s.length(); ++j){
                int k = s.charAt(j)-'0';
                if(isPalindrome(odd, even, k, 1)){
                    ans = Math.max(ans, j-i+1);
                    System.out.println(s.substring(i, j+1));
                }
            }
            odd.clear();
            even.clear();
        }
        return ans;
    }

    public boolean isPalindrome(Map<Integer, Integer> odd, Map<Integer, Integer> even, int k, int v){
        if(even.containsKey(k)){
            odd.put(k, even.get(k)+v);
            even.remove(k);
        } else if(odd.containsKey(k)) {
            even.put(k, odd.get(k) + v);
            if (even.get(k) == 0) {
                even.remove(k);
            }
            odd.remove(k);
        } else {
            odd.put(k, v);
        }
        return odd.size() == 1 || (odd.isEmpty() && !even.isEmpty());
    }

    /*max profit, only one transaction*/
    public int maxProfitOneTrans(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        int ans = 0;
        int lowestSoFar = prices[0];
        for(int i=1; i<prices.length; ++i) {
            lowestSoFar = Math.min(prices[i], lowestSoFar);
            ans = Math.max(ans, prices[i] - lowestSoFar);
        }
        return ans;
    }

    /*max profit, as many trans as possible*/
    /*[7,1,5,3,6,4]*/
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        int ans = 0;
        for(int i=1; i<prices.length; ++i) {
            if(prices[i] > prices[i-1]) {
                ans += (prices[i] - prices[i-1]);
            }
        }
        return ans;
    }

    /*max profit, at most k trans*/
    /*dp[i][j] means max profit within i trans up to day j*/
    public int maxProfit(int k, int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int[][] dp = new int[k+1][n];
        for(int i=1; i<=k; ++i) {
            int maxTemp = -prices[0];
            for(int j=1; j<n; ++j){
                dp[i][j] = Math.max(dp[i][j-1], prices[j]+maxTemp);
                maxTemp = Math.max(maxTemp, dp[i-1][j-1]-prices[j]);
            }
        }
        return dp[k][n-1];
    }

    public int longestOnes(int[] A, int K) {
        if(A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        int[] sum = new int[n+1];
        for(int i=1; i<=n; ++i){
            sum[i] = sum[i-1] + A[i-1];
        }
        int ans = 0;
        for(int i=0; i<=n; ++i){
            for(int j=i+K; j<=n; ++j){
                if((j-i) - (sum[j] - sum[i]) <= K) {
                    ans = Math.max(ans, j-i);
                }
            }
        }
        return ans;
    }

    private void modify(int[] nums, int op, int x) {
        if (op == 0) {
            nums[x]++;
        } else if (op == 1) {
            for (int i=0; i<nums.length; ++i) {
                nums[i] *= 2;
            }
        }
    }
    public int minOperations(int[] nums) {
        int ans = 0;
        int count = 0;
        boolean shouldAddOne = false;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) {
                count++;
            }
            if (nums[i] % 2 != 0) {
                nums[i] -= 1;
                ans++;
            }
            if (nums[i] != 0) {
                nums[i] /= 2;
                shouldAddOne = true;
            }
        }
        if (count == nums.length) {
            return 0;
        }
        if (shouldAddOne) {
            return 1 + ans + minOperations(nums);
        }
        return ans + minOperations(nums);
    }

    public List<Integer> mostVisited(int n, int[] rounds) {
        List<Integer> ans = new ArrayList<>();
        int[] f = new int[n];
        int max = 0;
        for (int i=1; i<rounds.length; ++i) {
            if (rounds[i] < rounds[i-1]) {
                for(int x=rounds[i-1]-1;  x<rounds[i]-1+n; ++x) {
                    f[x % n]++;
                }
            } else {
                for(int x=rounds[i-1]-1;  x<rounds[i]-1; ++x) {
                    f[x]++;
                    max = Math.max(max, f[x]);
                }
            }
        }
        f[rounds[rounds.length-1]-1]++;
        max = Math.max(max, f[rounds[rounds.length-1]-1]);
        for (int i=0; i<n; ++i) {
            if (f[i] == max) {
                ans.add(i + 1);
            }
        }
        return ans;

    }

    public int maxCoins(int[] piles) {
        int n = piles.length;
        int ans = 0;
        Arrays.sort(piles);
        for (int i=n-1; i>n/3-1; i=i-2) {
            ans += piles[i-1];
        }
        return ans;
    }


    public int findLatestStep(int[] arr, int m) {
        int n = arr.length;
        if (n == m) {
            return m;
        }
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        set.add(n+1);
        for (int i=n-1; i>=0; --i) {
            if (set.ceiling(arr[i])-arr[i]-1 == m || arr[i] - set.floor(arr[i]) - 1  == m) {
                return i;
            }
            set.add(arr[i]);
        }
        return -1;
    }

    public String thousandSeparator(int n) {
        String s = String.valueOf(n);
        StringBuilder sb = new StringBuilder();
        int x = s.length() % 3;
        if ( x == 0) {
            x += 3;
        }
        for (int i=0; i<s.length(); ++i) {
            sb.append(s.charAt(i));
            if (i % 3 == x-1) {
                sb.append('.');
            }
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    public int xorOperation(int n, int start) {
        int ans = start;
        for (int i=1; i<n; ++i) {
            ans ^= start + 2 * i;
        }
        return ans;
    }

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> ans =  new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;
        k = k % m*n;
        List<Integer> tmp = new ArrayList<>();
        for (int i=0; i<m*n; ++i) {
            int x = (i - k + m * n) % (m * n);
            tmp.add(grid[x / n][x % n]);
            if (tmp.size() == n) {
                ans.add(tmp);
                tmp = new ArrayList<>();
            }
        }
        return ans;
    }


    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] num = new int[n];
        for (int i=0; i<edges.size(); ++i) {
            num[edges.get(i).get(1)] = 1;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i=0; i<n; ++i) {
            if (num[i] == 0) {
                ans.add(i);
            }
        }
        return ans;
    }

    public int maxSubarraySumCircular(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int totalSum = A[0];
        int maxSum = A[0];
        int minSum = A[0];
        int a = maxSum;
        int b = minSum;
        int n = A.length;
        int negative = 0;
        if (A[0] < 0) {
            negative++;
        }
        for (int i=1; i<n; ++i) {
            if (A[i] < 0) {
                negative++;
            }
            totalSum += A[i];
            if (maxSum > 0){
                maxSum += A[i];
            } else {
                maxSum = A[i];
            }
            if (minSum < 0) {
                minSum += A[i];
            } else {
                minSum = A[i];
            }
            a = Math.max(maxSum, a);
            b = Math.min(minSum, b);
        }
        if (negative == n) {
            return a;
        }
        return Math.max(a, totalSum-b);
    }

    public int longestSubarray(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return 0;
        }
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i=0; i<n; ++i) {
            if (nums[i] == 1) {
                if (i >= 1) {
                    left[i] = left[i-1] + 1;
                } else {
                    left[i] = 1;
                }
            }

            if (nums[n-1-i] == 1) {
                if (n-1-i < n-1) {
                    right[n-1-i] = right[n-i] + 1;
                } else {
                    right[n-1-i] = 1;
                }
            }
        }
        int ans = 0;
        for (int i=1; i<n-1; ++i) {
            ans = Math.max(ans, left[i-1] + right[i+1]);
        }
        return ans;
    }

    public int numOfSubarrays(int[] arr) {
        int n = arr.length;
        int mod = 10^9 + 7;
        int[][] num = new int[n][2];
        num[0][0] = arr[0] % 2 == 1 ? 1 : 0;
        num[0][1] = arr[0] % 2 == 0 ? 1 : 0;
        for (int i=1; i<n; ++i) {
            if (arr[i] % 2 == 0) {
                num[i][0] = num[i-1][0] * 2 % mod;
                num[i][1] = num[i-1][1] * 2 % mod;
            } else {
                num[i][0] = num[i-1][1] * 2 % mod;
                num[i][1] = num[i-1][0] * 2 % mod;
            }
        }
        return num[n-1][0];
    }

    public boolean containsPattern(int[] arr, int m, int k) {
        int n = arr.length;
        if (n < m * k) {
            return false;
        }

        for (int i=0; i<n-m*(k-1); ++i) {
            // i -> i+m-1;
            int c = 1;
            for (int j=i+m; j<=n-m;) {
                int y = 0;
                for (int x=0; x<m; ++x) {
                    if (arr[j+x] == arr[i+x]) {
                        y++;
                    }
                }
                if (y == m) {
                    c++;
                    j = j+m;
                } else {
                    break;
                }
            }
            if (c >= k) {
                return true;
            }
        }
        return false;
    }

    public int getMaxLen(int[] nums) {
        int n = nums.length;
        int[] pos = new int[n];
        int[] neg = new int[n];
        int max = 0;
        for (int i=0; i<n; ++i) {
            if (nums[i] == 0) {
                continue;
            }
            if (nums[i] > 0) {
                pos[i] = i >= 1 ? pos[i-1] + 1 : 1;
                if (i > 0 && neg[i-1] > 0) {
                    neg[i] = neg[i-1] + 1;
                }
                max = Math.max(pos[i], max);
            } else {
                neg[i] = i >= 1 ? pos[i-1] + 1 : 1;
                if (i > 0 && neg[i-1] > 0) {
                    pos[i] = neg[i-1] + 1;
                }
                max = Math.max(pos[i], max);
            }
        }
        return max;
    }


    public int numOfSubarraysOddEven(int[] arr) {
        int n = arr.length;
        long[] odd = new long[n];
        long[] even = new long[n];
        if (arr[0] % 2 == 0) {
            even[0] = 1;
        } else {
            odd[0] = 1;
        }
        long MOD = 10^9 + 7;
        long ans = odd[0];
        for (int i=1; i<n; ++i) {
            if (arr[i] % 2 == 0) {
                even[i] = (even[i-1]  + 1) % MOD;
                odd[i] = odd[i-1]  % MOD;
            } else {
                even[i] = odd[i-1]  % MOD;
                odd[i] = (even[i-1] + 1) % MOD;
            }
            ans += odd[i];
        }
        return (int)ans;
    }

}