#ifndef NODE_CPP 
#define NODE_CPP 

using namespace std;

class Node{
private: 
	string content;
	Node & next;
public:
	void setContent(string content){
		this->content = content;
	}
	string getContent(){
		return this->content;
	}
	
	void setNext(Node& next){
		this->next = next;
	}
	Node & getNext(){
		return this->next;
	}
	
	//constructor
	Node(string content, Node& next){
		this->content = content;
		this->next = next;
	}
	Node(string content){
		Node(content,NULL);
	}
		
};

void printList(Node &pointer){
	while(pointer.getNext() != NULL){
		cout<< pointer.getContent() << endl;
		pointer = pointer.getNext();
	}
	cout<<pointer.getContent()<< endl;
}
#endif
