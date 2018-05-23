//Leetcode problem 773 Sliding Puzzle
//Solution written by Xuqiang Fang on 21 May, 2018 
import java.util.HashSet;
import java.util.Set;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
class Solution{
    public int slidingPuzzle(int[][] board) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<board.length; ++i){
            for(int j=0; j<board[0].length; ++j){
                sb.append(board[i][j]);
            }
        }

        Map<Integer, List<Integer>> move = new HashMap<>();
        move.put(0, Arrays.asList(1,3));
        move.put(1, Arrays.asList(0,2,4));
        move.put(2, Arrays.asList(1,5));
        move.put(3, Arrays.asList(0,4));
        move.put(4, Arrays.asList(1,3,5));
        move.put(5, Arrays.asList(2,4));

        String result = "123450";
        if(sb.toString().equals(result)){
            return 0;
        }
        queue.offer(sb.toString());
        visited.add(sb.toString());
        
        int steps = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            steps++;
            while(size-- > 0){
                 StringBuilder temp = new StringBuilder(queue.poll());
                 int index = temp.indexOf("0");
                 //System.out.println(temp.toString());
                 for(int j : move.get(index)){
                    swap(temp, index, j);
                    if(temp.toString().equals(result)){
                        return steps;
                    }
                    if(visited.contains(temp.toString())){
                        swap(temp, j, index);
                        continue;
                    }
                    visited.add(temp.toString());
                    queue.offer(temp.toString());
                    swap(temp, j, index);
                 }
            }
        }

        return -1;
    }

    private void swap(StringBuilder sb, int i, int j){
        char c = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j,c);
    }
}

public class SlidingPuzzle{
	public static void main(String[] args){
		Solution s = new Solution();
        int[][] board = {{3,2,4},{1,5,0}};
        int[][] board2 = {{1,2,3},{4,0,5}};
        int[][] board3 = {{4,1,2},{5,0,3}};
        int[][] board4 = {{1,2,3},{5,4,0}};
        System.out.println(s.slidingPuzzle(board));
        System.out.println(s.slidingPuzzle(board2));
        System.out.println(s.slidingPuzzle(board3));
        System.out.println(s.slidingPuzzle(board4));
	}
}
