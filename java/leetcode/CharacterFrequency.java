//Leetcode problem 451 Sort Characters By Frequency
//Solution written by Xuqiang Fang on 
import java.util.Arrays;
import java.util.Comparator;
class Node{
    int index;
    int frequency;
    Node(int i, int f){
        index = i;
        frequency = f;
    }
}
class Solution{
    public String frequencySort(String s){
        Node[] freq = new Node[128];
        for(int i=0; i<128; ++i){
            freq[i] = new Node(i, 0);
        }
        char[] ch = s.toCharArray();
        for(char c : ch){
            freq[(int)c].frequency++;
        }

        Arrays.sort(freq, new myComparator());
        StringBuilder sb = new StringBuilder();
        for(Node n : freq){
            if(n.frequency > 0){
                int i=0;
                while(i++ < n.frequency)
                    sb.append((char)(n.index)); 
            }
        }
        return sb.toString();
    }	
    class myComparator implements Comparator<Node>{
        @Override
        public int compare(Node a, Node b){
            return b.frequency - a.frequency;
        }
    }
}

public class CharacterFrequency{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.frequencySort(args[0]));
	}
}
