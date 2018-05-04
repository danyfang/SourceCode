//Leetcode problem 547 Friend Circles
//Solution written by Xuqiang Fang on 4 May, 2018 
class Solution{
    public int findCircleNum(int[][] M){
        int N = M.length;
        int count = 0;
        for(int i=0; i<N; ++i){
            if(M[i][i] == 1){
                count++;
                set(M, i);
            }
        }
        return count;
    }
    private void set(int[][] M, int i){
        M[i][i] = 0;
        for(int j=0; j<M.length; ++j){
            if(M[i][j] == 1){
                System.out.println("("+i+","+i+")" + "is friend with" + "("+ i + "," + j+")");
                M[i][j] = 0;
                M[j][i] = 0;
                set(M, j); 
            }
        }
    }
}

public class FriendCircles{
	public static void main(String[] args){
		Solution s = new Solution();
        int[][] M = {{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
        for(int[] N : M){
            for(int i : N)
                System.out.print(i + "\t");
            System.out.println("\n");
        }
        System.out.println("********************");
        System.out.println(s.findCircleNum(M));
        for(int[] N : M){
            for(int i : N)
                System.out.print(i + "\t");
            System.out.println("\n");
        }
	}
}
