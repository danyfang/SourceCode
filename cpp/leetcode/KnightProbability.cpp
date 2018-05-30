//Leetcode Problem No  688 Knight Probability in Chessboard
//Solution written by Xuqiang Fang on 30 May, 2018

#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <unordered_map>
#include <unordered_set>
#include <stack>
#include <queue>
#include <cmath>

using namespace std;
class Solution{
public:
    //this DFS solution works but can not handle large N or K
    double knightProbability_(int N, int K, int r, int c) {
        if(K == 0){
            return 1.0;
        }
        double A = dfs(N, K, r, c);
        //cout << "A = " << A << endl;
        double M = pow(8, K); 
        return A/M;
    }

    double knightProbability(int N, int K, int r, int c){
        double p = 0.0;
        if(K > 0){
            for(auto d : dir){
                if(valid(r+d[0], c+d[1], N)){
                    if(build[K-1][r+d[0]][c+d[1]] != 0){
                        p += 0.125*build[K-1][r+d[0]][c+d[1]];
                    }  
                    else{
                        p += 0.125*knightProbability(N, K-1, r+d[0], c+d[1]);
                    }
                }
            }
            build[K][r][c] = p;
            return p;
        }
        return 1.0;
    }
private:
    vector<vector<int>> dir{{-1,2},{-1,-2},{-2,1},{-2,-1},{2,1},{2,-1},{1,2},{1,-2}};
    double dfs(int N, int K, int r, int c){
        if (r < 0 || r >= N || c < 0 || c >= N || K < 0){
            return 0;
        }
        else if(K == 1){
            double count = 0;
            for(auto& d : dir){
                if(valid(r+d[0], c+d[1], N)){
                    count += 1;
                }
            }
            return count;
        }
        double sum = 0;
        for(auto& d : dir){
            sum += dfs(N, K-1, r+d[0], c+d[1]);
        }
        return sum;
    }

    bool valid(int x, int y, int N){
        if(x<0 || x>=N || y<0 || y>=N){
            return false;
        } 
        return true;
    }

    /*
    * Important, we have to declare nested vector like this, otherwise the compiler would recognize it as 
    * function declaration, thus gives out error 'C++ requires a type specifier for all declarations'
    */
    vector<vector<vector<double>>> build = 
        vector<vector<vector<double>>>(100, vector<vector<double>>(25, vector<double>(25, 0)));         
};


int main(){
    Solution s;
    cout << s.knightProbability(3,2,0,0) << endl;
    cout << s.knightProbability(8,30,6,4) << endl;
    return 0;
}
