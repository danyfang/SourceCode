//Leetcode problem 529 Minesweeper
//Solution written by Xuqiang Fang on 23 May, 2018
/**
The tricky part for this question is that if we use dfs, we should not label it with digit if we encounter an 'E'
with at least one adjacnet mine.

Actually my initial idea led to the situation above, if we search all 8 neighbors, we would be fine
*/
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
class Solution{
    public char[][] updateBoard(char[][] board, int[] click) {
        dfs(board, board.length, board[0].length, click[0], click[1]);
        return board;
    }

    private void dfs(char[][] board, int m, int n, int x, int y){
        if(x < 0 || x >= m || y < 0 || y >= n || board[x][y] == 'B' || Character.isDigit(board[x][y])){
            return;
        }
        else if(board[x][y] == 'M'){
            board[x][y] = 'X';
            return;
        }
        else if(board[x][y] == 'E'){
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{x,y});
            while(!queue.isEmpty()){
                int size = queue.size();
                while(size-- > 0){
                    int[] a = queue.poll();
                    if(count(board,m,n,a[0],a[1]) == 0){
                        board[a[0]][a[1]] = 'B';
                        dfs(board, m, n, a[0]-1, a[1]);
                        dfs(board, m, n, a[0]+1, a[1]);
                        dfs(board, m, n, a[0], a[1]-1);
                        dfs(board, m, n, a[0], a[1]+1);
                        if(a[1]-1 >= 0 && board[a[0]][a[1]-1] == 'E'){
                            queue.offer(new int[]{a[0], a[1]-1});
                        }
                        if(a[1]+1 < n && board[a[0]][a[1]+1] == 'E'){
                            queue.offer(new int[]{a[0], a[1]+1});
                        }
                        if(a[0]-1 >= 0){
                            if(board[a[0]-1][a[1]] == 'E'){
                                queue.offer(new int[]{a[0]-1, a[1]}); 
                            }
                            if(a[1]-1 >= 0){
                                if(board[a[0]-1][a[1]-1] == 'E'){
                                    queue.offer(new int[]{a[0]-1, a[1]-1});
                                }
                            }
                            if(a[1]+1 < n){
                                if(board[a[0]-1][a[1]+1] == 'E'){
                                    queue.offer(new int[]{a[0]-1, a[1]+1});
                                }
                            }
                        }
                        if(a[0]+1 < m){
                            if(board[a[0]+1][a[1]] == 'E'){
                                queue.offer(new int[]{a[0]+1, a[1]});
                            }
                            if(a[1]-1 >= 0 && board[a[0]+1][a[1]-1] == 'E'){
                                queue.offer(new int[]{a[0]+1, a[1]-1}); 
                            }
                            if(a[1]+1 < n && board[a[0]+1][a[1]+1] == 'E'){
                                queue.offer(new int[]{a[0]+1, a[1]+1});
                            }
                        }
                    }
                    else{
                        char c = (char)('0' + count(board, m, n, a[0], a[1]));
                        board[a[0]][a[1]] = c;
                    }
                }
            }
        } 
    }

    private int count(char[][] board, int m, int n, int x, int y){
        int c = 0;
        if(y-1 >= 0 && board[x][y-1] == 'M'){
            c++; 
        }
        if(y+1 < n && board[x][y+1] == 'M'){
            c++; 
        }
        if(x-1 >= 0){
            if(board[x-1][y] == 'M'){
                c++;
            }
            if(y-1 >= 0 ){
                if(board[x-1][y-1] == 'M'){
                    c++;
                }
            }
            if(y+1 < n ){
                if( board[x-1][y+1] == 'M'){
                    c++;
                }
            }
        }
        if(x+1 < m){
            if(board[x+1][y] == 'M'){
                c++;
            }
            if(y-1 >= 0 && board[x+1][y-1] == 'M'){
                c++;
            }
            if(y+1 < n && board[x+1][y+1] == 'M'){
                c++;
            }
        }
        return c;
    }

    // 
    public char[][] update(char[][] board, int[] click){
        int m = board.length;
        int n = board[0].length;
        dfs_(board, m, n, click[0], click[1]);
        return board;
    }

    private void dfs_(char[][] board, int m, int n, int x, int y){
        if(x<0 || x>=m || y<0 || y>=n || board[x][y] == 'B' || Character.isDigit(board[x][y])){
            return;
        }
        if(board[x][y] == 'M'){
            board[x][y] = 'X';
            return;
        }
        int count = 0;
        for(int a=-1; a<=1; ++a){
            for(int b=-1; b<=1; ++b){
                int k = x+a;
                int l = y+b;
                if(k<0 || k>=m || l<0 ||l>=n || (a==0 && b==0)){
                    continue;
                }
                else if(board[k][l] == 'M'){
                    count++;
                }
            }
        }
        if(count == 0){
            board[x][y] = 'B';
            dfs_(board, m, n, x-1, y);
            dfs_(board, m, n, x+1, y);
            dfs_(board, m, n, x, y-1);
            dfs_(board, m, n, x, y+1);
            dfs_(board, m, n, x-1, y-1);
            dfs_(board, m, n, x-1, y+1);
            dfs_(board, m, n, x+1, y+1);
            dfs_(board, m, n, x+1, y-1);
        }
        else{
            board[x][y] = (char)(count+'0');
        }
    }

}

public class Minesweeper{
	public static void main(String[] args){
		Solution s = new Solution();
        /**
        char[][] board = {{'E','E','E','E','E'},{'E','E','M','E','E'},
                          {'E','E','E','E','E'},{'E','E','E','E','E'}};
        */
        char[][] board = {{'E','E','E','E','E','E','E','E'},
                          {'E','E','E','E','E','E','E','M'},
                          {'E','E','M','E','E','E','E','E'},
                          {'M','E','E','E','E','E','E','E'},
                          {'E','E','E','E','E','E','E','E'},
                          {'E','E','E','E','E','E','E','E'},
                          {'E','E','E','E','E','E','E','E'},
                          {'E','E','M','M','E','E','E','E'}};
                          /**answer
                          {'B','B','B','B','B','B','1','E'}, 
                          {'B','1','1','1','B','B','1','M'},
                          {'1','2','M','1','B','B','1','1'}, 
                          {'M','2','1','1','B','B','B','B'},
                          {'1','1','B','B','B','B','B','B'},
                          {'B','B','B','B','B','B','B','B'},
                          {'B','1','2','2','1','B','B','B'}, 
                          {'B','1','M','M','1','B','B','B'} 
                          */
        int[] click = {0,0};
        for(int i=0; i<board.length; ++i){
            for(int j=0; j<board[0].length; ++j){
                System.out.print(board[i][j] + "\t");
            }
            System.out.println("\n");
        }

        //s.updateBoard(board, click);
        s.update(board, click);
        System.out.println("********************");
        for(int i=0; i<board.length; ++i){
            for(int j=0; j<board[0].length; ++j){
                System.out.print(board[i][j] + "\t");
            }
            System.out.println("\n");
        }
	}
}
