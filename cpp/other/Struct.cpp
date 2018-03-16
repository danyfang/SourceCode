#include <iostream>
#include <vector>
#include <cmath>

using namespace std;
struct unit2{
	int x;			
	int y;
};

typedef struct unit2 unit2;
template <int count>
class Hash
{
	public:
		Hash() : Array(count)
		{
			generate();
		}

		void generate()
		{
			for (auto & arr : Array)
			{
				arr.x = 1;
			}
		}

		vector<unit2> getArr()
		{
			return Array;
		}

	private:
				vector<unit2> Array;

};

int main(){
	Hash<2> h;	
	int w = 2;
	cout << pow(2,w) << endl;
	cout << "Hello" << endl;
}
