//Leetcode Problem No 999. Available Captures for Rook
//Solution written by Xuqiang Fang on 9 March, 2019

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
    int numRookCaptures(vector<vector<char>>& board) {
        int h, l;
        for(int i=0; i<8; ++i){
            for(int j=0; j<8; ++j){
                if(board[i][j] == 'R'){
                    h = i;
                    l = j;
                    break;
                }
            }
        }
        int ans = 0;
        //left
        int left = h-1;
        while(left >= 0){
            if(board[left][l] == 'B')
                break;
            else if(board[left][l] == 'p'){
                ans++;
                break;
            }
            left--;
        }
        int right = h+1;
        while(right < 8){
            if(board[right][l] == 'B')
                break;
            else if(board[right][l] == 'p'){
                ans++;
                break;
            }
            right++;
        }
        int up = l-1;
        while(up >= 0){
            if(board[h][up] == 'B')
                break;
            else if(board[h][up] == 'p'){
                ans++;
                break;
            }
            up--;
        }
        int down = l+1;
        while(down < 8){
            if(board[h][down] == 'B')
                break;
            else if(board[h][down] == 'p'){
                ans++;
                break;
            }
            down++;
        }
        return ans;
    }
};

int main(){
  Solution s;

  return 0;
}
