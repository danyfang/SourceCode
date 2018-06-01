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
class TrieNode{
public:
    TrieNode(bool b = false){
        is_word = b;
        memset(next, 0, sizeof(next));
    }
    TrieNode *next[26];
    bool is_word;
};
class Trie{
public:
    /** Initialize your data structure here. */
    Trie() {
        root = new TrieNode();
    }
    ~Trie(){
        clear(root);
    } 
    /** Inserts a word into the trie. */
    void insert(string word) {
        auto t = root;
        for(int i=0; i<word.length(); ++i){
            if(t->next[word[i]-'a'] == nullptr){
                t->next[word[i]-'a'] = new TrieNode();
            }
            t = t->next[word[i]-'a'];
        }
        t->is_word = true;
    }
    
    /** Returns if the word is in the trie. */
    bool search(string word) {
        auto t = find_string(word);
        if(t != nullptr && (t->is_word)){
            return true;
        }
        return false;    
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    bool startsWith(string prefix) {
        auto t = find_string(prefix);
        if(t != nullptr){
            return true;
        }
        return false; 
    }
private:
    TrieNode *root;
    TrieNode *find_string(string word){
        auto temp = root;
        for(int i=0; i<word.length(); ++i){
            if(temp->next[word[i]-'a'] != nullptr){
                temp = temp->next[word[i]-'a'];
            }
            else{
                temp = nullptr;
                break;
            }
        }
        return temp;
    }
    void clear(TrieNode *root){
        for(int i=0; i<26; ++i){
            if(root -> next[i] != nullptr){
                clear(root->next[i]);
            }
        }
        delete root;
    }
};

int main(){
    Trie t;
    t.insert("abcd");
    cout << t.startsWith("abc") << endl;
    cout << t.search("abc") << endl;
    cout << t.search("abcd") << endl;
    return 0;
}
