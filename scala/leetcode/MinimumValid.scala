//Leetcode problem 921 Minimum Add to Make Parentheses Valid
//Solution written by Xuqiang Fang on 15 Oct, 2018

object Solution {
    def minAddToMakeValid(S: String): Int = {
        var left = 0;
        var ans = 0;
        for(s <- S){
            if(s == '(') left += 1
            else{
                if(left == 0){
                    ans += 1
                }
                else{
                    left -= 1
                }
            }
        }
        return ans+left
    }
}

object Main{
    def main(args: Array[String]){
        val s = Solution.minAddToMakeValid("()())(((((())((")
        println(s)
    }
}
