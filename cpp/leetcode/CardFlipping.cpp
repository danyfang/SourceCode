//Leetcode Problem No  822 Card Flipping Game
//Solution written by Xuqiang Fang on 31 May, 2018

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
    int flipgame(vector<int>& fronts, vector<int>& backs) {
        vector<int> a(2001,0);    
        int n = fronts.size();
        for(int i=0; i<n; ++i){
            if(fronts[i] != backs[i]){
                a[fronts[i]]++;
                a[backs[i]]++;
            }
            else{
                a[fronts[i]] = INT_MIN;
            }
        }
        for(int i=1; i<=2000; ++i){
            if(a[i] >= 1 ){
                return i;
            }
        }
        return 0;
    }
};

int main(){
    Solution s;
    vector<int> f{1,2,4,4,7};
    vector<int> b{1,3,4,1,3};
    cout << s.flipgame(f, b) << endl;
    vector<int> fr{1,1};
    vector<int> ba{2,2};
    cout << s.flipgame(fr, ba) << endl;
    return 0;
}
