//Leetcode Problem No 688 Kth Smallest Number in Multiplication Table
//Solution written by Xuqiang Fang on 19 June, 2018

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
    int findKthNumber(int m, int n, int k) {
        int l = 0;
        int r = m * n + 1;
        while(l <= r){
            int mid = (l + r) / 2;
            int p = m, q = n;
            int count = 0;
            int j = n;
            int max_k = 0;
            for(int i=1; i<=m; ++i){
                while(j >= 1 && i * j > mid){
                    --j;
                }
                count += j;
                //cout << "count = " << count << endl;
                //cout << " l = " << l << ", r = " << r << endl;
                if(j == 0){
                    break;
                }
                if(i * j > max_k){
                    p = i;
                    q = j;
                    max_k = i * j;
                }
            }
            //here we have to add another return condition l == r 
            // there is a gap inbetween, so there may be several k's that correspond to the same q and p
            if(count  == k || l == r){
                return p * q;
            }
            else if(count > k){
                r = mid;
            }
            else{
                l = mid + 1;
            }
        }
        return 0;
    }
};

int main(){
    Solution s;
    //cout << s.findKthNumber(2, 3, 4) << endl;
    cout << s.findKthNumber(3423, 3423, 5422) << endl;
    return 0;
}
