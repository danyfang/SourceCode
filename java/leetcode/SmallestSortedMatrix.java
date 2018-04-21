//Leetcode problem 378 Kth Smallest Element in a Sorted Matrix
//Solution written by Xuqiang Fang on 19 April, 2018 

class Solution{
    public int kthSmallest(int[][] matrix, int k){
        //k is always valid 1 <= k <= n^2
        int[] a = matrix[0];
        for(int i=1; i<matrix.length; i++){
            a = merge(a, matrix[i]);
            for(int j : a)
                System.out.print(j + "\t");
        }

        return a[k-1];
    }	
    private int[] merge(int[] a, int[] b){
        int[] result = new int[a.length+b.length];
        int index_a = 0;
        int index_b = 0;
        int index = 0;
        while(index_a < a.length || index_b < b.length){
            if(index_a == a.length){
                while(index_b < b.length)
                    result[index++] = b[index_b++];
            }
            else if(index_b == b.length){
                while(index_a < a.length)
                    result[index++] = a[index_a++];
            }
            else if(a[index_a] < b[index_b]){
                result[index++] = a[index_a++]; 
            }
            else{
                result[index++] = b[index_b++];
            }
        }
        return result;
    }
}

public class SmallestSortedMatrix{
	public static void main(String[] args){
		Solution s = new Solution();
        int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
        System.out.println(s.kthSmallest(matrix, Integer.valueOf(args[0])));
	}
}
