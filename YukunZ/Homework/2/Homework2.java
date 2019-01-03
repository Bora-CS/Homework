public class kunge5 {

		public static void main(String[] args) {
			 String myStr  = "How are you today!";
			 char[] myChar=myStr.toCharArray();
			 myChar=zyk(myChar);
		     System.out.println(myChar);
			   
	         }  public static char[] zyk(char[] myChar) {
	        	 int a = myChar.length/2;
	        	 for (int i = 0; i < a; i++) {
	        	 	  char x;
	        	 	  x= myChar[i];
	        	 	  myChar[i]=myChar[myChar.length-i-1];
	        	 	  myChar[myChar.length-i-1]=x;
	         } 
	            return myChar;		
		     }
	         }