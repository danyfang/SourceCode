//Leetcode Problem No 218 The Skyline Problem
//Solution written by Xuqiang Fang on 12 July, 2018

#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <unordered_map>
#include <unordered_set>
#include <stack>
#include <set>
#include <queue>

using namespace std;
class Solution{
public:
    vector<pair<int, int>> getSkyline(vector<vector<int>>& buildings){
        typedef pair<int, int> Event;

        vector<Event> es;
        hs_.clear();

        for(const auto& b : buildings){
            es.emplace_back(b[0], b[2]);
            es.emplace_back(b[1], -b[2]);
        }
        sort(es.begin(), es.end(), [](const Event& e1, Event& e2){
            if(e1.first == e2.first){
                return e1.second > e2.second;
            }
            return e1.first < e2.first;
        });
        for(auto& e : es){
            cout << e.first << "," << e.second << endl;
        }
        vector<pair<int, int>> ans;
        for(const auto& e : es){
            int x = e.first;
            bool entering = e.second > 0;
            int h = abs(e.second);
            if(entering){
                if(h > this->maxHeight()){
                    ans.emplace_back(x,h);
                }
                hs_.insert(h);
            }
            else{
                cout << *hs_.equal_range(h).first << endl;
                cout << hs_.size() << endl;
                hs_.erase(hs_.equal_range(h).first);
                cout << hs_.size() << endl;
                if(h > this->maxHeight()){
                    ans.emplace_back(x, this->maxHeight());
                }
            }
        }
        return ans;
    }
private:
    int maxHeight() const{
        if(hs_.empty()){
            return 0;
        }
        return *hs_.rbegin();//get the value of the iterator
    }
    multiset<int> hs_;
};

int main(){
    Solution s;
    vector<vector<int>> buildings{{0,2,3},{2,5,3}};
    vector<pair<int, int>> ans = s.getSkyline(buildings);
    for(auto& a : ans){
        cout << a.first << "," << a.second << endl; 
    }
    cout << "test ********" << endl;
    multiset<int> m;
    m.insert(1);
    m.insert(1);
    m.insert(1);
    m.insert(1);
    cout << m.size() << endl;
    return 0;
}
