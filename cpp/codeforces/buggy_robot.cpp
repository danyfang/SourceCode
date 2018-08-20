//Codeforces Problem No. 888 B 
//Written by Xuqiang Fang on 16 Aug, 2018
/*
Description: Buggy Robot
Ivan has a robot which is situated on an infinite grid. Initially the robot is standing in the starting
cell (0, 0). The robot can process commands. There are four types of commands it can perform:

U — move from the cell (x, y) to (x, y + 1);
D — move from (x, y) to (x, y - 1);
L — move from (x, y) to (x - 1, y);
R — move from (x, y) to (x + 1, y).
Ivan entered a sequence of n commands, and the robot processed it. After this sequence the robot ended
up in the starting cell (0, 0), but Ivan doubts that the sequence is such that after performing it 
correctly the robot ends up in the same cell. He thinks that some commands were ignored by robot.
To acknowledge whether the robot is severely bugged, he needs to calculate the maximum possible
number of commands that were performed correctly. Help Ivan to do the calculations!
*/
#include <iostream>
#include <string>
#include <vector>
#include <unordered_map>
#include <map>
#include <unordered_set>
#include <set>
#include <stack>
#include <queue>
using namespace std;

int main(){
    int n;
    cin >> n;
    string s;
    cin >> s;
    int x = 0, y = 0;
    int ans = 0;
    for(int i=0; i<n; ++i){
        switch(s[i]){
            case 'L':
                x--;
                break;
            case 'R':
                x++;
                break;
            case 'U':
                y++;
                break;
            case 'D':
                y--;
                break;
        }
    }
    ans = n - abs(x) - abs(y);
    cout << ans << endl;
    return 0;
}
