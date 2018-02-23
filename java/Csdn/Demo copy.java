import java.util.Scanner;


public class Demo{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		scan.useDelimiter("\n");
		if(scan.hasNext()){
			String str = scan.next();
			System.out.println("The input string is: \n" + str);
		}
		for(int i=100; i<1000; i++){
			int handred = i/100;
			int decimal = (i-handred*100)/10;
			int digit = i-100*handred-10*decimal;
			if(i == (handred*handred*handred+decimal*decimal*decimal+digit*digit*digit)){
				System.out.println(i);
			}
		}
		String space = " ";
		String star = "*";
		int N = 10;
		for(int i=1; i<=N; i++){
			for(int j=0; j<=(N-i)/2; j++){
				System.out.print(space);
			}
			for(int j=0; j<i; j++){
				System.out.print(star);
			}
			for(int j=0; j<(N-i)/2; j++){
				System.out.print(space);
			}
			System.out.print("\n");
		}
	}
}
