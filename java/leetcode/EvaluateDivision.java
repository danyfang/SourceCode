//Leetcode problem 399 Evaluate Division 
//Solution written by Xuqiang Fang on 21 April, 2018 
import java.util.HashSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Set;

class Solution{
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        for(int i=0; i<equations.length; ++i){
            String a = equations[i][0];
            String b = equations[i][1];
            double g = values[i];
            if(!map.containsKey(a)){
                Map<String, Double> atob = new HashMap<>();
                atob.put(b,g);
                map.put(a, atob);
            }
            else{
                map.get(a).put(b,g);
            }
            if(!map.containsKey(b)){
                Map<String, Double> btoa = new HashMap<>();
                btoa.put(a,1.0/g);
                map.put(b, btoa);
            }
            else{
                map.get(b).put(a,1.0/g);
            }
        }

        double[] result = new double[queries.length];
        for(int i=0; i<queries.length; ++i){
            String[] q = queries[i];
            String a = q[0];
            String b = q[1];
            if(!map.containsKey(a) || !map.containsKey(b)){
                result[i] = -1.0; 
                continue;
            }
            Set<String> set = new HashSet<>();
            result[i] = divide(a,b,map,set);
        }
        return result;
    }	
    //get result of a / b;
    private double divide(String a, String b, Map<String, Map<String, Double>> map, Set<String> set){
        if(a.equals(b))
            return 1.0;
        set.add(a);
        for(String c : map.get(a).keySet()){
            if(set.contains(c))
                continue;
            double d = divide(c,b,map,set);

            if(d > 0)
                return d * map.get(a).get(c);
        }
        return -1.0;
    }
}

public class EvaluateDivision{
	public static void main(String[] args){
		Solution s = new Solution();
        /*
        [["a","b"],["c","d"]]
        [1.0,1.0]
        [["a","c"],["b","d"],["b","a"],["d","c"]]
        */
        String[][] equations = {{"a","b"},{"c","d"}};
        double[] values = {1.0,1.0};
        String[][] queries = {{"a","c"},{"b","d"},{"b","a"},{"d","c"},{"x","x"}};

        double[] result = s.calcEquation(equations, values, queries);
        for(double i : result)
            System.out.println(i);
	}
}
