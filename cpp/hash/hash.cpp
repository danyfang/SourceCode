#include <iostream>
using namespace std;

const int SIZE = 117;
const int MaxLoop = 10;

class HashTable{
private:
	int* table;

public:
	HashTable(){
		table = new int[SIZE];
		for (int i=0; i<SIZE; i++)
			table[i] = -1;
	}
	
	void insert(int value){
		int hash = value%SIZE;
		int count = 0;
		while(table[hash] != -1 && table[hash] != value && (count < MaxLoop)){
			hash = (hash+1) % SIZE;
			count++;
			cout << "count = " << count << endl;
		}

		if (count==MaxLoop)
			cout << "insertion failure!" << endl;
		table[hash] = value;
	}

	int retrieve(int value){
		int hash = value%SIZE;
		int count = 0;
		while(table[hash] != -1 && table[hash] != value && (count < MaxLoop))
			hash = (hash+1) % SIZE;
			count++;
		if(table[hash] == -1)
			return -1;
		else 
			return table[hash];
	}
	
	~HashTable(){
		delete[] table;
	}
};


int main(){
	HashTable t;
	for (int i=51; i<250; i++)
		t.insert(i);
	for (int i=0; i<102; i++)
		cout<< t.retrieve(i) << endl;
	return 0;
}
