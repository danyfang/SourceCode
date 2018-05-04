//Leetcode problem 733 Flood Fill
//Solution written by Xuqiang Fang on 4 May, 2018
class Solution{
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor){
        if(image[sr][sc] == newColor)
            return image;
        dfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
    private void dfs(int[][] image, int i, int j, int oldColor, int newColor){
        if(i<0 || i>=image.length || j<0 || j>=image[0].length)
            return;
        else if(image[i][j] == oldColor){
            image[i][j] = newColor;
            dfs(image, i-1, j, oldColor, newColor);
            dfs(image, i+1, j, oldColor, newColor);
            dfs(image, i, j-1, oldColor, newColor);
            dfs(image, i, j+1, oldColor, newColor);
        }
    }
}

public class FloodFill{
	public static void main(String[] args){
		Solution s = new Solution();
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        for(int[] i : image){
            for(int j : i){
                System.out.print(j + "\t");
            }
            System.out.println("\n");
        }

        System.out.println("**********");
        image = s.floodFill(image, 1,1, 2);
        for(int[] i : image){
            for(int j : i){
                System.out.print(j + "\t");
            }
            System.out.println("\n");
        }
	}
}
