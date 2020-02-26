/**
由于远古的宇宙战争的原因，伞屉文明是一个二维世界里的文明，所以你可以这样理解发电基站的位置与他们的链接关系：给你一个一维数组a，长度为n，表示了n个基站的位置高度信息。数组的第i个元素a[i]表示第i个基站的海拔高度是a[i],而下标相邻的基站才相邻并且建立链接，即x号基站与x-1号基站、x+1号基站相邻。特别的，1号基站仅与2号相邻，而n号基站仅与n-1号基站相邻。当一场海拔高度为y的洪水到来时，海拔高度小于等于y的基站都会被认为需要停止发电，同时断开与相邻基站的链接。


输入描述:
每个输入数据包含一个测试点。

第一行为一个正整数n，表示发电基站的个数 (0 < n <= 200000)

接下来一行有n个空格隔开的数字，表示n个基站的海拔高度，第i个数字a[i]即为第i个基站的海拔高度，对于任意的i(1<=i<=n),有(0 <= a[i] < 2^31-1)

接下来一行有一个正整数q(0 < q <= 200000)，表示接下来有q场洪水

接下来一行有q个整数，第j个整数y[j]表示第j场洪水的海拔为y[j],对于任意的j(1<=j<=n),有(-2^31 < y[j] < 2^31-1)

输出描述:
输出q行，每行一个整数，第j行的整数ans表示在第j场洪水中，发电基站会被分割成ans个集群。标准答案保证最后一个整数后也有换行。
**/

#include<iostream>
#include<vector>
using namespace std;
int islands(vector<int>& station, int flood){
    int c = 0, ans = 0;
    for(auto s : station){
        if(s <= flood){
            if(c > 0){
                ans++;
            }
            c = 0;
        }
        else{
            c++;
        }
    }
    if(c > 0) ans++;
    return ans;
}

int main(){
    int n, q, a;
    cin >> n;
    vector<int> station, flood;
    while(n-- > 0){
        cin >> a;
        station.push_back(a);
    }
    cin >> q;
    while(q-- > 0){
        cin >> a;
        flood.push_back(a);
    }
    for(auto f : flood){
        cout << islands(station, f) << endl;
    }
    return 0;
}
