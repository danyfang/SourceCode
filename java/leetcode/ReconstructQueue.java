//Leetcode problem 406 Queue Reconstruction by Height
//Solution written by Xuqiang Fang on 21 April, 2018 
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

class Solution{
    public int[][] reconstructQueue(int[][] people){
        if(people == null || people.length == 0)
            return people;
        Arrays.sort(people, new queue());
        LinkedList<int[]> result = new LinkedList<>();
        for(int[] p : people){
            if(p[0] != people[0][0]){
                result.add(p[1], p); 
            }
            else{
                result.add(p);
            }
        }
        for(int i=0; i<people.length; ++i){
            people[i] = result.get(i);
        }
        return people; 
    }	
    class queue implements Comparator<int[]>{
        @Override
        public int compare(int[] a, int[] b){
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return b[0] - a[0];
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
