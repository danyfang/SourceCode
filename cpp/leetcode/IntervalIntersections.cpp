//Leetcode Problem No 986 Interval Lists Intersections
//Solution written by Xuqiang Fang on 5 Feb, 2019

#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <unordered_map>
#include <unordered_set>
#include <stack>
#include <queue>

using namespace std;
struct Interval{
  int start;
  int end;
  Interval() : start(0), end(0) {}
  Interval(int s, int e) : start(s), end(e) {}
};
class Solution {
public:
    vector<Interval> intervalIntersection(vector<Interval>& A, vector<Interval>& B) {
        int l = 0,  r = 0;
        vector<Interval> ans;
        while(l < A.size() && r < B.size()){
            if(max(A[l].start, B[r].start) <= min(A[l].end, B[r].end)){
                ans.push_back(helper(A[l], B[r]));
                //print(A[l]);
                //print(B[r]);
                //cout << "******************" << endl;
            }
            if(A[l].end <= B[r].end){
                l++;
            }
            else{
                r++;
            }
        }
        return ans;
    }
private:
    Interval helper(Interval& a, Interval& b){
        Interval ans;
        ans.start = max(a.start, b.start);
        ans.end = min(a.end, b.end);
        return ans;
    }
    void print(Interval& a){
        cout << a.start << ", " << a.end << endl;
    }
};

int main(){
  Solution s;

  return 0;
}
