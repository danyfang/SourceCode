//Leetcode Problem No 11 Container With Most Water
//Solution written by Xuqiang Fang on 17 June, 2018

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
    /*
    * Two pointers, classic way to solve this question, O(n) time
    */
    int maxArea(vector<int> h){
        int l = 0;
        int r = h.size()-1;
        int m = min(h[r], h[l]) * (r-l);//max area
        while(l < r){
            if(h[l] < h[r]){
                l++;
                m = max(m, min(h[r],h[l])*(r-l));
            } 
            else{
                r--;
                m = max(m, min(h[r], h[l])*(r-l));
            }
        }
        return m;
    }
};

int main(){
    Solution s;
    vector<int> height{1,3,2,4};
    cout << s.maxArea(height) << endl;
    return 0;
}
