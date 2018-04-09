#include <iostream>
#include <vector>

using namespace std;
int main()
{
    vector<int> v = {1,2,3,4,5};
    v.push_back(6);
    v.push_back(7);
    v.push_back(8);
    for(int i=0; i<v.size(); i++)
    {
        cout << v[i] << endl;
    }
    vector<int>::iterator it = v.begin();
    cout << *it << endl;
    it++;
    cout << *it << endl;
    for(it=v.begin(); it!=v.end(); it++)
    {
        
        cout << *it << endl; 
    }
    for(const auto &i : v)
    {
        cout << i << endl;
    }
    
    return 0;
}
