//Leetcode Problem No 793 Preimage Size of Factorial Zeroes Function
//Solution written by Xuqiang Fang on 6 June, 2018

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
    int preimageSizeFZF(int K){
        return (int)(binarySearch(K) - binarySearch(K-1));
    }
private:
    /*
    * use binary search to find the right bound of a number which has K traiiling zeroes
    */
    long binarySearch(int K){
        long l = 0;
        long r = 5L*(K+1);
        while(l <= r){
            long m = l + (r - l) / 2;
            long k = numTrailingZeroes(m);
            if(k > K){
                r = m - 1;
            }
            else{
                l = m + 1;
            }
        }
        return r;
    }

    /*
    * this function is trivial, it is just a function to calculate trailing zero of factorial(x)
    * the # of trailingzero of factorial(x) is determined by # of factor 5 in range[1, x]
    */
    long numTrailingZeroes(long x){
        long ans = 0;
        for(; x>0; x/=5){
            ans += x/5;
        }
        return ans;
    }
};

int main(){
    Solution s;
    cout << s.preimageSizeFZF(8) << endl;
    cout << s.preimageSizeFZF(40) << endl;
    cout << s.preimageSizeFZF(400) << endl;
    cout << s.preimageSizeFZF(40000000) << endl;
    return 0;
}
