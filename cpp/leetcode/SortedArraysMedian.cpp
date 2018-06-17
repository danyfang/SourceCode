//Leetcode Problem No 4 Median of Two Sorted Arrays
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
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2){
        const int n1 = nums1.size();
        const int n2 = nums2.size();
        if(n1 > n2){
            return findMedianSortedArrays(nums2, nums1);
        }
        const int k = (n1 + n2 + 1) / 2;
        cout << "k = " << k << endl;
        /*
        * l is the number of elements from nums1, l ~ [0, n1]
        */
        int l = 0;
        int r = n1;
        while(l < r){
            int m1 = l+(r-l)/2;
            int m2 = k - m1;
            if(nums1[m1] < nums2[m2-1]){
                l = m1+1;
            }
            else{
                r = m1;
            }
        }
        cout << "l = " << l << endl;
        const int m1 = l;
        const int m2 = k-l;
        const int c1 = max(m1 <= 0 ? INT_MIN : nums1[m1-1], m2 <= 0 ? INT_MIN : nums2[m2-1]);
        if((n1+n2)%2 == 1){
            return c1;
        }
        const int c2 = min(m1 == n1 ? INT_MAX : nums1[m1], m2 == n2 ? INT_MAX : nums2[m2]);
        return (double)(c1+c2) / 2.0;
    }
};

int main(){
    Solution s;
    vector<int> nums1{-1,1,3,5,7,9};
    vector<int> nums2{2,4,6,8,10,12,14,16};
    vector<int> num1{2,3};
    vector<int> num2{1,4};
    cout << s.findMedianSortedArrays(nums1, nums2) << endl;
    cout << s.findMedianSortedArrays(num1, num2) << endl;
    return 0;
}
