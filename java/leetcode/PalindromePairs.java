//Leetcode problem 336 Palindrome Pairs
//Solution written by Xuqiang Fang on 27 July, 2018
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
    private class TrieNode{
        TrieNode[] next;
        int index;
        List<Integer> list;
        TrieNode(){
            next = new TrieNode[26];
            index = -1;
            list = new ArrayList<>();
        }
    }
    public List<List<Integer>> palindromePairs(String[] words) {
        TrieNode root = new TrieNode();
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<words.length; ++i){
            add(root, words[i], i);
        }
        for(int i=0; i<words.length; ++i){
            search(words, i, root, ans);
        }
        return ans;
    }

    private void add(TrieNode root, String word, int index){
        for(int i=word.length()-1; i>=0; --i){
            int j = word.charAt(i) - 'a';
            if(root.next[j] == null){
                root.next[j] = new TrieNode();
            }
            if(isPalin(word, 0, i)){
                root.list.add(index);
            }
            root = root.next[j];
        }
        root.list.add(index);
        root.index = index;
    }
    
    private void search(String[] words, int i, TrieNode root, List<List<Integer>> ans){
        for(int j=0; j<words[i].length(); ++j){
            if(root.index >= 0 && root.index != i && isPalin(words[i], j, words[i].length()-1)){
                ans.add(Arrays.asList(i, root.index));
            }
            root = root.next[words[i].charAt(j)-'a'];
            if(root == null){
                return;
            }
        }
        for(int j : root.list){
            if(i == j){
                continue;
            }
            ans.add(Arrays.asList(i, j));
        }
    }

    private boolean isPalin(String s, int i, int j){
        while(i < j){
            if(s.charAt(i++) != s.charAt(j--)){
                return false;
            }
        }
        return true;
    }
}

public class PalindromePairs{
	public static void main(String[] args){
		Solution s = new Solution();
        String[] words = {"abcd","dcba","lls","s","sssll"};
        System.out.println(s.palindromePairs(words));
	}
}
