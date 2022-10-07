package StringBuffer;

public class StringBufferMethod {
	 public static void main(String[] args) {
		 StringBuffer s= new StringBuffer("Good");
		 System.out.println(s.append("morning"));
		 System.out.println (s.insert(4, "hi"));
		 System.out.println(s.delete(4,6));
	//	 System.out.println( s.reverse());
		 System.out.println(s.replace(0, 1, "grat"));
		 System.out.println(s.length());
	     System.out.println(s.substring(4));
	     System.out.println(s.indexOf("o"));
	     System.out.println(s.charAt(5));
	     System.out.println(s.subSequence(0,3));
	}
}
