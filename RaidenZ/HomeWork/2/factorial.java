import java.util.Scanner;

public class factorial {
	public static void main(String[] args) {
		int i,n;
		int result = 1;
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		
//		i = n = 0;
		
		for(i=1; i<=n; i++) {
			result = result * (i+1);
		}
		System.out.println("Result of " + n + "! is " + result );
	}
}
