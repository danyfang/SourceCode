//Leetcode Problem No 954 Array of Doubled Pairs
//Solution written by Xuqiang Fang on 10 Dec, 2018

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
    bool canReorderDoubled(vector<int>& A) {
        vector<int> ne, po;
        for(auto& a : A){
            if(a > 0){
                po.push_back(a);
            }
            else if(a < 0){
                ne.push_back(a);
            }
        }
        if(po.size() % 2 != 0 || ne.size() % 2 != 0){
            return false;
        }
        sort(po.begin(), po.end());
        sort(ne.begin(), ne.end(), greater<int>());
        if(ne.size() == 0 && valid(po)){
            return true;
        }
        else if(po.size() == 0 && valid(ne)){
            return true;
        }
        if(valid(ne) && valid(po)){
            return true;
        }
        return false;
    }
private:
    bool valid(vector<int>& A){
        const int n = A.size();
        vector<int> flag(n, 0);
        int l = 0, r = 0;
        while(l < n && r < n){
            if(!flag[l]){
                flag[l] = 1;
                r = max(l+1, r);
                while(r < n){
                    if(A[r] == 2 * A[l] && !flag[r]){
                        flag[r] = 1;
                        r++;
                        break;
                    }
                    r++;
                }
            }
            l++;
        }
        for(auto& f : flag){
            if(!f)
                return false;
        }
        //cout << "valid\n";
        return true;
    }
};

int main(){
    Solution s;
    vector<int> A{3,1,3,6};
    cout << s.canReorderDoubled(A) << endl;
    A = {4,-2,2,-4};
    cout << s.canReorderDoubled(A) << endl;
    A = {1,2,4,16,8,4};
    cout << s.canReorderDoubled(A) << endl;
    A = {2,1,2,6};
    cout << s.canReorderDoubled(A) << endl;
    A = {2,1,2,4};
    cout << s.canReorderDoubled(A) << endl;
    return 0;
}
