class Array{
	private int[] data;
	private int foot = 0;
	public Array(int len){
		if(len>0){
			this.data = new int[len];
		} else{
			this.data = new int[1];
		}
	}
	public boolean add(int num){
		if(this.foot < this.data.length){
			this.data[this.foot++] = num;
			return true;
		}
		return false;
	}
	public int[] getData(){
		return this.data;
	}

	public void increment(int num){
		int [] newArr = new int[this.data.length+num];
		System.arraycopy(this.data,0,newArr,0,this.data.length);
		this.data =  newArr;
	}
}

class SortArray extends Array{
	public SortArray(int len){
		super(len); 
	}
	public int[] getData(){
		java.util.Arrays.sort(super.getData());
		return super.getData();
	} 

}
class ReverseArray extends Array{
	public ReverseArray(int len){
		super(len);
	}
	public int[] getData(){
		int head = 0;
		int tail = super.getData().length-1;
		int center = super.getData().length/2;
		for(int i=0; i<center; i++){
			int temp = super.getData()[head];
			super.getData()[head] = super.getData()[tail];
			super.getData()[tail] = temp;
			head++;
			tail--;
		}
		return super.getData();
	}

}
public class Sort{
	public static void main(String[] args){
		ReverseArray arr = new ReverseArray(5);
		System.out.println(arr.add(8));
		System.out.println(arr.add(3));
		System.out.println(arr.add(2));
		System.out.println(arr.add(9));
		System.out.println(arr.add(11));
		System.out.println(arr.add(4));
		arr.increment(4);
		System.out.println(arr.add(8));
		System.out.println(arr.add(7));
		int result[] = arr.getData();
		for(int i=0; i<result.length; i++){
			System.out.println(result[i]);
		}
	}
}
