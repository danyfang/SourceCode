//Leetcode Problem No 638 Shopping Offers
//Solution written by Xuqiang Fang on 1 June, 2018

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
    int shoppingOffers(vector<int>& price, vector<vector<int>>& special, vector<int>& needs) {
        return helper(price, special, needs, 0); 
    }

private:
    //the idea is if the offer is valid, we use it and use recursion to find the best among the rest
    int helper(vector<int>& price, vector<vector<int>>& special, vector<int>& needs, int pos){
        int ans = direct(price, needs);
        for(int i=pos; i<special.size(); ++i){
            vector<int>& offer = special[i];
            vector<int> temp;
            for(int j=0; j<needs.size(); ++j){
                if(offer[j] > needs[j]){
                    temp.clear();
                    break;
                }
                temp.push_back(needs[j] - offer[j]);
            }
            if(temp.size()){
                ans = min(ans, offer.back()+helper(price, special, temp, i));
            }
        }
        return ans;
    }
    int direct(vector<int>& p, vector<int>& n){
        int s = 0;
        for(int i=0; i<p.size(); ++i){
            s += p[i] * n[i];
        }
        return s;
    }
};

int main(){
    Solution s;
    vector<int> price{2,5};
    vector<vector<int>> special{{3,0,5},{1,2,10}};
    vector<int> needs{3,2};
    cout << s.shoppingOffers(price, special, needs) << endl;
    return 0;
}
