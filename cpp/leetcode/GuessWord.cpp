//Leetcode Problem No 843 Guess the Word
//Solution written by Xuqiang Fang on 4 June, 2018

#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <unordered_map>
#include <unordered_set>
#include <stack>
#include <queue>
#include <utility>
using namespace std;
class Master{
public:
    Master(string s){
        secret = s;
    }
    int guess(string word){
        return match(word, secret); 
    }
private:
    int match(string a, string b){
        int m = 0;
        for(int i=0; i<a.length(); ++i){
            if(a[i] == b[i]){
                m++;
            }
        }
        return m;
    }
    string secret;
};
class Solution{
public:
    void findSecretWord(vector<string>& wordlist, Master& master){
        for(int i=0, x=0; i<10 && x<6; ++i){
            unordered_map<string, int> count;
            for(auto s1 : wordlist){
                for(auto s2 : wordlist){
                    if(match(s1, s2) == 0){
                        count[s1]++;
                    }
                }
            }
            /*
            * Make a guess and find the word that has the least match with the guess
            * Because the word with 0 matches works like a sifter, screener,
            * It screens out all other words that have non-zero matches with the guessword
            */
            pair<string, int> minmax = make_pair(wordlist[0], 100);
            for(auto w : wordlist){
                if(count[w] <= minmax.second){
                    minmax = make_pair(w, count[w]);
                }
            }
            x = master.guess(minmax.first);
            cout << "guess the word " << minmax.first << endl;
            vector<string> wordlist2;
            for(auto w : wordlist){
                if(match(minmax.first, w) == x){
                    wordlist2.push_back(w);
                }
            } 
            wordlist = wordlist2;
            cout << "remaining possible result size " << wordlist.size() << endl;
        }
    }
private:
    int match(string a, string b){
        int m = 0;
        for(int i=0; i<a.length(); ++i){
            if(a[i] == b[i]){
                m++;
            }
        }
        return m;
    }
};

int main(){
    Solution s;
    vector<string> wordlist{"acckzz","ccbazz","eiowzz","abcczz"};
    string secret = "acckzz";
    Master master{secret};
    s.findSecretWord(wordlist, master);
    string sec{"hbaczn"};
    vector<string> word{"gaxckt","trlccr","jxwhkz","ycbfps","peayuf","yiejjw","ldzccp","nqsjoa","qrjasy","pcldos","acrtag","buyeia","ubmtpj","drtclz","zqderp","snywek","caoztp","ibpghw","evtkhl","bhpfla","ymqhxk","qkvipb","tvmued","rvbass","axeasm","qolsjg","roswcb","vdjgxx","bugbyv","zipjpc","tamszl","osdifo","dvxlxm","iwmyfb","wmnwhe","hslnop","nkrfwn","puvgve","rqsqpq","jwoswl","tittgf","evqsqe","aishiv","pmwovj","sorbte","hbaczn","coifed","hrctvp","vkytbw","dizcxz","arabol","uywurk","ppywdo","resfls","tmoliy","etriev","oanvlx","wcsnzy","loufkw","onnwcy","novblw","mtxgwe","rgrdbt","ckolob","kxnflb","phonmg","egcdab","cykndr","lkzobv","ifwmwp","jqmbib","mypnvf","lnrgnj","clijwa","kiioqr","syzebr","rqsmhg","sczjmz","hsdjfp","mjcgvm","ajotcx","olgnfv","mjyjxj","wzgbmg","lpcnbj","yjjlwn","blrogv","bdplzs","oxblph","twejel","rupapy","euwrrz","apiqzu","ydcroj","ldvzgq","zailgu","xgqpsr","wxdyho","alrplq","brklfk"};
    Master mas{sec};
    s.findSecretWord(word, mas);
    return 0;
}
