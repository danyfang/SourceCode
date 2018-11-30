//Leetcode Problem No 433 Minimum Genetic Mutation
//Solution written by Xuqiang Fang on 13 Nov, 2018

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
    int minMutation(string start, string end, vector<string>& bank) {
        unordered_set<string> s;
        for(auto& b : bank) s.insert(b);
        if(s.count(end) == 0) return -1;
        char c[] = {'A', 'C', 'G', 'T'};
        queue<string> q;
        q.push(start);
        int step = 0;
        while(!q.empty()){
            int size = q.size();
            step++;
            for(int x=0; x<size; ++x){
                auto t = q.front();
                q.pop();
                for(int i=0; i<t.length(); ++i){
                    for(auto& d : c){
                        if(t[i] != d){
                            auto tmp = t;//make a copy
                            tmp[i] = d;
                            if(tmp == end){
                                return step;
                            }
                            else if(s.count(tmp) != 0){
                                q.push(tmp);
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }
};

int main(){
    Solution s;
    string start = "AACCGGTT", end = "AAACGGTA";
    vector<string> bank = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
    cout << s.minMutation(start, end, bank) << endl;
    start = "AAAAACCC";
    end = "AACCCCCC";
    bank = {"AAAACCCC", "AAACCCCC", "AACCCCCC"};
    cout << s.minMutation(start, end, bank) << endl;
    start = "AGCAAAAA";
    end = "GACAAAAA";
    bank = {"AGTAAAAA","GGTAAAAA","GATAAAAA","GACAAAAA"};
    cout << s.minMutation(start, end, bank) << endl;
    return 0;
}
