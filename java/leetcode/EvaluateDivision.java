//Leetcode problem 399 Evaluate Division 
//Solution written by Xuqiang Fang on 21 April, 2018 
import java.util.HashSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Set;

class Solution{
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
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
