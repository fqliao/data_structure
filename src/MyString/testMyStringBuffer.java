package MyString;

public class testMyStringBuffer {

	public static void main(String[] args) {
//		String str1 = new String("123");
//		String str2 = new String("123");
//		System.out.println(System.identityHashCode(str2));
//		str2 = str2.concat(str1);
//		System.out.println(System.identityHashCode(str2));
//		
//		StringBuffer str3 = new StringBuffer("123");
//		StringBuffer str4 = new StringBuffer("123");
//		System.out.println(System.identityHashCode(str3));
//		str3 = str3.append(str4);
//		System.out.println(System.identityHashCode(str3));
		
		MyStringBuffer mb1 = new MyStringBuffer("123");
		MyStringBuffer mb2 = new MyStringBuffer("123");
		System.out.println(mb2.hashCode());
		mb2 = mb2.concat(mb1);
		System.out.println(mb2.hashCode());
	}

}
