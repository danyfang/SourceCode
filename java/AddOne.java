class Solution {
    public int[] plusOne(int[] digits) {
        int[] temp = digits;
		int flag = 0;
        for(int i=digits.length-1; i>=0; i--){
			if(i == digits.length-1){
				temp[i] = temp[i] + 1;
			}else{
				temp[i] = temp[i] + flag;
			}
			flag = 0;
			if(temp[i] >= 10){
				flag = 1;
				temp[i] = temp[i] - 10;
			}
        }
		// the most siginifant one adds to 10;
		if(flag == 1){
			int[] newTemp = new int[temp.length+1];
			newTemp[0] = 1;
			for(int i=0; i<temp.length; i++){
				newTemp[i+1] = temp[i];
			}
			return newTemp;
		}
		return temp;
    }
}
public class AddOne{
	public static void main(String[] args){
		//todo
		Solution s = new Solution();
		int[] digit = {9,9,9,9};
		int[] result = s.plusOne(digit);
		for(int i=0; i<result.length; i++){
			System.out.println(result[i]);
		}

	}
}
