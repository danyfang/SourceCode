//Leetcode Problem No 950 Reveal Cards in Increasing Order
//Solution written by Xuqiang Fang on 4 Dec, 2018

#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <unordered_map>
#include <unordered_set>
#include <stack>
#include <queue>
#include <deque>

using namespace std;
class Solution{
public:
    vector<int> deckRevealedIncreasing(vector<int>& deck) {
        const int n = deck.size();
        if(n <= 2)
            return deck;
        deque<int> q;
        sort(deck.begin(), deck.end());
        q.push_front(deck[n-1]);
        for(int i=n-2; i>=0; --i){
            auto tmp = q.back();
            q.push_front(tmp);
            q.pop_back();
            q.push_front(deck[i]);
        }
        vector<int> ans;
        for(int i=0; i<n; ++i){
            ans.push_back(q[i]);
        }
        return ans;
    }
private:
    void print(deque<int>& v){
        for(auto& a : v){
            cout << a << " ";
        }
        cout << endl;
    }
};

int main(){
    Solution s;
    vector<int> deck{17,13,11,2,3,5,7};
    auto&& ans = s.deckRevealedIncreasing(deck);
    for(auto& a : ans){
        cout << a << " ";
    }
    cout << endl;
    return 0;
}
