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
    int ladderLength(string beginWord, string endWord, vector<string>& wordList){
        unordered_set<string> dict(wordList.begin(), wordList.end());
        if(!dict.count(endWord))    
            return 0;

        return 0;
    }

};

int main(){
    Solution s;

    return 0;
}
