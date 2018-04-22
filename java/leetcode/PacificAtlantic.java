//Leetcode problem 417 Pacific Atlantic Water Flow
//Solution written by Xuqiang Fang on 
import java.util.ArrayList;
import java.util.List;
class Solution{
    public List<int[]> pacificAtlantic(int[][] matrix){
        List<int[]> list = new ArrayList<>();
        return list;
    }	
}

public class PacificAtlantic{
	public static void main(String[] args){
		Solution s = new Solution();
        int[][] matrix = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        List<int[]> list = s.pacificAtlantic(matrix);
        for(int[] i : list){
            System.out.println(i[0] + " " + i[1]);
        }
	}
}
