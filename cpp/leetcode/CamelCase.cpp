//Leetcode Problem No 1023. Camelcase Matching
//Solution written by Xuqiang Fang on 9 May, 2019

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
    vector<bool> camelMatch(vector<string>& queries, string pattern) {
        vector<bool> ans;
        for(auto& s: queries){
            ans.push_back(compare(s, pattern));
        }
        return ans;
    }
private:
    bool compare(string& a, string& b){
        int i = 0;
        int j = 0;
        while(i < a.size() && j < b.size()){
            if(a[i] == b[j]){
                ++i;
                ++j;
            }
            else if(a[i] >= 'a' && a[i] <= 'z'){
                i++;
            }
            else{
                return false;
            }
        }

        while(i < a.size() && a[i] >= 'a' && a[i] <= 'z'){
            ++i;
        }
        if(i == a.size() && j < b.size()){
            return false;
        }
        if(i == a.size() && j == b.size()){
            return true;
        }
        return false;
    }
};
int main(){
  Solution s;
  vector<string> queries{"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"};
  string pattern{"FB"};
  auto ans = s.camelMatch(queries, pattern);
  for(auto a : ans){
    cout << a <<  " ";
  }
  cout << endl;
  queries = {"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"};
  pattern = "FoBa";
  ans = s.camelMatch(queries, pattern);
  for(auto a : ans){
    cout << a <<  " ";
  }
  cout << endl;  
  return 0;
}
