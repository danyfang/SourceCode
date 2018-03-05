// linked list written by Xuqiang Fang on 3 March 2018

#include <stdio.h>
struct Node{
	int val;
	struct Node *next;
};
typedef struct Node Node;

void printList(Node* root){
	while(root!= NULL){
		printf("%d\n", root->val);
		root = root->next;
	}
}
int main(int argc, char** argv){
	Node x,y,z,w;
	x.val = 1;
	y.val = 2;
	z.val = 3;
	w.val = 4;
	x.next = &y;
	y.next = &z;
	z.next = &w;
	w.next = NULL;
	printList(&x);
	return 0;
}
