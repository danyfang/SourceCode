import javafx.util.Pair;

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


    // Leetcode medium level
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
}