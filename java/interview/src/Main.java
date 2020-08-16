import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Map<Long, List<Integer>> map = new HashMap<>();
        int ans = 0;
        while(sc.hasNextLine()){
            String s = sc.nextLine();
            if(s.isEmpty()){
                break;
            }
            long k = process(s);
            if(!map.containsKey(k)){
                map.put(k, new ArrayList<>());
            }
            List<Integer> list = map.get(k);
            list.add(Integer.parseInt(s.substring(20)));
        }
        ans += map.size();
        for(long l : map.keySet()){
            List<Integer> list = map.get(l);
            list.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            for(int i=1; i<list.size(); ++i){
                if(list.get(i).equals(list.get(0))){
                    ans ++;
                }
            }
        }
        System.out.println(ans);
    }


    public static long process(String s){
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
        ans += day * 24 * 3600;
        ans += hour * 3600;
        ans += minute * 60;
        ans += second;
        return ans;
    }


    /*
    private static void printArray(int[] a) {
        for(int i=0; i<a.length; ++i) {
            System.out.println(a[i]);
        }
    }

    public static void process(long n){
        for(long i=2; i<=n; ++i){
            if(isPrime(i) && n % i ==0){
                System.out.print(i);
                System.out.print("A");
                process(n/i);
                return;
            }
        }
    }

    public static boolean isPrime(long n){
        if(n == 2){
            return true;
        }
        for(int i=2; i<=Math.sqrt(n); ++i){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void process1(String s){
        if(s.isEmpty()){
            return;
        }
        int i = 0;
        while((i+1)*8 < s.length()){
            System.out.println(s.substring(i*8, (i+1)*8));
            i++;
        }
        StringBuilder sb = new StringBuilder();
        for(int x=i*8; x<i*8+8; ++x){
            if(x < s.length()){
                sb.append(s.charAt(x));
            } else {
                sb.append('0');
            }
        }
        System.out.println(sb.toString());
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }




     */



    /*
    public static void main(String[] args) {

        Scanner keyin = new Scanner(System.in);
        while(keyin.hasNextLine()){
            String s = keyin.nextLine();
            String[] ans = s.split("\\.");
            if(ans.length == 0){
                System.out.println(Long.parseLong(s));
            }
            else if(ans.length == 1){
                System.out.print(Long.parseLong(ans[0]));
            } else if(ans.length == 2){
                if(ans[1].charAt(0) >= '5'){
                    System.out.println(Long.parseLong(ans[0])+1);
                } else {
                    System.out.println(Long.parseLong(ans[0]));
                }
            }
        }
        System.out.println(Now.hexToInt("0xA"));
        /*

        Scanner keyin = new Scanner(System.in);
        int N = Integer.parseInt(keyin.nextLine());
        int[] a = new int[N];
        for(int i=0; i<N; ++i){
            a[i] = Integer.parseInt(keyin.nextLine());
        }
        Arrays.sort(a);
        if(a.length == 0){
            return;
        }
        System.out.println(a[0]);
        for(int i=1; i<N; ++i){
            if(a[i] != a[i-1]){
                System.out.println(a[i]);
            }
        }


        /*
        List<Integer> list = Arrays.asList(1,2,3,4,5, null, null,8);
        list = Arrays.asList(1,2,3,4,5,null,6,7,null,null,null,null,8);
        Tree tree = new Tree();
        Tree.TreeNode head = tree.constructTree(list);
        System.out.println(tree.deepestLeavesSum(head));
        List<Integer> temp = new ArrayList<>();
        tree.preorder(temp, head);
        System.out.print(temp);
        System.out.println("\nFinished");
        list = Arrays.asList(6,1,12,0,3,10,13,null,null,null,null,4,14,20,16,2,5,11,15);
        head = tree.constructTree(list);
        System.out.print(tree.bstTopo(head));
        System.out.println("\nFinished");
        temp.clear();
        tree.preorder(temp, head);
        */

        /*
        System.out.println(s.findKthBit(19,11));
        System.out.println(s.maxNonOverlapping(new int[]{-2,6,6,3,5,4,1,2,10}, 10));
        System.out.println(s.maxNonOverlapping(new int[]{0,0,0}, 0));
        System.out.println(s.maxNonOverlapping(new int[]{-1,3,5,1,4,2,-9}, 6));
        System.out.println(s.restoreString("codeleet", new int[]{4,5,6,7,0,2,1,3}));
        System.out.println(s.numIdenticalPairs(new int[]{1,2,3,1,1,3}));
        System.out.println(s.reformatDate("20th Oct 2052"));
        System.out.println(s.reformatDate("31st Dec 2042"));
        System.out.println(s.isPathCrossing("NNSWWEWSSESSWENNW"));
        System.out.println(s.isPathCrossing("NESWW"));
        printArray(s.smallerNumbersThanCurrent(new int[]{8,1,2,2,3}));
        System.out.println(s.buildArray(new int[]{1,3}, 3));
        System.out.println(s.buildArray(new int[]{1,2,3}, 3));
        System.out.println(s.buildArray(new int[]{2,3,4,5,8,9,10},10));
        System.out.println(s.sortString("leetcode"));
        System.out.println(s.sortString("aaaabbbbcccc"));
        System.out.println(s.daysBetweenDates("2074-09-12","1983-01-08")); //33485
        System.out.println(s.daysBetweenDates("1971-06-29","2010-09-23")); //14331
        printArray(s.sortByBits(new int[]{1024,512,256,128,64,32,16,8,4,2,1}));

        int[][] grid = new int[][]{{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
        grid = new int[][]{{1,-1},{-1,-1}};
        grid = new int[][]{{-1}};
        System.out.println(s.countNegatives(grid));

        System.out.println(s.removePalindromeSub("ababa"));
        printArray(s.arrayRankTransform(new int[]{40,10,20,30}));

        printArray(s.arrayRankTransform(new int[]{37,12,28,9,100,56,80,5,12}));

        System.out.println(s.checkIfExist(new int[]{10,2,5,3}));
        System.out.println(s.freqAlphabets("10#11#12"));
        System.out.println(s.balancedStringSplit("RLRRRLLRLL"));

        Liss l= new Liss();
        int x = 6;
        //System.out.println(l.leftIndex(new int[]{1,2,2,6,6,6,6,7,10}, x));
        //System.out.println(l.rightIndex(new int[]{1,2,2,6,6,6,6,7,10}, x));
        //System.out.println(l.findSpecialInteger(new int[]{1,2,2,6,6,6,6,7,10}));
        System.out.println(l.leftIndex(new int[]{1,2,3,3},3));
        System.out.println(l.findSpecialInteger(new int[]{1,2,3,3}));

        System.out.println(s.subtractProductAndSum(100));

        printArray(s.relativeSortArray(new int[]{2,3,1,3,2,4,6,7,9,2,19}, new int[]{2,1,4,3,9,6}));

        System.out.println(s.minimumAbsDifference(new int[]{4,2,1,3}));
        System.out.println(s.minimumAbsDifference(new int[]{1,3,6,10,15}));
        System.out.println(s.maxScore("011101"));
        System.out.println(s.maxScore("00"));

        StringBuilder sb = new StringBuilder();
        sb.insert(0, 'a');
        sb.insert(0, 'b');
        sb.insert(0, 'c');
        System.out.println(sb.toString());
        */

        /*
        Book b = new Book();
        System.out.println(b.maxRectangle(new int[]{3,4,5,3,6}));
        char[][] matrix=new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}};
        System.out.println(b.maxAreaChar(matrix));

        System.out.println(s.minInsertions("())))"));
        System.out.println(s.minInsertions("))())("));
        System.out.println(s.minInsertions(")))))))"));
        System.out.println(s.minInsertions("(((((((((("));
        System.out.println(s.minInsertions(")()()()()()()"));

        //System.out.println(s.numSplits("acbadbaada"));
        //System.out.println(s.numSplits("aaaaa"));
        System.out.println(s.longestAwesomeExceedTimeLimit("3242415"));
        Map<Integer, Integer> odd = new HashMap<>();
        Map<Integer, Integer> even = new HashMap<>();
        System.out.println(s.isPalindrome(odd, even, 4, 1));
        System.out.println(s.isPalindrome(odd, even, 5, 1));
        System.out.println(s.isPalindrome(odd, even, 7, 1));
        System.out.println(s.isPalindrome(odd, even, 5, -1));
        */

}
