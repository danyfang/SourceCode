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

//SOlution TLE
class WordDictionary_{
public:
    /** Initialize your data structure here. */
    WordDictionary() {
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


const int ALPHA_SIZE = 26;
class WordDictionray{
public:
    /** Initialize your data structure here. */
    WordDictionary() {
        root = NULL;
    }
    
    /** Adds a word into the data structure. */
    void addWord(string word) {
        
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' 
    to represent any one letter. */
    bool search(string word) {
    }
private:
    class TrieNode{
    public:
        TrieNode(){
            isEnd = false; 
        }
    private:
        vector<TrieNode> children(ALPHA_SIZE);
        bool isEnd;
    };
    TrieNode root;
}
int main(){
    WordDictionary w;
    w.addWord("bad");
    w.addWord("dad");
    cout << w.search("dad") << endl;
    cout << w.search(".ad") << endl;
    return 0;
}
