//Leetcode problem  208 Implement Trie(Prefix Tree)
//Solution written by Xuqiang Fang on 15 May, 2018

import java.util.Queue;
import java.util.LinkedList;

class Trie{
    /** Initialize your data structure here */
    public Trie(){
        root = new TrieNode(); 
    }
    
    /** Insert a word into the trie*/
    public void insert(String word){
        TrieNode p = root;
        for(int i=0; i<word.length(); ++i){
            int index = (int)(word.charAt(i) - 'a');
            if(p.children[index] == null){
                p.children[index] = new TrieNode();
            }
            p = p.children[index];
        }
        p.isWord = true;
    }

    /** Returns true if the word is in the trie*/
    public boolean search(String word){
        TrieNode node = find(word);
        return node != null && node.isWord;
    }

    /**Returns if there is any word in the trie that starts with the given prefix*/
    public boolean startsWith(String prefix){
        TrieNode node = find(prefix);
        return node != null;
    }

    private TrieNode find(String prefix){
        TrieNode p = root;
        for(int i=0; i<prefix.length(); ++i){
            int index = (int)(prefix.charAt(i) - 'a');
            if(p.children[index] == null)
                return null;
            p = p.children[index];
        }
        return p;
    }

    public void printTrie(){
        Queue<TrieNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TrieNode node = queue.poll();
            for(int i=0; i<26; ++i){
                if(node.children[i] != null){
                    TrieNode child = node.children[i];
                    queue.offer(child);
                    System.out.println((char)(i+'a'));
                }
            }
        }
    }

    class TrieNode{
        public TrieNode(){
            children = new TrieNode[26];
            isWord = false;
        } 
        public TrieNode[] children;
        public boolean isWord;
    }
    TrieNode root;
}

public class TrieImp{
	public static void main(String[] args){
        Trie t = new Trie();
        t.insert("hello");
        t.insert("world");
        t.insert("i");
        t.insert("love");
        t.insert("leetcode");
        System.out.println(t.search("leetcode"));
        System.out.println(t.startsWith("leet"));
        System.out.println(t.startsWith("leetfdj"));
        t.printTrie();
	}
}
