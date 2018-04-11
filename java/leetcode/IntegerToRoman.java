//Leetcode problem 12 Integer To Roman
//Solution written by Xuqiang Fang on 11 April, 2018 
/*
Input guranteed to be 1 ~ 3999
*/
/*
Symbol	I	V	X	L	C	D	M
Value	1	5	10	50	100	500	1,000
*/
class Solution{
    public String intToRoman(int num){
        String s = "";
        int thousand = num / 1000;
        int hundred = (num - 1000 * thousand) / 100;
        int ten = (num - 1000 * thousand - 100 * hundred) / 10;
        int digit = num % 10;
        boolean flag = true;

        for(int i = thousand; i > 0; --i){
            s += "M";
        }
        for(int i = hundred; i > 0; --i){
            if(hundred == 9){
                s += "CM";
                break;
            }
            else if(hundred == 4){
                s += "CD";
                break;
            }
            else if(hundred >= 5){
                if(flag){
                    s += "D";
                    flag = false;
                    i = i - 5;
                    if(i == 0)
                        break;
                }
            }
            s += "C";
        }
        flag = true;
        for(int i = ten; i > 0; --i){
            if(ten == 9){
                s += "XC";
                break;
            }
            else if(ten == 4){
                s += "XL";
                break;
            }
            else if(ten >= 5){
                if(flag){
                    s += "L";
                    flag = false;
                    i = i - 5;
                    if(i == 0)
                        break;
                }
            }
            s += "X";
        }
        flag = true;
        for(int i = digit; i > 0; --i){
            if(digit == 9){
                s += "IX";
                break;
            }
            else if(digit == 4){
                s += "IV";
                break;
            }
            else if(digit >= 5){
                if(flag){
                    s += "V";
                    flag = false;
                    i = i - 5;
                    if(i == 0)
                        break;
                }
            }
            s += "I";
        }

        return s;
    }	
}

public class IntegerToRoman{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.intToRoman(Integer.valueOf(args[0])));
	}
}
