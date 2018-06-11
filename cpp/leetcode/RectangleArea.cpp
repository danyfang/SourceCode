//Leetcode Problem No 850 Rectangle Area II
//Solution written by Xuqiang Fang on 10 June, 2018

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
    int rectangleArea(vector<vector<int>>& r) {
        int modolo = (1<<10)+7;
        int sum = (r[0][2]-r[0][0]) * (r[0][3]-r[0][1]);
        for(int i=1; i<r.size(); ++i){
            cout << helper(r[0], r[i]) << endl;
        }
        return 0;
    }
private:
    long helper(const vector<int>& base, const vector<int>& v){
        long horizontal = overlap(base[0], base[2], v[0], v[2]);
        long vertical = overlap(base[1], base[3], v[1], v[3]);
        //cout << "h = " << horizontal << ", v = " << vertical << endl;
        return horizontal * vertical; 
    }
    long overlap(int x1, int x2, int y1, int y2){
        //x2 >= x1 && y2 >= y1
        if(x1 > y1 && x1 <= y2){
            return (long)min(y2-x1, x2-x1); 
        }
        else if(x1 <= y1){
            if(y2 <= x2){
                return (long)(y2-y1);
            }
            return (long)(x2-y1);
        }
        return 0;
    }
    bool check(int s1, int e1, int s2, int e2){
        return max(s1, s2) < min(e1, e2);
    }
};

int main(){
    Solution s;
    vector<vector<int>> r{{0,0,2,2},{1,0,2,3},{1,0,3,1}};
    s.rectangleArea(r);
    return 0;
}
