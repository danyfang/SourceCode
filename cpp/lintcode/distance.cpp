
//Leetcode Problem No 
//Solution written by Xuqiang Fang on 

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
    /**
     * @param s: the list of binary string
     * @return: the max distance
     */
    int getAns(vector<string> &s) {
        // Write your code here
        helper(s, 0);
        return ans;
    }
private:
    int ans;
    void helper(vector<string>& s, int i){
        vector<string> left, right;
        int l = 0, r = 0;
        for(auto& t : s){
            if(t[i] == '0'){
                if(t.size() > i+1)
                    left.push_back(t);
                l = max(l, (int)t.size());
            }
            else{
                if(t.size() > i+1)
                    right.push_back(t);
                r = max(r, (int)t.size());
            }
        }
        if(l+r-2*(i+1) < ans)
            return;
        if(l > i && r > i){
          ans = l+r-2*i;
        }
        if(left.size() > 1){
            helper(left, i+1);
        }
        if(right.size() > 1){
            helper(right, i+1);
        }
    }
};

int main(){
  Solution s;
  vector<string> st{"011000","0111010","01101010"};
  st = {"011000","0111011","01001010"};
  cout << s.getAns(st) << endl;
  return 0;
}
