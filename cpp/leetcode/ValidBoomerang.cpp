//Leetcode Problem No 1037. Valid Boomerang
//Solution written by Xuqiang Fang on 14 May, 2019

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
    bool isBoomerang(vector<vector<int>>& p) {
        int a = dist(p[0], p[1]);
        int b = dist(p[0], p[2]);
        int c = dist(p[1], p[2]);    
        if(a == 0 || b == 0 || c == 0){
            return false;
        } 
        vector<int> v = {a, b, c};
        sort(v.begin(), v.end());
        float x = (float)sqrt(v[0]);
        float y = (float)sqrt(v[1]);
        float z = (float)sqrt(v[2]);
        auto e = 1e-7;
        if(x+y-z < e){
            return false;
        }
        return true;
    }
 private:
    int dist(vector<int>& a, vector<int>& b){
        return (a[0]-b[0])*(a[0]-b[0]) + (a[1]-b[1])*(a[1]-b[1]);
    }
};

int main(){
  Solution s;
  vector<vector<int>> p{{1,1},{3,2},{2,3}};
  cout << s.isBoomerang(p) << endl;  
  p = {{1,1},{2,2},{3,3}};
  cout << s.isBoomerang(p) << endl;
  return 0;
}
