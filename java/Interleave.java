import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
		ArrayList<String> str1 = new ArrayList<>();
		ArrayList<String> str2 = new ArrayList<>();
		ArrayList<String> str3 = new ArrayList<>();
		str1.addAll(Arrays.asList(s1.split("")));
		str2.addAll(Arrays.asList(s2.split("")));
		str3.addAll(Arrays.asList(s3.split("")));
		int foot1 = 0;
		int foot2 = 0;
		int foot1_original = 0;
		int foot2_original = 0;


		if(str1.get(0).equals("")){
			if(str2.get(0).equals("")){
				if(str3.get(0).equals("")){
					return true;
				}else{
					return false;
				}
			}else{
				if(str2.equals(str3)){
					return true;
				}else{
					return false;
				}
			}
		}else{
			if(str2.get(0).equals("")){
				if(str1.equals(str3)){
					return true;
				}else{
					return false;
				}
			}else{
				//System.out.println("s1 and s2 not vacant!");
				for(int i=0; i<str3.size();i++){
					if((foot1<str1.size() && foot2<str2.size()) && !str1.get(foot1).equals(str2.get(foot2)) ){
						for(int x=0; x<str3.size();x++){
							//System.out.println("str3"+ str3.get(x)+" size(): " + str3.size());
							//System.out.println("str1" + str1.get(foot1));
							//System.out.println("i = :" + x);
							if(foot1<str1.size() && str1.get(foot1).equals(str3.get(x)) ){
								//System.out.println("str1" + str1.get(foot1));
								foot1++;
								foot1_original++;
							}
							if(foot2<str2.size() && str2.get(foot2).equals(str3.get(x)) ){
								//System.out.println("str2" + str2.get(foot2));
								foot2++;
								foot2_original++;
							}
							else if(foot1>1 && foot2>1) {
								//System.out.println("false 1");
								return false;
							}
						}
					}
					else if((foot1<str1.size() && foot2<str2.size()) && str1.get(foot1).equals(str2.get(foot2))){
						int foot3 = 0;
						//todo
						//if two characters are the same, then compare the next pair to determine which string to go along with
						//and if there are still more same pairs, compare until find a different one.
						while(foot1<str1.size() && foot2<str2.size() && (i+j)<str3.size()){
							if(str1.get(foot1).equals(str3.get(i+j)) && str2.get(foot2).equals(str3.get(i+j)))
							foot1++;
							foot2++;
							foot3++;
						}

					}
				}
				System.out.println("foot1: " + foot1);
				System.out.println("foot2: " + foot2);
				//System.out.println(str3.get(0).equals(""));
				//System.out.println(foot1 != str1.size());
				//System.out.println(str1.size());
				if(foot1 == str1.size() && foot2 == str2.size()&&(foot1+foot2 == str3.size())){
					return true;
				}
				else {
					//System.out.println("false 2");
					return false;
				}
			}
		}//end if str2
	}//end if str1
}//end class
public class Interleave{
	public static void main(String[] args){
		Solution s = new Solution();
		//System.out.println(s.isInterleave(s1,s2,s3));
		//System.out.println(s.isInterleave(s1,s2,s4));
		String s5 = "aa";
		String s6 = "ab";
		String s7 = "aaba";
		System.out.println(s.isInterleave(s5,s6,s7));
		
	}
}


