//Leetcode Problem No 352 Data Stream as Disjoint Intervals
//Solution written by Xuqiang Fang on 5 June, 2018

#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <unordered_map>
#include <unordered_set>
#include <stack>
#include <queue>

using namespace std;
struct Interval {
    int start;
    int end;
    Interval() : start(0), end(0) {}
    Interval(int s, int e) : start(s), end(e) {}
};
class SummaryRanges {
public:
    /** Initialize your data structure here. */
    SummaryRanges() {
        
    }
    
    void addNum(int val) {
         
    }
    
    vector<Interval> getIntervals() {
        
    }
private:
    unordered_map<int, Interval> map_;
};

int main(){
    SummaryRanges s;

    return 0;
}
