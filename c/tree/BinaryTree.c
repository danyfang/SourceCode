#include <stdio.h>
#include <stdlib.h>

struct node
{
	int data;
	struct node* left;
	struct node* right;
};

typedef struct node Node;

Node * newNode(int data)
{
	Node* node = malloc(sizeof(Node));
	node->data = data;
	node->left = NULL;
	node->right = NULL;

	return (node);
}

void postOrder(Node* node)
{
	if(node != NULL)
	{
		postOrder(node->left);
		postOrder(node->right);
		printf("%d ", node->data);
	}
	else
		return;
}

void preOrder(Node* node)
{
	if(node != NULL)
	{
		printf("%d ",node->data);
		preOrder(node->left);
		preOrder(node->right);
	}
	else
		return;
}

void inOrder(Node* node)
{
	if(node != NULL)
	{
		inOrder(node->left);
		printf("%d ",node->data);
		inOrder(node->right);
	}
	else 
		return;
}


int main(int argc, char** argv)
{
	Node* root = newNode(1);
	root->left = newNode(2);
	root->right = newNode(3);
	root->left->left = newNode(4);
	root->left->right = newNode(5);
	root->right->left = newNode(6);
	root->right->right = newNode(7);

	printf("\n Inorder traversal: \n");
	inOrder(root);
	printf("\n postOrder traversal: \n");
	postOrder(root);
	printf("\n");
	getchar();
	return 0;
}
