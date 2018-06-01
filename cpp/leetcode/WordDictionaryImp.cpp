//Leetcode Problem No 211 Add and Search Word - Data structure design
//Solution written by Xuqiang Fang on 29 May, 2018

#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <unordered_map>
#include <unordered_set>
#include <stack>
#include <queue>
#include <regex>

using namespace std;

//Solution TLE
class WordDictionary_{
public:
    /** Initialize your data structure here. */
    WordDictionary_() {
    }
    
    /** Adds a word into the data structure. */
    void addWord(string word) {
        dict.insert(word); 
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' 
    to represent any one letter. */
    bool search(string word) {
        if(dict.count(word) == 1){
            return true;
        }
        for(auto w : dict){
            if(match(word, w)){
                return true;
            }
        }
        return false;
    }
private:
    bool match(string a, string b){
        if(a.length() != b.length()){
            return false;
        }
        for(int i=0; i<a.length(); ++i){
            if(a[i] == '.'){
                continue;
            }
            else if(a[i] != b[i]){
                return false;
            }
        }
        return true;
    } 
    unordered_set<string> dict;
};


class TrieNode{
public:
    TrieNode(bool b = false){
        is_word = b;
        memset(next, 0, sizeof(next));
    }
    TrieNode *next[26];
    bool is_word;
};
class WordDictionary{
public:
    /** Initialize your data structure here. */
    WordDictionary() {
        root = new TrieNode();
    }
    ~WordDictionary(){
        clear(root);
    }
    
    /** Adds a word into the data structure. */
    void addWord(string word) {
        auto t = root;
        for(int i=0; i<word.length(); ++i){
            if(t->next[word[i]-'a'] == nullptr){
                t->next[word[i]-'a'] = new TrieNode();
            }
            t = t->next[word[i]-'a'];
        }
        t->is_word = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' 
    to represent any one letter. */
    bool search(string word) {
        auto t = find(word, root);
        if(t != nullptr && t->is_word){
            return true;
        }
        return false;
    }
private:
    TrieNode *root;
    TrieNode *find(string w, TrieNode *r){
        if(r == nullptr){
            return nullptr;
        }
        auto t = r;
        for(int i=0; i<w.length(); ++i){
            if(w[i] != '.'){
                if(t != nullptr && t->next[w[i]-'a'] != nullptr){
                    t = t->next[w[i]-'a'];
                }
                else{
                    t = nullptr;
                    break;
                }
            }
            else if(t != nullptr){
                for(int j=0; j<26; ++j){
                    auto s = find(w.substr(i+1), t->next[j]); 
                    if(s != nullptr && s->is_word){
                        return s;
                    } 
                }
                t = nullptr;
            }
        }
        return t;
    }

    void clear(TrieNode *root){
        for(int i=0; i<26; ++i){
            if(root->next[i] != nullptr){
                clear(root->next[i]);
            }
        }
        delete root;
    }
};
int main(){
    WordDictionary w;
    w.addWord("bad");
    w.addWord("dad");
    w.addWord("adds");
    cout << w.search("dad") << endl;
    cout << w.search(".a.") << endl;
    cout << w.search("add.") << endl;
    return 0;
}
