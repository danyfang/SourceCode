//This source code demostrates that you cannot put functions inside struct
#include <stdio.h>

struct Vertex
{
    int x, y, z;
    void setZero()
    {
        x = 0;
        y = 0;
        z = 0;
    }
};

int main()
{
    Vertex v;
    v.setZero();
    printf("%d\n", v.y);
    return 0;
}
