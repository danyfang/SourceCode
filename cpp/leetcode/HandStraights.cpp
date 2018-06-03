//Leetcode Problem No 846 Hand of Straights
//Solution written by Xuqiang Fang on 3 June, 2018

#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <unordered_map>
#include <map>
#include <unordered_set>
#include <set>
#include <stack>
#include <queue>

using namespace std;
class Solution{
public:
    bool isNStraightHand(vector<int>& hand, int W) {
        int n = hand.size();
        if(n % W != 0){
            return false;
        }
        map<int, int> m;
        int l = hand[0];
        for(auto& h : hand){
            l = min(h, l);
            if(!m.count(h)){
                m[h] = 1;
            }
            else{
                m[h] += 1;
            }
        }
        int k = l;
        for(int i=0; i<n/W; ++i){
            int j=0;
            k += W;
            while(j < W){
                if(!m.count(l+j) || m[l+j] == 0){
                    return false;
                }
                m[l+j] -= 1;
                if(m[l+j] > 0){
                    k = min(l+j, k);
                }
                j++;
            }
            if(!m.count(k) && m.upper_bound(k) != m.end()){
                k = m.upper_bound(k)->first;
            }
            l = k;
        }
        return true;
    }
};

int main(){
    Solution s;
    vector<int> hand{1,2,3,6,2,3,4,7,8,1000001,1000002,1000003};
    cout << s.isNStraightHand(hand, 3) << endl;
    vector<int> han{5,1};
    cout << s.isNStraightHand(han, 2) << endl;//should be false
    return 0;
}
