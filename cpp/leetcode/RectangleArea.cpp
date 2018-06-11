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
    //cannot understand it
    int rectangleArea(vector<vector<int>>& rec) {
        int mod = 1000000000+7;
        vector<int> x{0};
        for(auto r : rec){
            x.push_back(r[0]);
            x.push_back(r[2]);
        }
        sort(x.begin(), x.end());
        vector<int>::iterator end_unique = unique(x.begin(), x.end());
        x.erase(end_unique, x.end());
        unordered_map<int, int> x_i;
        for(int i=0; i<x.size(); ++i){
            //cout << x[i] << endl;
            x_i[x[i]] = i;
        }
        vector<int> count(x.size(), 0);
        vector<vector<int>> L;
        for(auto r : rec){
            int x1 = r[0], y1 = r[1], x2 = r[2], y2 = r[3];
            L.push_back({y1, x1, x2, 1});
            L.push_back({y2, x1, x2, -1});
        }
        sort(L.begin(), L.end());
        long long cur_y = 0, cur_x_sum = 0, area = 0;
        for(auto l : L){
            long long y = l[0], x1 = l[1], x2 = l[2];
            int sig = l[3];
            area = (area + (y - cur_y) * cur_x_sum) % mod;
            cur_y = y;
            for(int i=x_i[x1]; i<x_i[x2]; ++i){
                count[i] += sig;
            }
            cur_x_sum = 0;
            for(int i=0; i<x.size(); ++i){
                if(count[i] > 0){
                    cur_x_sum += x[i+1] - x[i];
                }
            }
        }
        return area;
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
    cout << s.rectangleArea(r) << endl;
    vector<vector<int>> rec{{0,0,1000000000,1000000000}};
    cout << s.rectangleArea(rec) << endl;
    return 0;
}
