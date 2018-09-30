//Leetcode Problem No 914 X of a Kind in a Deck of Cards
//Solution written by Xuqiang Fang on 30 Sep, 2018

#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <unordered_map>
#include <unordered_set>
#include <stack>
#include <queue>

using namespace std;
class Solution {
public:
    bool hasGroupsSizeX(vector<int>& deck) {
        const int N = 1000;
        int d[N] = {0};
        for(auto i : deck){
            d[i] += 1;
        }
        for(int x=2; x<=deck.size(); ++x){
            bool flag = false;
            for(int i=0; i<N; ++i){
                if(d[i] % x != 0){
                    flag = true;
                }
            }
            if(!flag){
                return true;
            }
        }
        return false;
    }
};

int main(){
    Solution s;

    return 0;
}
