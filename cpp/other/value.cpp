#include <iostream>


void swap(int &x, int &y);

int main(){
	int x = 0;
	int y = 1;
	swap(x,y);
	std::cout << x <<" " << y << std::endl;
	std::swap(x,y);
	std::cout << x <<" " << y << std::endl;
}
void swap(int &x, int &y)
{
	int temp = std::move(x);
	x = std::move(y);
	y = std::move(temp);
}

