//Leetcode problem 881 Random Flip Matrix
//Solution written by Xuqiang Fang on 28 July, 2018
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Random;
//the first solution MLE
class Solution_1{
    Random r;
    List<List<Integer>> matrix;
    int R;
    int C;
    public Solution_1(int n_rows, int n_cols) {
        r = new Random(); 
        R = n_rows;
        C = n_cols;
        List<Integer> tmp = new ArrayList<>();
        for(int i=0; i<n_cols; ++i){
            tmp.add(i);
        }
        matrix = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(n_rows);
        matrix.add(first);
        for(int i=0; i<n_rows; ++i){
            List<Integer> col = new ArrayList<>();
            col.add(i);
            col.add(n_cols);
            col.addAll(tmp);
            matrix.add(col);
        }
        //System.out.println("row" + matrix.get(0).get(0));
        //System.out.println("col" + matrix.get(1).get(1));
        //System.out.println("col" + matrix.get(1).get(0));
    }
    
    public int[] flip() {
        int row = r.nextInt(matrix.get(0).get(0))+1;
        int size = matrix.get(row).get(1);
        int col = r.nextInt(size)+2;
        int[] ans = {matrix.get(row).get(0), matrix.get(row).get(col)}; 
        int t = matrix.get(row).get(col);
        //System.out.println("row = " + row);
        matrix.get(row).remove(col);
        matrix.get(row).add(t);
        matrix.get(row).set(1,size-1);
        //System.out.println(matrix.get(row).get(1));
        if(matrix.get(row).get(1) == 0){
            //System.out.println("here");
            List<Integer> tmp = matrix.get(row);
            matrix.remove(row);
            matrix.add(tmp);
            matrix.get(0).set(0, matrix.get(0).get(0)-1);
        }
        //System.out.println("row" + matrix.get(0).get(0));
        //System.out.println("col" + matrix.get(1).get(1));
        return ans;
    }
    
    public void reset(){
        //System.out.println("row" + matrix.get(0).get(0));
        //System.out.println("col" + matrix.get(1).get(1));
        int size = matrix.get(0).get(0);
        for(int i=size; i<R; ++i){
            matrix.get(i+1).set(1, C); 
        }
        matrix.get(0).set(0, R);
        //System.out.println("reset complete");
    }
}
class Solution_2{
    List<String> pick;
    Random r;
    List<String> used;
    public Solution_2(int n_rows, int n_cols) {
        pick = new ArrayList<>();
        used = new ArrayList<>();
        for(int i=0; i<n_rows; ++i){
            for(int j=0; j<n_cols; ++j){
                pick.add(i + "," + j);
            }
        }
        r = new Random();
    }
    
    public int[] flip() {
        int key = r.nextInt(pick.size()); 
        String s = pick.get(key);
        pick.remove(key);
        used.add(s);
        String[] num = s.split(",");
        return new int[]{Integer.parseInt(num[0]), Integer.parseInt(num[1])};
    }
    
    public void reset() {
        pick.addAll(used); 
        used.clear();
    }
}
// we don't need to store the actual array, just keep an integer of the count
class Solution{
    Random r;
    int Size;
    int Row;
    int Col;
    Map<Integer, Integer> map;
    public Solution(int n_rows, int n_cols) {
        Size = n_rows * n_cols;
        r = new Random();
        Row = n_rows;
        Col = n_cols;
        map = new HashMap<>();
    }
    
    public int[] flip() {
        int key = r.nextInt(Size); 
        int ans = key;
        if(map.containsKey(key)){
            ans = map.get(key);
        }
        Size--;
        if(!map.containsKey(Size)){
            map.put(key, Size);
        }
        else{
            map.put(key, map.get(Size));
        }
        return new int[]{ans / Col, ans % Col};
    }
    
    public void reset() {
        Size = Row * Col;
        map.clear();
    }
}
public class RandomFlip{
	public static void main(String[] args){
		Solution s = new Solution(1,2);
        int[] ans = s.flip();
        System.out.println(ans[0] + ", " + ans[1]); 
        ans = s.flip();
        System.out.println(ans[0] + ", " + ans[1]); 
        s.reset();
        ans = s.flip();
        System.out.println(ans[0] + ", " + ans[1]); 
        ans = s.flip();
        System.out.println(ans[0] + ", " + ans[1]); 
	}
}
