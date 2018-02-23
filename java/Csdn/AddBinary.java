import java.util.Arrays;
import java.lang.Integer;


class Solution {
    public String addBinary(String a, String b) {
		int flag = 0;
		String lon = (a.length() > b.length()) ? a:b;
		String sho = (a.length() > b.length()) ? b:a;
		int[] result = new int[lon.length()];
		for(int i=lon.length()-1; i>=0; i--){
			for(int j=sho.length()-1; j>=0; j--){
				result[i] = (int)(lon.toCharArray()[i]) + (int)(sho.toCharArray()[j]) + flag;
				flag = 0;
				if(result[i] == 2){
					result[i] = 0;
					flag = 1;
				}
			}
		}
		if(flag == 1){
			String output = "1"+ Arrays.toString(result).replaceAll("[^\\d]","");
			return output;
		}
		else{
			String output = Arrays.toString(result).replaceAll("[^\\d]","");
			return output;
		}
	}
	// decode and incode are the coversion between bianry and decimal integers
    public int decode(String s){
		if(s.equals("0")){
			return 0;
		}
        int result = 0;
        String str[] = s.split("");
        if(str.length == 0){
            return 0;
        }
        for(int i=str.length-1; i>=0; i--){
            result += Integer.parseInt(str[i])*Math.pow(2, (str.length-1-i));
        }
        return result;
    }
    public String incode(int a){
		int b = a;
		int size = 0;
		if(a == 0){
			return "0";
		}
		while(b>0){
			b = b/2;
			size++;
		}
		int[] result = new int[size];
		for(int i=0; i<size; i++){
			result[i] = a/((int)Math.pow(2,(size-1-i)));	
			a = a - (int)(Math.pow(2,(size-1-i)))*result[i];
		}
		return Arrays.toString(result).replaceAll("[^\\d]", "");
    }
}

public class AddBinary{
	public static void main(String[] args){
		String a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
		String b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
		Solution s = new Solution();
		//System.out.println(s.decode("1010"));
		//System.out.println(s.decode("1011"));
		//System.out.println(s.incode(10));
		//System.out.println(s.incode(11));
		System.out.println(s.decode(a));
		System.out.println(s.decode(b));
		System.out.println(s.addBinary(a,b));

	}
}
