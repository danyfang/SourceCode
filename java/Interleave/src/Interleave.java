import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Interleave{
    public boolean isTInterleave(String s1, String s2, String s3) {
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
						for(int x=0; x<str3.size()-i;x++){
							//System.out.println("str3"+ str3.get(x)+" size(): " + str3.size());
							//System.out.println("str1" + str1.get(foot1));
							//System.out.println("i = :" + x);
							if(foot1<str1.size() && str1.get(foot1).equals(str3.get(x+i)) ){
								//System.out.println("str1" + str1.get(foot1));
								foot1++;
								System.out.println("pick 1");
								foot1_original++;
								break;
							}
							else  if(foot2<str2.size() && str2.get(foot2).equals(str3.get(x+i)) ){
								//System.out.println("str2" + str2.get(foot2));
								foot2++;
								System.out.println("pick 2");
								foot2_original++;
								break;
							}
							else if(foot1>1 && foot2>1) {
								//System.out.println("false 1");
								return false;
							}
						}
					}
					else if(foot1 == str1.size()){
						List<String> new_str2 = str2.subList(foot2,str2.size());
						List<String> new_str3 = str3.subList(i,str3.size());
						if(new_str2.equals(new_str3)){
							System.out.println("pick 2");
							return true;
						}else{
							return false;
						}
					}
					else if(foot2 == str2.size()){
						List<String> new_str1 = str1.subList(foot1,str1.size());
						List<String> new_str3 = str3.subList(i,str3.size());
						if(new_str1.equals(new_str3)){
							System.out.println("pick 1");
							return true;
						}else{
							return false;
						}
					}
					else if((foot1<str1.size() && foot2<str2.size()) && str1.get(foot1).equals(str2.get(foot2))){
						int foot3 = 0;
						// the goal is to find which string to go along with;
						//basically look at two characters, current one and the next one;
						//if two characters are the same, then compare the next pair to determine which string to go along with
						//and if there are still more same pairs, compare until find a different one.
						while(foot1<str1.size() && foot2<str2.size() && (i+foot3)<str3.size()){
							if(str1.get(foot1).equals(str3.get(i+foot3)) && str2.get(foot2).equals(str3.get(i+foot3))){//current characters are equal
								if(foot1+1 == str1.size()){
									foot2 = foot2_original+1;
									foot2_original++;
									foot1 = foot1_original;
									System.out.println("pick 2");
									break;
								}else if(foot2+1 == str2.size()){
									foot1 = foot1_original+1;
									foot1_original++;
									foot2 = foot2_original;
									System.out.println("pick 1");
									break;
								}
								if((foot1+1)<str1.size() && (foot2+1)<str2.size() && str1.get(foot1+1).equals(str2.get(foot2+1))){//next pair of characters are also equal
									foot1++;
									foot2++;
									foot3++;
									continue;
									//foot1 = foot1_original+1;//randomly pick,both are fine, say pick 1
									//System.out.println("pick 1");
									//break;
								}else if((foot1+1)<str1.size() && (foot2+1)<str2.size() && (foot3+i+1)< str3.size() && !str1.get(foot1+1).equals(str2.get(foot2+1))){//next pair of characters are not equal
									if(str1.get(foot1+1).equals(str3.get(foot3+i+1))){
										foot1 = foot1_original+1;
										foot1_original++;
										foot2 = foot2_original;
										System.out.println("pick 1");
										break;
									}else if(str2.get(foot2+1).equals(str3.get(foot3+i+1))){
										foot2 = foot2_original+1;
										foot2_original++;
										foot1 = foot1_original;
										System.out.println("pick 2");
										break;
									}
								}
							}
							//foot1++;
							//foot2++;
							foot3++;
						}

					}
				}
				//System.out.println("foot1: " + foot1);
				//System.out.println("foot2: " + foot2);
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
    /*
		public boolean isInterleave(String s1, String s2, String s3) {
			if (s3.length() != s1.length() + s2.length()) {
				return false;
			}
			boolean dp[][] = new boolean[s1.length() + 1][s2.length() + 1];
			for (int i = 0; i <= s1.length(); i++) {
				for (int j = 0; j <= s2.length(); j++) {
					if (i == 0 && j == 0) {
						dp[i][j] = true;
					} else if (i == 0) {
						dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
					} else if (j == 0) {
						dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
					} else {
						dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
					}
				}
			}
			return dp[s1.length()][s2.length()];
		}
		*/
    public boolean isInterleave(String s1, String s2, String s3){
    	if(s1.length()+s2.length() != s3.length()){
    		return false;
		}
		boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
    	for(int i=0; i<=s1.length(); i++){
			for(int j=0; j<=s2.length(); j++){
				if(i==0 && j==0){
					dp[i][j] = true;
				}else if(i == 0){
					dp[i][j] = dp[i][j-1] && (s2.charAt(j-1) == s3.charAt(i+j-1));
				}else if(j == 0){
					dp[i][j] = dp[i-1][j] && (s1.charAt(i-1) == s3.charAt(i+j-1));
				}else {
					dp[i][j] = (dp[i-1][j] && (s1.charAt(i-1) == s3.charAt(i+j-1)) || (dp[i][j-1] && (s2.charAt(j-1) == s3.charAt(i+j-1))));
				}
			}
		}
    	return dp[s1.length()][s2.length()];
	}
}//end class



