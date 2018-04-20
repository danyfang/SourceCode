//Leetcode Problem No. 332 Reconstruct Itinerary 
//Solution written by Xuqiang Fang on 20 April, 2018 

#include <iostream>
#include <vector>
#include <string>
#include <unordered_map>
#include <deque>
#include <utility>

using namespace std;

class Solution{
public:
    vector<string> findItinerary(vector<pair<string,string>> tickets){
        route_.clear();
        trips_.clear();

        for(const auto& pair : tickets){
            trips_[pair.first].push_back(pair.second);
        }

        for(auto& pair : trips_){
            auto& dests = pair.second;
            std::sort(dests.begin(), dests.end());
        }

        const string kStart = "JFK";
        visit(kStart);

        return vector<string>(route_.crbegin(), route_.crend());
    }
private:
    unordered_map<string, deque<string>> trips_;

    vector<string> route_;

    void visit(const string& src){
        auto& dests = trips_[src];
        while(!dests.empty()){
            const string dest = dests.front();
            dests.pop_front();
            visit(dest);
        }
        route_.push_back(src);
    }

};

int main(){
    Solution s;

    return 0;
}
