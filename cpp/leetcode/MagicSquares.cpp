//Leetcode Problem No 840 Magic Squares in Grid
//Solution written by Xuqiang Fang on 27 May, 2018

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
    int numMagicSquaresInside(vector<vector<int>>& g) {
        int m = g.size();
        int n = g[0].size(); 
        int c = 0;
        for(int i=0; i<m-2; ++i){
            for(int j=0; j<n-2; ++j){
                if(valid(g, i, j)){
                    c++;
                }
            }
        }
        return c;
    }
private:
    int valid(vector<vector<int>> &s, int i, int j){
        int d1 = s[i][j] + s[i+1][j+1] + s[i+2][j+2];
        int d2 = s[i+2][j] + s[i+1][j+1] + s[i][j+2];
        if(d1 != d2){
            return 0;
        }
        for(int x=0; x<3; ++x){
            int r = 0;
            int c = 0;
            for(int y=0; y<3; ++y){
                r += s[i+x][j+y]; 
                c += s[i+y][j+x];
            }
            if(d1 != r || d1 != c){
                return 0;
            }
        }
        return 1;
    }
};

int main(){
    Solution s;
    vector<vector<int>> grid{{4,3,8,4},{9,5,1,9},{2,7,6,2}};
    cout << s.numMagicSquaresInside(grid) << endl;
    return 0;
}
