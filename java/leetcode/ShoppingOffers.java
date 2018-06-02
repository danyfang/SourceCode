//Leetcode problem 638 Shopping Offers
//Solution written by Xuqiang Fang on 1 June, 2018
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
    //This solution is wrong, but passed 53/55 test cases, needs to debug
    public int shoppingOffers_(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int[] p = new int[price.size()];
        int[] n = new int[needs.size()];
        for(int i=0; i<p.length; ++i){
            p[i] = price.get(i);
            n[i] = needs.get(i);
            min += p[i] * n[i];
            max = Math.max(max, n[i]);
        }
        int[][] s = new int[special.size()][p.length+1];
        for(int i=0; i<special.size(); ++i){
            for(int j=0; j<special.get(i).size(); ++j){
                s[i][j] = special.get(i).get(j);
            }
        }

        int[] u = new int[s.length];//each special can be used at most u[i] times
        calculate(s, u, n);
        int[] c = new int[s.length];//record current usage of each special
        /*
        for(int i : u){
            System.out.print(i + "\t");
        }
        */
        dfs(s, p, n, u, c, 0);
        return min;
    }
    private void dfs(int[][] s, int[] p, int[] n, int[] u, int[] c, int x){
        int sum = 0;
        int[] m = new int[n.length];// with all the special offers used in c, current number for each item
        for(int i=0; i<m.length; ++i){
            for(int j=0; j<c.length; ++j){
                m[i] += c[j] * s[j][i];
                if(m[i] > n[i] || c[j] > u[j]){
                    return;
                }
            }
            sum += p[i] * (n[i]-m[i]);
        }
        System.out.println(sum);
        for(int j=0; j<c.length; ++j){
            sum += c[j] * s[j][m.length];
        }
        min = Math.min(sum, min);
        System.out.println(sum);
        //go through all combinations of special offers
        for(int i=x; i<s.length; ++i){
            for(int j=0; j<=u[i]; ++j){
                c[i] = j;
                dfs(s, p, n, u, c, i+1);
            }
        }
    }
    private void calculate(int[][] s, int[] u, int[] n){
        for(int i=0; i<u.length; ++i){
            int x = max;
            for(int j=0; j<s[i].length-1; ++j){
                if(s[i][j] != 0){
                    x = Math.min(x, n[j]/s[i][j]);
                } 
            }
            u[i] = x;
        } 
    }
    private int max = 0;
    private int min = 0;


    //method 2, recursion
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs){
        return helper(price, special, needs, 0);
    }

    private int helper(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int pos){
        int min = direct(price, needs);
        for(int i=pos; i<special.size(); ++i){
            List<Integer> offer = special.get(i);
            List<Integer> temp = new ArrayList<>();
            for(int j=0; j<needs.size(); ++j){
                if(needs.get(j) < offer.get(j)){
                    temp = null;
                    break;
                }
                temp.add(needs.get(j) - offer.get(j));
            }
            if(temp != null){
                min = Math.min(min, offer.get(offer.size()-1) + helper(price, special, temp, i));
            }
        }
        return min;
    }

    private int direct(List<Integer> p, List<Integer> n){
        int s = 0;
        for(int i=0; i<p.size(); ++i){
            s += p.get(i) * n.get(i);
        }
        return s;
    }
}

public class ShoppingOffers{
	public static void main(String[] args){
		Solution s = new Solution();
        List<Integer> price = Arrays.asList(2,5);
        List<Integer> spe1 = Arrays.asList(3,0,5);
        List<Integer> spe2 = Arrays.asList(1,2,10);
        List<List<Integer>> special = Arrays.asList(spe1, spe2);
        List<Integer> needs = Arrays.asList(3,2);
        System.out.println(s.shoppingOffers(price, special, needs));
	}
}
