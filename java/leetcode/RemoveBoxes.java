//Leetcode problem 546 Remove Boxes
//Solution written by Xuqiang Fang on 26 July, 2018
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
class Solution{
    public int removeBoxes_(int[] boxes) {
        List<Integer> box = new ArrayList<>();
        for(int b : boxes){
            box.add(b);
        }
        Map<String, Integer> map = new HashMap<>();
        return helper(box, map); 
    }
    public int helper(List<Integer> box, Map<String, Integer> map){
        if(box.size() == 0){
            return 0;
        }
        String key = getKey(box);
        System.out.println(key);
        int n = box.size();
        if(!map.containsKey(key)){
            int curr = 0;
            int max = 0;
            while(curr < n){
                int i = curr;
                while(i < n && box.get(i) == box.get(curr)){
                    i++;
                }
                if(curr == 0 && i == n){
                    //System.out.println("here");
                    map.put(key, n * n);
                    return map.get(key);
                }
                List<Integer> next = new ArrayList<>();
                if(curr > 0){
                    next.addAll(box.subList(0, curr));
                }
                if(i < n){
                    next.addAll(box.subList(i, n));
                }
                max = Math.max(max, (n-next.size()) * (n-next.size()) + helper(next, map)); 
                curr = i;
            }
            map.put(key, max);
            return max;
        }
        return map.get(key);
    }
    private String getKey(List<Integer> box){
        StringBuilder sb = new StringBuilder();
        for(int b : box){
            sb.append(b);
        }
        return sb.toString();
    }

    public int removeBoxes(int[] boxes){
        int n = boxes.length;
        int[][][] mem = new int[100][100][100];
        return dfs(boxes, mem, 0, n-1, 0);
    }
    private int dfs(int[] boxes, int[][][] mem, int l, int r, int k){
        if(l > r){
            return 0;
        }
        if(mem[l][r][k] != 0){
            return mem[l][r][k];
        }
        while(r > l && boxes[r] == boxes[r-1]){
            r--;
            k++;
        }
        mem[l][r][k] = dfs(boxes, mem, l, r-1, 0) + (k+1)*(k+1);
        for(int i=l; i<r; ++i){
            if(boxes[i] == boxes[r]){
                mem[l][r][k] = Math.max(mem[l][r][k], dfs(boxes, mem, l, i, k+1) + dfs(boxes, mem, i+1, r-1, 0));
            }
        }
        return mem[l][r][k];
    }
}

public class RemoveBoxes{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] boxes = {1, 3, 2, 2, 2, 3, 4, 3, 1};
        System.out.println(s.removeBoxes(boxes));
        boxes = new int[]{1,1,1};
        System.out.println(s.removeBoxes(boxes));
        boxes = new int[]{3,8,8,5,5,3,9,2,4,4,6,5,8,4,8,6,9,6,2,8,6,4,1,9,5,3,10,5 ,3,3,9,8,8,6,5,3,7,4,9,6,3,9,4,3,5,10,7,6,10,7};
        System.out.println(s.removeBoxes(boxes));
	}
}
