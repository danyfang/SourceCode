#include <iostream>
using namespace std;
int main(){
    const int size = 10;
    int* arr[size] = {};
    for (int i=0;i<size;i++)	
	arr[i] = 0;
    cout<< arr[0] << arr[1] << endl;
    return 0;
}
