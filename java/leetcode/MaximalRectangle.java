//Leetcode problem 85 Maximal Rectangle
//Solution written by Xuqiang Fang on 27 March 2018 
//Solution by use@hidro
import java.util.Arrays;
class Solution{
	public int maximalRectangle(char[][] matrix){
		if(matrix == null || matrix.length ==0 || matrix[0].length == 0)
			return 0;
		int row = matrix.length;
		int col = matrix[0].length;

		int[] left = new int[col], right = new int[col], top = new int[col];
		Arrays.fill(left, col);
		Arrays.fill(right, col);
		Arrays.fill(top, 0);
		int max = 0;
		for(int y=0; y<row; y++){
			for(int x=0; x<col; x++){
				if (matrix[y][x] == '1'){
					//System.out.println( y + " " + x);
					top[x] += 1;
				}
				else
					top[x] = 0;
			}	
			/*
			for(int x=0; x<col; x++){
				System.out.print(top[x]);
			}
			*/
			int l = 0;
			for(int x=0; x<col; x++){
				if(matrix[y][x] == '1')
					left[x] = Math.min(left[x], ++l);
				else{
					left[x] = col;
					l = 0;
				}
			}
			for(int x=0; x<col; x++){
				System.out.print(left[x] + "\t");
			}

			int r = 0;
			for(int x=col-1; x>=0; x--){
				if(matrix[y][x] == '1')
					right[x] = Math.min(right[x], ++r);
				else{
					right[x] = col;
					r = 0;
				}
			}
			for(int x=col-1; x>=0; --x){
				System.out.print(right[x] + "\t");
			}
            
			for(int x=0; x<col; x++){
				if(matrix[y][x] == '1')
                    System.out.println("y = " + y + " x = " + x + " s = " + ((left[x]+right[x]-1)*top[x]));
					max = Math.max(max, (left[x]+right[x]-1)*top[x]);
			}
		}
		return max;
	}	
}

public class MaximalRectangle{
	public static void main(String[] args){
		Solution s = new Solution();
		char[][] matrix = { {'0','0','0','1','0','0','0'},
                            {'0','0','1','1','1','0','0'},
                            {'0','1','1','1','1','1','0'}};
		/*
		for(int x=0; x<matrix.length; x++){
			for(int y=0; y<matrix[0].length; y++){
				System.out.println(matrix[x][y]);
				if(matrix[x][y] == '1')
					System.out.println(x + " " + y);
			}
		}
		*/	
		System.out.println(s.maximalRectangle(matrix));
		}
}
