//Leetcode problem 899 Orderly Queue
//Solution written by Xuqiang Fang on 2 Spe, 2018
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
    public String orderlyQueue(String s, int k) {
        if(k == 1){
            int[] index = new int[26];
            for(int i=0; i<s.length(); ++i){
                index[s.charAt(i)-'a']++;
            }
            int i = 0;
            for(i=0; i<26; ++i){
                if(index[i] == s.length()){
                    return s;
                }
                if(index[i] > 0){
                    break;    
                }
            }
            List<Integer> length = new ArrayList<>();
            char c = (char)('a'+i);
            int l = 0;
            for(int j=0; j<s.length(); ++j){
                if(s.charAt(j) == c && l > 0){
                    length.add(l);
                    l = 0;
                }
                l++;
            }
            length.add(l);
            List<String> list = new ArrayList<>();
            StringBuilder sb = new StringBuilder(s);
            for(int j=0; j<length.size(); ++j){
                String t = sb.substring(0, length.get(j)); 
                sb.delete(0, length.get(j));
                sb.append(t);
                list.add(sb.toString());
            }
            String ans = list.get(0);
            for(int j=1; j<list.size(); ++j){
                ans = compare(ans, list.get(j));
            }
            return ans;

        }
        else{
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            return String.valueOf(ch);
        }
    }
    private String compare(String a, String b){
        int n = a.length();
        for(int i=0; i<n; ++i){
            if(a.charAt(i) < b.charAt(i)){
                return a;
            }
            else if(a.charAt(i) > b.charAt(i)){
                return b;
            }
        }
        return a;
    }
    private void helper(StringBuilder sb, int k){
        String s = sb.substring(0, k);
        sb.delete(0, k);
        sb.append(s);
    }
}

public class OrderlyQueue{
	public static void main(String[] args){
		Solution s = new Solution();
        /*
        System.out.println(s.orderlyQueue("baaca", 3));
        System.out.println(s.orderlyQueue("cba", 1));
        System.out.println(s.orderlyQueue("kuh", 1));
        System.out.println(s.orderlyQueue("baaca", 3));
        System.out.println(s.orderlyQueue("gn", 2));
        System.out.println(s.orderlyQueue("enbczfjtvxerzbrvigpl", 1));
        System.out.println(s.orderlyQueue("brvigplenbczfjtvxerz", 1));
        System.out.println(s.orderlyQueue("lenbczfjtvxebbbbbrzbrvigp", 1));
        */
        System.out.println(s.orderlyQueue("gtxlrjwkpzolcynsrgqcbvphnoradctlfjrloykccsicuxcqtgvrlegvesooadiqjgjmpojl upzphnmwtwsghewxiamusracsvevypoakmylaobzrssykhcamttaqvwukssbbiqjqtuhzoqqrerlzszzvppmjkxqeallbfijqevmbcyaqerzxllhlyamxcdvhuhavilbqvfyqofwlbyjhbabwwmcdyoubbudvylcslnxodjwncnawgszxnisoxgsdkujhjjadtsqddmmdzvwervizcudgedrguuyuzoaikzkhuxbzszqarfzywsgyvqefopkvrgapixgofzqtxlolqivjuajmxstqxsqxtawetkkelzvtqfbyxaxtceegxkolmgighpaynnkttszkcusamvyjmltsmepajibculdyilseuvmsszujnknxcxndyfamobqoocjdmjiwqcrzjurmkfkgmrxdvtqebdihviezsumcplicihjsdjtiwweqqeomgsxxcjcmrsbcqvpccpfthvxnstqqkxeesfnxjtwrcnuzlbjmybxlctddgorwpqmnrhhqqefoviebnnporwiufimntatuaoadwbxrtrttxjjqnrjkkbtoxtkubqyxihhxikigwlnkikxhsfxmhltwvdzmyeyfwhvewrdylevbatctcydoqjcmixffplhdvcxydyguilsotkbixuypimmgwbizoyavqwtzitvsuvhhkaxvdvipmlpxkawyuektwwyqdkydyjpvccmxzreujgplnzawlvwtmnpkswiyoheshvyjjhgzvwayvvykbonftzsuuveppwlgnmabemrnozcjouwqrxupakbzvicojsvpvaglmveonqabckptqcwkvejrqnyvprknqvflefadtihdokbjutzwmuukkolqvxqnfkfsodeacqqnuogtjbflpuwutpfrsgjhzsjfigvejngeyxanblcufhcznkoeuhw", 1));
	}
}
