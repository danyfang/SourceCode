//Leetcode problem 828 Unique Letter String
//Solution written by Xuqiang Fang on 18 May, 2018
import java.util.Arrays;
class Solution{
    //TLE
    public int uniqueLetter(String S) {
        if(S.length() <= 1){
            return S.length();
        } 
        long ans = 0;
        for(int i=1; i<=S.length(); ++i){
            for(int j=0; j<S.length(); ++j){
                if(i+j <=S.length()){
                    ans += (long)count(S.substring(j, i+j));
                } 
            }
        }
        return (int)(ans % 1000000007);
    }
    private int count(String S){
        int[] count = new int[26];
        for(int i=0; i<S.length(); ++i){
            count[S.charAt(i)-'A']++;
        }
        int ans = 0;
        for(int i=0; i<26; ++i){
            if(count[i] == 1){
                ans++;
            }
        }
        return ans;
    }

    public int uniqueLetterString(String S){
        int[][] index = new int[26][2];
        for(int i=0; i<26; ++i){
            Arrays.fill(index[i], -1);
        }
        int ans = 0;
        int N = S.length();
        int mod = 1000000007;
        for(int i=0; i<N; ++i){
            int c = S.charAt(i) - 'A';
            ans = (ans + (i - index[c][1]) * (index[c][1] - index[c][0]) % mod) % mod;
            index[c][0] = index[c][1];
            index[c][1] = i;
        }
        for(int c=0; c<26; ++c){
            ans = (ans + (N - index[c][1]) * (index[c][1] - index[c][0]) % mod ) % mod;
        }
        return ans;
    }
}

public class UniqueLetter{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.uniqueLetterString(args[0]));
	}
}
