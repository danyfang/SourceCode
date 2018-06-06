//Leetcode Problem No 327 Count of Range Sum
//Solution written by Xuqiang Fang on 5 June, 2018

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
    //naive algorithm
    int countRangeSum_(vector<int>& nums, int lower, int upper) {
        int n = nums.size();
        if(n == 0){
            return 0;
        }
        vector<long> s(n, 0);
        s[0] = (long)nums[0];
        for(int i=1; i<n; ++i){
            s[i] += s[i-1] + (long)nums[i];
        }
        int count = 0;
        for(int i=0; i<n; ++i){
            if(s[i] <= upper && s[i] >= lower){
                count++;
            }
            for(int j=i+1; j<n; ++j){
                int t = s[j] - s[i];
                if(t <= upper && t >= lower){
                    count++;
                }
            }
        }
        return count;
    }
    
    //use mergesort
    int countRangeSum(vector<int> &nums, int lower, int upper){
        int n = nums.size();
        if(n == 0){
            return 0;
        }
        vector<long> s(n+1, 0);
        for(int i=0; i<n; ++i){
            s[i+1] += s[i] + (long)nums[i];
        }
        return countSort(s, 0, n+1, lower, upper); 
    }
private:
    int countSort(vector<long> &s, int l, int r, int low, int upp){
        if(r - l <= 1){
            return 0;
        }
        int m = l + (r-l)/2;
        int count = countSort(s, l, m, low, upp) + countSort(s, m, r, low, upp);
        int j = m, k = m, t = m;
        vector<long> cache(r-l, 0);
        for(int i=l, v=0; i<m; ++i, ++v){
            while(k < r && s[k] - s[i] < low){
                k++;
            }
            while(j < r && s[j] - s[i] <= upp){
                j++;
            }
            while(t < r && s[t] < s[i]){
                cache[v++] = s[t++];
            }
            cache[v] = s[i];
            count += j - k;
        }
        for(int i=0; i<t-l; ++i){
            s[i+l] = cache[i];
        }
        return count;
    }
};


class Xuqiang{
public:
    int countRangeSum(vector<int> &nums, int lower, int upper){
        int n = nums.size();
        if(n == 0){
            return 0;
        }
        vector<long> sums(n+1, 0);
        for(int i=0; i<n; ++i){
            sums[i+1] = sums[i] + (long)nums[i];
        }
        return mergesort(sums, lower, upper, 0, n+1);
    }
private:
    int mergesort(vector<long> &nums, int lower, int upper, int left, int right){
        if(right - left <= 1){
            return 0;
        }
        int m = left + (right - left) / 2;
        int count = mergesort(nums, lower, upper, left, m) + mergesort(nums, lower, upper, m, right);
        vector<long> cache(right-left, 0);
        //now the elements in nums[left, m] and nums[m+1, right] are both sorted
        //we need three indexes to denote the position in left part , right part and cache
        //but here, we used five indexes 
        int i, j, k, l, t;
        for(i=left, j=m, k=m, l=m, t=0; i<m && j<right; ++i){
            while(j<right && nums[j] < nums[i]+lower){
                j++;
            }
            while(k<right && nums[k] <= nums[i]+upper){
                k++;
            }
            while(l<right && nums[l] < nums[i]){
                cache[t++] = nums[l++];
            }
            cache[t++] = nums[i];
            count += k-j;
        }
        for(int x=0; x<l-left; ++x){
            nums[left+x] = cache[x];
        }
        return count;
    }
};

int main(){
    Solution s;
    vector<int> nums{-2,5,-1};
    cout << s.countRangeSum(nums, -2, 2) << endl;
    //cout << s.countRangeSum_(nums, -2, 2) << endl;
    vector<int> num{-2147483647,0,-2147483647,2147483647};
    cout <<s.countRangeSum(num, -564, 3864) << endl;
    Xuqiang x;
    cout << x.countRangeSum(nums, -2, 2) << endl;
    cout << x.countRangeSum(num, -564, 3864) << endl;
    //cout << s.countRangeSum_(num, -564, 3864) << endl;
    return 0;
}
