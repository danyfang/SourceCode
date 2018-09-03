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
            int c = 0;
            StringBuilder sb = new StringBuilder(s);
            for(int i=1; i<s.length(); ++i){
                if(s.charAt(i) < s.charAt(c)){
                    c = i;
                }
            } 
            helper(sb, c);
            System.out.println(sb.toString());
            int j = 0;
            for(int i=1; i<sb.length(); ++i){
                if(sb.charAt(i) == sb.charAt(j)){
                    int tmp = i;
                    while(i < sb.length() && j < tmp && sb.charAt(i) == sb.charAt(j)){
                        i++;
                        j++;
                    }
                    if(i == sb.length()){
                        return sb.toString();
                    }
                    if(sb.charAt(i) < sb.charAt(j)){
                        j = tmp;
                    }
                }
            }
            helper(sb, j);
            return sb.toString();
        }
        else{
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            return String.valueOf(ch);
        }
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
        System.out.println(s.orderlyQueue("gtxlrjwkpzolcynsrgqcbvphnoradctlfjrloykccsicuxcqtgvrlegvesooadiqjgjmpojlupzphnmwtwsghewxiamusracsvevypoakmylaobzrssykhcamttaqvwukssbbiqjqtuhzoqqrerlzszzvppmjkxqeallbfijqevmbcyaqerzxllhlyamxcdvhuhavilbqvfyqofwlbyjhbabwwmcdyoubbudvylcslnxodjwncnawgszxnisoxgsdkujhjjadtsqddmmdzvwervizcudgedrguuyuzoaikzkhuxbzszqarfzywsgyvqefopkvrgapixgofzqtxlolqivjuajmxstqxsqxtawetkkelzvtqfbyxaxtceegxkolmgighpaynnkttszkcusamvyjmltsmepajibculdyilseuvmsszujnknxcxndyfamobqoocjdmjiwqcrzjurmkfkgmrxdvtqebdihviezsumcplicihjsdjtiwweqqeomgsxxcjcmrsbcqvpccpfthvxnstqqkxeesfnxjtwrcnuzlbjmybxlctddgorwpqmnrhhqqefoviebnnporwiufimntatuaoadwbxrtrttxjjqnrjkkbtoxtkubqyxihhxikigwlnkikxhsfxmhltwvdzmyeyfwhvewrdylevbatctcydoqjcmixffplhdvcxydyguilsotkbixuypimmgwbizoyavqwtzitvsuvhhkaxvdvipmlpxkawyuektwwyqdkydyjpvccmxzreujgplnzawlvwtmnpkswiyoheshvyjjhgzvwayvvykbonftzsuuveppwlgnmabemrnozcjouwqrxupakbzvicojsvpvaglmveonqabckptqcwkvejrqnyvprknqvflefadtihdokbjutzwmuukkolqvxqnfkfsodeacqqnuogtjbflpuwutpfrsgjhzsjfigvejngeyxanblcufhcznkoeuhw", 1));
	}
}
