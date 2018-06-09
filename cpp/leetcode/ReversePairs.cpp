//Leetcode Problem No  493 Reverse Pairs
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
    int reversePairs(vector<int>& nums) {
        int n = nums.size();
        int count = mergesort(nums, 0, n);
        return count;
    }
private:
    int mergesort(vector<int> &nums, int left, int right){
        if(right - left <= 1){
            return 0;
        }
        int mid = left + (right - left) / 2;
        int count = mergesort(nums, left, mid) + mergesort(nums, mid, right);
        vector<int> cache(right-left, 0);
        int i = left, j = mid, k = 0;
        for(int x=mid; x<right; ++x){
            if((long)nums[mid-1] > (long)nums[x]*2){
                count += binarySearch(nums, left, mid, nums[x]);
            }
        }
        //the following is a standard merge sort routine
        while(i < mid && j < right){
            if(nums[j] < nums[i]){//it comes from the right half
                cache[k++] = nums[j++]; 
            }  
            else{
                cache[k++] = nums[i++];
            }
        }
        while(i < mid){//j == right
            cache[k++] = nums[i++];
        }
        while(j < right){
            cache[k++] = nums[j++]; 
        }
        for(int x=0; x<right-left; ++x){
            nums[x+left] = cache[x];
        }
        return count;
    }

    int binarySearch(vector<int> &nums, int left, int right, int p){
        int l = left;
        int r = right;
        while(l < r){
            int m = l + (r - l) / 2;
            if((long)nums[m] > (long)p * 2){
                r = m;
            }
            else{
                l = m + 1;
            }
        }
        return right - l;
    }
};

//this is another solution based on binary search tree;
//but it TLE
/*
* Imagine a BST is built and the answer would just be some basic queries 
*/
struct Node{
    int val, cnt;
    Node* left;
    Node* right;
    Node(int v){
        val = v;
        cnt = 1;
        left = nullptr;
        right = nullptr;
    }
};
/*
*cnt is the total number of elements in the subtree rooted at
* current node that are greater than or equal to val
*/
class BST{
public:
    int reversePairs(vector<int> &nums){
        int ans = 0;
        Node* root = nullptr;
        for(auto n : nums){
            int t = search(root, n*2L+1);
            cout << "t = " << t << endl;
            ans += t;
            root = insert(root, n);
        }
        print(root);
        destroy(root);
        return ans; 
    }
private:
    void print(Node* root){
        if(root != nullptr){
            print(root->left);
            cout << root->val << " " << root->cnt << endl;
            print(root->right);
        }
    }
    int search(Node* root, long val){
        if(root == nullptr){
            return 0;
        }
        else if(val == root->val){
            return root->cnt;
        }
        else if(root->val > val){
            return root->cnt + search(root->left, val);
        }
        return search(root->right, val);
    }
    Node* insert(Node* root, int val){
        if(root == nullptr){
            root = new Node(val);
        }
        else if(root->val == val){
            root->cnt++;
        }
        else if(root->val > val){
            root->left = insert(root->left, val);
        }
        else{
            root->cnt++;
            root->right = insert(root->right, val);
        }
        return root;
    }
    void destroy(Node* root){
        if(root != nullptr){
            destroy(root->left);
            destroy(root->right);
            delete root;
        }
    }
};

int main(){
    Solution s;
    vector<int> nums{1,3,2,3,1};
    vector<int> num{2,4,3,5,1};
    vector<int> nu{4,4,4,4,4,1};
    cout << s.reversePairs(nums) << endl;
    cout << s.reversePairs(num) << endl;
    cout << s.reversePairs(nu) << endl;

    
    BST b;
    cout << "BST based solution" << endl;
    cout << b.reversePairs(nums) << endl;
    return 0;
}
