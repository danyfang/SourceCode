//Leetcode Problem No 208 Implement Trie (Prefix Tree)
//Solution written by Xuqiang Fang on 29 May, 2018

#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <unordered_map>
#include <unordered_set>
#include <stack>
#include <queue>

using namespace std;
class Solution{
public:
    /** Initialize your data structure here. */
    Trie() {
    }
    
    /** Inserts a word into the trie. */
    void insert(string word) {
        TrieNode c = root;
        for(int i=0; i<word.length(); ++i){
            int in = word[i]-'0';
            c[in] = 
        }
    }
    
    /** Returns if the word is in the trie. */
    bool search(string word) {
        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    bool startsWith(string prefix) {
        
    }
private:
    struct TrieNode{
        vector<TrieNode> children(26);
        bool isEnd = false;
    }
    TrieNode root;
};

int main(){
    Solution s;

    return 0;
}
