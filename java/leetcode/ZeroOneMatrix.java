//Leetcode problem 542 01 Matrix
//Solution written by Xuqiang Fang on 4 May, 2018
class Solution{
    private int width = 10000;
    public int[][] updateMatrix(int[][] matrix){
        //if visited, we store the distance as the inverse of itself 
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return matrix;
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                matrix[i][j] = -dfs(matrix, i, j);
            }
        }
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                matrix[i][j] = - matrix[i][j];
            }
        }
        return matrix;
    }

    private int dfs(int[][] matrix, int i, int j){
        if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length)
            return width;
        else if(matrix[i][j] == 0)
            return 0;
        else if(matrix[i][j] < 0)
            return -matrix[i][j];
        
        matrix[i][j] = -width;
        int left = dfs(matrix, i-1, j);
        int right = dfs(matrix, i+1, j);
        int up = dfs(matrix, i, j+1);
        int down = dfs(matrix, i, j-1);
        matrix[i][j] = 1 + Math.min(Math.min(left, right), Math.min(up, down));
        return 1 + Math.min(Math.min(left, right), Math.min(up, down));
    }

    
    //Solution provided by user@Anderson_Hou
    public int[][] update(int[][] matrix) {
        if(matrix.length==0) return matrix;
        
        for(int i = 0; i<matrix.length; i++)
            for(int j = 0; j<matrix[0].length; j++)
                if(matrix[i][j]==1&&!hasNeiberZero(i, j,matrix)) 
                    matrix[i][j] = matrix.length+matrix[0].length+1;
        
        for(int i = 0; i<matrix.length; i++)
            for(int j = 0; j<matrix[0].length; j++)
                if(matrix[i][j]==1)
                    dfs(matrix, i, j, -1);
        
        return matrix;
    }
    private void dfs(int[][] matrix, int x, int y, int val){
        if(x<0||y<0||y>=matrix[0].length||x>=matrix.length||matrix[x][y]<=val)
            return;
        
        if(val>0) matrix[x][y] = val;
        
        dfs(matrix, x+1, y, matrix[x][y]+1);
        dfs(matrix, x-1, y, matrix[x][y]+1);
        dfs(matrix, x, y+1, matrix[x][y]+1);
        dfs(matrix, x, y-1, matrix[x][y]+1);
        
    }
    private boolean hasNeiberZero(int x, int y, int[][] matrix){
        if(x>0&&matrix[x-1][y]==0) return true;
        if(x<matrix.length-1&&matrix[x+1][y]==0) return true;
        if(y>0&&matrix[x][y-1]==0) return true;
        if(y<matrix[0].length-1&&matrix[x][y+1]==0) return true;
        
        return false;
    }
}

public class ZeroOneMatrix{
	public static void main(String[] args){
		Solution s = new Solution();

        int[][] matrix = {{1,1,1,1,1},{1,1,1,1,1},{1,0,1,1,1},{1,1,1,1,1},{1,1,1,1,1}};
        print(matrix);
        System.out.println("****************************************");
        matrix = s.updateMatrix(matrix); 
        print(matrix);
	}
    public static void print(int[][] matrix){
        for(int[] i : matrix){
            for(int j : i){
                System.out.print(j + "\t");
            }
            System.out.println("\n");
        }
    }
}
