//Leetcode Problem No 4 Medium of Two Sorted Arrays
//Solution written by Xuqiang Fang on 27 Nov, 2019

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
    int l = 0, r = n1;
    while(l < r){
      int m1 = l + (r-l)/2;
      int m2 = k - m1;
      if(nums1[m1] < nums2[m2]){
        l = m1 + 1;
      }
      else{
        r = m1;
      }
    }
  }
};

int main(){
  Solution s;

  return 0;
}
