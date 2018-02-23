class List{
    private ListNode root;
    public List(ListNode[] data){//输入是一个node 数组
        if(data == null){
            return;
        }
        for (int i=0; i<data.length; i++){
            this.add(data[i]);
        }
        
    }
     public List(int[] data){//输入是一个int 数组
        if(data == null){
            return;
        }
        for (int i=0; i<data.length-1; i++){
            this.add(new ListNode(data[i],new ListNode(data[i+1])));
        }
        
    }
    
    public int toInt(){
        int sum = 0;
        int count = 0;
        ListNode pointer = this.getRoot();
        while(pointer.getNext() != null){
            sum += pointer.getVal()*(Math.pow(10,count));
            pointer = pointer.getNext();
            count++;
        }
        sum += pointer.getVal()*(Math.pow(10,count));
	return sum;
    }
    public ListNode lastNode(){
        ListNode pointer = this.root;
        while(pointer.getNext() != null){
            pointer = pointer.getNext();
        }
        return pointer;//return the last Node 
    }
    
    
    public List(ListNode root){
        this.root = root;
    }
    
    public List(){
        
    }
    
    public void setRoot(ListNode root){
        this.root = root;
    }
    
    public ListNode getRoot(){
        return this.root;
    }
    
    public void add(ListNode newNode){
        if(this.root == null){
            this.root = newNode;
        }
	if (this.root.getNext() == null){
		this.root.setNext(newNode);
	}
        else {
            this.root.getNext().addNode(newNode);
        }
    }
    
    public class ListNode {
        private int val;
        private ListNode next;
        ListNode(){
            
        }
        ListNode(int x) { 
            val = x; 
        }
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
        public void setVal(int val){
            this.val = val;
        }
        public int getVal(){
            return this.val;
        }
        public void setNext(ListNode next){
            this.next = next;
        }
        public ListNode getNext(){
            return this.next;
        }  
        public void addNode(ListNode newNode){
            if (this.next == null){
                this.next = newNode;
            }
            else{
                this.next.addNode(newNode);
            }
        }
    }
}
 
public class Cal{
    public static int addTwoNumbers(List l1, List l2) {
        List list = new List();
        int flag = 0;
        List.ListNode pointer1 = l1.getRoot();
        List.ListNode pointer2 = l2.getRoot();
        while(pointer1.getNext()!=null || pointer2.getNext() != null){
            int sum = pointer1.getVal()+pointer2.getVal()+flag;
            flag = 0;
            if (sum >= 10){
                flag = 1;
                sum = sum%10;
            }
            list.add(new List.ListNode(sum));
            pointer1 = pointer1.getNext();
            pointer2 = pointer2.getNext();
        }
        return list.toInt();
    }
    public static void main(String [] args){
    	System.out.println(addTwoNumbers(new List(new int[] {1,2,3}),new List(new int[]{4,5,6})));
    }
}
