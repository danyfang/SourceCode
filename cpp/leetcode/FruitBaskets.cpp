//Leetcode Problem No 904 Fruit Into Baskets
//Solution written by Xuqiang Fang on 17 Sep, 2018

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
    int totalFruit(vector<int>& tree) {
        unordered_set<int> s;
        int l = -1, r = 1;
        const int n = tree.size();
        int ans = 1;
        s.insert(tree[0]);
        while(r < n){
            s.insert(tree[r]);
            if(s.size() <= 2){
                ans = max(r-l, ans);
            }
            else{
                const int tmp = tree[r-1];
                l = r-1;
                while(l >= 0 && (tree[l] == tmp || tree[l] == tree[r])){
                    l--;
                }
                if(l >= 0){
                    s.erase(tree[l]);    
                }
            } 
            ++r;
        }
        return ans;
    }
};

int main(){
    Solution s;
    vector<int> tree{1,0,1,4,1,4,1,2,3};
    cout << s.totalFruit(tree) << endl;
    tree = {3,3,3,1,2,1,1,2,3,3,4};
    cout << s.totalFruit(tree) << endl;
    return 0;
}
