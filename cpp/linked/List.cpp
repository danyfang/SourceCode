#include<iostream>
#include "Node.cpp"
using namespace std;

int main(){
	Node head = Node("0");
	Node a = Node("A");
	Node b = Node("B");

	head->setNext(a);
	a->setNext(b);
	printList(head);
	return 0;
}


