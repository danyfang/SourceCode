import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static void printArray(int[] a) {
        for(int i=0; i<a.length; ++i) {
            System.out.println(a[i]);
        }
    }
    public static void main(String[] args) {


        List<Integer> list = Arrays.asList(1,2,3,4,5, null, null,8);
        list = Arrays.asList(1,2,3,4,5,null,6,7,null,null,null,null,8);
        Tree tree = new Tree();
        Tree.TreeNode head = tree.constructTree(list);
        System.out.println(tree.deepestLeavesSum(head));
        /*
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

        Leet s = new Leet();
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

        */
    }

}
