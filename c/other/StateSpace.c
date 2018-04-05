/*
Problem: 
Two cups, one can hold 3L water, the other can hold 4L water,
how to get 2L water.
*/

#include <stdio.h>
#define MIN(a,b) ((a) < (b)) ? (a) : (b)
#define M 3
#define N 4
#define G 2

typedef struct State{
	int a,b;
	const struct State* parent;
	const char* action;
} State;

State q[(M+1) * (N+1)];
int front = 0, back = 0, visited[M+1][N+1];

void Enqueue(int a, int b, const State* parent, const char* action){
	if(!visited[a][b]){
		State t = {a,b,parent, action};
		q[back++] = t;
		visited[a][b] = 1;
	}
}

void Backtrace(const State* s){
	if(s){
		Backtrace(s->parent);
		printf("(%d, %d) %s\n",s->a, s->b, s->action);
	}
}

int main(){
	Enqueue(0,0,NULL, "Initialize");
	while(front < back){
		const State* s = &q[front++];
		if(s->a == G || s->b == G){
			Backtrace(s);
			printf("\n");
			continue;
		}

		Enqueue(0,s->b,s,"Clear A");
		Enqueue(s->a, 0, s, "Clear B");
		Enqueue(M, s->b, s, "Fill A");
		Enqueue(s->a, N, s, "Fill B");

		int t1 = MIN(s->b, M-s->a);
		int t2 = MIN(s->a, M-s->b);
		Enqueue(s->a + t1, s->b - t1, s, "Fill A by B");
		Enqueue(s->a - t2, s->b + t2, s, "Fill B by A");
	}
	printf("Processed %d states\n", back);
}
