import java.util.Scanner;
public class HomeWork2{ //classname
    public static void main(String[] args){
        Scanner myScan = new Scanner(System.in);
		System.out.println("Input Anything: ");
		String myString = myScan.nextLine();
		String myReversedString = reverseString1(myString);
		System.out.println("Reversed Input: \n" + myReversedString);
    }
    private static String reverseString1(String myString) {
		char[] myCharArr = myString.toCharArray();
		String result = "";
		for (int a = 0; a < myCharArr.length; a++) {
			result = myCharArr[a] + result;
		}

		return result;
	}
}