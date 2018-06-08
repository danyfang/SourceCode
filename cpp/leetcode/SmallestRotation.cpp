//Leetcode Problem No 798 Smallest Rotation with Highest Score
//Solution written by Xuqiang Fang on 6 June, 2018

#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <unordered_map>
#include <unordered_set>
#include <stack>
#include <queue>
#include <iterator>

using namespace std;
class Solution{
public:
    //naive version, TLE
    int bestRotation_(vector<int>& A) {
        int n = A.size();
        int K = 0;
        int s = score(A, 0);
        for(int i=1; i<n; ++i){
            int t = score(A, i);
            if(t > s){
                s = t; 
                K = i;
            } 
        }      
        return K;
    }


    /*
    * Notice that each element has at most two intervals of the # of steps it can move so that is is valid(element 
    * smaller than index)
    * then the final result is a series of queries
    *  0     1     2     3    4   
    *  2     3     1     4    0
    *[1,3] [2,3] [0,1] [4,4] [0,4]
    *            [3,4]
    * the question is how to find a most shared interval and output the left index of that interval
    * well, using the other solution, we can find the answer in O(n) time
    */
    int bestRotation(vector<int> &A){
        int n = A.size();
        vector<int> bin(n, 0);
        for(int i=0; i<n; ++i){
            if(A[i] > i){
                int left = i+1;
                int right = n-(A[i]-i);
                for(int j=left; j<=right; ++j){
                    bin[j]++;
                }
            } 
            else{
                int left1 = 0;
                int right1 = i-A[i];
                for(int j=left1; j<=right1; ++j){
                    bin[j]++;
                }
                int left2 = i+1;
                int right2 = n-1;
                for(int j=left2; j<=right2; ++j){
                    bin[j]++;
                }
            }
        }
        int K = 0;
        int t = bin[0];
        for(int i=1; i<n; ++i){
            if(bin[i] > t){
                t = bin[i];
                K = i;
            }
        }
        return K;
    }

    //solution by user@lee215
    int bestRotation__(vector<int> &A){
        int n = A.size();
        vector<int> change(n, 0);
        for(int i=0; i<n; ++i){
            change[(i-A[i]+1+n)%n] -= 1;
        }
        for(int i=1; i<n; ++i){
            change[i] += change[i-1]+1;
        }
        return distance(change.begin(), max_element(change.begin(), change.end()));
    }
private:
    int score(vector<int> &A, int K){
        int n = A.size();
        int s = 0;
        int k = K;
        for(int i=0; i <n; ++i){
            if(A[k] <= i){
                s++;
            } 
            k = (k+1)%n;
        }
        return s;
    }
};

int main(){
    Solution s;
    vector<int> A{1, 3, 0, 2, 4};
    vector<int> B{2, 3, 1, 4, 0};
    cout << s.bestRotation(A) << endl;
    cout << s.bestRotation(B) << endl;
    cout << s.bestRotation__(A) << endl;
    cout << s.bestRotation__(B) << endl;
    return 0;
}
