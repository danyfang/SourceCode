//Leetcode Problem No 593 Valid Square
//Solution written by Xuqiang Fang on 9 Nov, 2018

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
    bool validSquare(vector<int>& p1, vector<int>& p2, vector<int>& p3, vector<int>& p4) {
        if(valid(p1, p2, p3, p4) || valid(p1, p3, p2, p4) || valid(p1, p4, p2, p3) )
            return true;
        return false;
    }
private:
    bool valid(vector<int>& p, vector<int>& q, vector<int>& r, vector<int>& s){
        if(p[0] == q[0]){
            return r[1] == s[1] && distance(p,r) == distance(q,r) && distance(p,s) == distance(q,s) && distance(p,q) == distance(r,s) && distance(p,q) != 0;
        }
        else if(r[0] == s[0]){
            return p[1] == q[1] && distance(p,r) == distance(q,r) && distance(p,s) == distance(q,s) && distance(p,q) == distance(r,s) && distance(p,q) != 0;
        }
        else{
            return (p[1]-q[1]) * (r[1]-s[1]) + (p[0]-q[0]) * (r[0]-s[0]) == 0 &&  distance(p,r) == distance(q,r) && distance(p,s) == distance(q,s) && distance(p,q) == distance(r,s) && distance(p,q) != 0;
        }
    }
    int distance(vector<int>& p, vector<int>& q){
        return (p[0] - q[0]) * (p[0]-q[0]) + (p[1]-q[1])*(p[1]-q[1]);
    }
};
int main(){
    Solution s;
    vector<int> p1{0,0}, p2{0,1}, p3{0,2}, p4{1,2};
    cout << s.validSquare(p1, p2, p3, p4) << endl;
    return 0;
}
