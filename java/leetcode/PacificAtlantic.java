//Leetcode problem 417 Pacific Atlantic Water Flow
//Solution written by Xuqiang Fang on 
import java.util.ArrayList;
import java.util.List;
class Solution{
    //solution provided by user@star1993
    public List<int[]> pacificAtlantic(int[][] matrix){
        List<int[]> list = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return list;

        int m = matrix.length; 
        int n = matrix[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for(int i=0; i<m; ++i){
            dfs(matrix, pacific, Integer.MIN_VALUE, i, 0);
            dfs(matrix, atlantic , Integer.MIN_VALUE, i, n-1);
        }

        for(int i=0; i<n; ++i){
            dfs(matrix, pacific, Integer.MIN_VALUE, 0, i);
            dfs(matrix, atlantic , Integer.MIN_VALUE, m-1, i);
        }
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                if(pacific[i][j] && atlantic[i][j]){
                    list.add(new int[]{i,j}); 
                }
            }
        }
        return list;
    }	

    int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

    public void dfs(int[][] matrix, boolean[][] visited, int height, int x, int y){
        int m = matrix.length;
        int n = matrix[0].length;
        if(x <0 || x>=m || y<0 ||y>=n || visited[x][y] || matrix[x][y] < height)
            return;
        visited[x][y] = true;
        for(int[] d : dir){
            dfs(matrix, visited, matrix[x][y], x+d[0], y+d[1]);
        }
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
