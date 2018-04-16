//Leetcode Problem No. 127 Word Ladder
//Solution written by Xuqiang Fang on 14 April, 2018 

#include <iostream>
#include <string>
#include <vector>
#include <unordered_set>
#include <unordered_map>
#include <queue>

using namespace std;

class Solution{
public:
    //BFS
    int ladderLength(string beginWord, string endWord, vector<string>& wordList){
        unordered_set<string> dict(wordList.begin(), wordList.end());
        if(!dict.count(endWord))    
            return 0;
        queue<string> q;
        unordered_map<string, int> words;
        words[beginWord] = -1;
        q.push(beginWord);

        int l = beginWord.length();
        int step = 0;

        while(!q.empty()){
            ++step;
            for(int size=q.size(); size>0; size--){
                string w = q.front();
                q.pop();
                int loc = words[w];
                for(int i=0; i<l; i++){
                    if(i == loc)
                        continue;
                    char ch = w[i];
                    for(int j='a'; j<='z'; j++){
                        w[i] = j;
                        if(w == endWord)
                            return step+1;
                        if(!dict.count(w))
                            continue;
                        words[w] = i;
                        dict.erase(w);
                        q.push(w);
                    }
                    w[i] = ch;
                }
            }
        }
        return 0;
    }
    
    //bidirectional BFS
    nt ladderLength_(string beginWord, string endWord, vector<string>& wordList){
        unordered_set<string> dict(wordList.begin(), wordList.end());
        if(!dict.count(endWord)) return 0;

        int l = beginWord.length();
        unordered_set<string> q1{beginWord};
        unordered_set<string> q2{endWord};

        int step = 0;
        while(!q1.empty() && !q2.empty()){
            ++step;
            if(q1.size() > q2.size())
                std::swap(q1,q2);

            unordered_set<string> q;
            for(string w : q1){
                for(int i=0; i<l; i++){//for each letter of the word
                    char ch = w[i];
                    for(int j='a'; j<='z'; j++){//search through all 26 letters
                        w[i] = j;
                        if(q2.count(w)) return step+1;
                        if(!dict.count(w))
                            continue;
                        dict.erase(w);
                        q.insert(w);
                    }
                    w[i] = ch;
                }
            }
            std::swap(q, q1); 
        }

        return 0;
    }
};

int main(){
    Solution s;
    string beginWord = "hit";
    string endWord = "cog";
    vector<string> wordList{"hot","dot","dog","lot","log","cog"};
    cout << s.ladderLength_(beginWord, endWord, wordList) << endl;
    return 0;
}
