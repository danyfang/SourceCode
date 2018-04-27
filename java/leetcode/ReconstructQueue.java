//Leetcode problem 406 Queue Reconstruction by Height
//Solution written by Xuqiang Fang on 21 April, 2018 
import java.util.Arrays;
import java.util.Comparator;

class Solution{
    public int[][] reconstructQueue(int[][] people){
        if(people == null || people.length == 0)
            return people;
        Arrays.sort(people, new queue());
        return people; 
    }	
    class queue implements Comparator<int[]>{
        @Override
        public int compare(int[] a, int[] b){
            if(a[1] == b[1]){
                return a[0] - b[0];
            }
            return a[1] - b[1];
        }
    }

}

public class ReconstructQueue{
	public static void main(String[] args){
		Solution s = new Solution();
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        int[][] result = s.reconstructQueue(people);
        for(int[] r : result){
            System.out.print("[");
            System.out.print(r[0]);
            System.out.print(",");
            System.out.print(r[1]);
            System.out.print("]");
            System.out.print(",\t");
        }
        System.out.println("[0,0]");
	}
}
