//Leetcode problem 640 Solve the Equation
//Solution written by Xuqiang Fang on 28 April, 2018 

class Solution{
    
    public String solveEquation(String equation){
        if(equation == null || equation.length() == 0)
            return "Infinite solutions";
        char[] ch; 
        if(equation.charAt(0) == '-')
            ch = equation.toCharArray();
        else
            ch = ("+"+equation).toCharArray();
        int begin = 0;
        int end = 1;
        boolean rightOfEqual = false;
        int value = 0;
        int variable = 0;
        while(end < ch.length){
            if(ch[end] != '+' && ch[end] != '-' && ch[end] != '='){
                end++;
                continue;
            }
            //System.out.println(ch[end]);
            String temp = String.valueOf(ch, begin+1, end-begin-1); 
            //System.out.println("temp = " + temp);
            if(temp.matches("[\\d]*x")){
                temp = temp.replaceAll("x","");
                if(temp.equals(""))
                    temp = "1";
                variable = calculate(variable, Integer.valueOf(temp), ch[begin], rightOfEqual);
            }
            else{
                value = calculate(value, Integer.valueOf(temp), ch[begin], rightOfEqual);
            }
            if(ch[end] == '='){
                rightOfEqual = true;
                if(end+1 < ch.length && ch[end+1] != '-')
                    ch[end] = '+';
                else
                    end++;
            }
            begin = end;
            end++;
        }
        String temp = String.valueOf(ch, begin+1, end-begin-1); 
        if(temp.matches("[\\d]*x")){
            temp = temp.replaceAll("x","");
            if(temp.equals(""))
                temp = "1";
            variable = calculate(variable, Integer.valueOf(temp), ch[begin], rightOfEqual);
        }
        else{
            value = calculate(value, Integer.valueOf(temp), ch[begin], rightOfEqual);
        }
        //System.out.println("left = " + variable + "x");
        //System.out.println("right = " + (-value));
        if(variable == 0){
            if(value == 0)
                return "Infinite solutions";
            return "No solution";
        }
        return "x="+(-value/variable);
    }	


    public int calculate(int a, int b, char operator, boolean rightOfEqual){
        if(!rightOfEqual){
            if(operator == '+')
                return a + b;
            else
                return a - b;
        }
        else{
            if(operator == '+')
                return a - b;
            else
                return a + b;
        }
    }



    //another answer provided by user@compton_scatter
    public String solveEquation(String equation) {
        int[] res = evaluateExpression(equation.split("=")[0]),  
          res2 = evaluateExpression(equation.split("=")[1]);
        res[0] -= res2[0];
        res[1] = res2[1] - res[1];
        if (res[0] == 0 && res[1] == 0) return "Infinite solutions";
        if (res[0] == 0) return "No solution";
        return "x=" + res[1]/res[0];
    }  

    public int[] evaluateExpression(String exp) {
        String[] tokens = exp.split("(?=[-+])"); 
        int[] res =  new int[2];
        for (String token : tokens) {
            if (token.equals("+x") || token.equals("x")) res[0] += 1;
        else if (token.equals("-x")) res[0] -= 1;
        else if (token.contains("x")) res[0] += Integer.parseInt(token.substring(0, token.indexOf("x")));
        else res[1] += Integer.parseInt(token);
        }
        return res;
    }
}

public class SolveEquation{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.solveEquation(args[0]));
        //System.out.println(args[0].matches("[\\d]*x"));
	}
}
