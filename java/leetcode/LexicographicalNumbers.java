//Leetcode problem 386 Lexicographical Numbers
//Solution written by Xuqiang Fang on 20 April, 2018 
import java.util.ArrayList;
import java.util.List;

//solution provided by user@songzec
class Solution{
    List<Integer> lexicalOrder(int n){
        List<Integer> list = new ArrayList<>();
        int curr = 1;
        for(int i=1; i<=n; ++i){
            list.add(curr);
            if(curr * 10 <= n){
                curr*= 10;
            }
            else if(curr%10 != 9 && curr+1 <= n){
                curr++;
            }
            else{
                while((curr/10)%10 == 9){
                    curr /= 10;
                }
                curr = curr / 10 + 1;
            }
        } 

        return list;
    }	

}

public class LexicographicalNumbers{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.lexicalOrder(Integer.valueOf(args[0])));
	}
}
