package MyString;

public class testMyString {

	public static void main(String[] args) {
		char[] value = {'b','h','e','l','l','o','a'};
		MyString str1 = new MyString(value,1,5);
		System.out.println(str1+" "+str1.length());
		System.out.println(str1.charAt(0));
		System.out.println(str1.substring(1, 4));
		MyString str2 = new MyString("China");
		System.out.println(str2+" "+str2.length());
		System.out.println(str1.compareTo(str2));
		
		System.out.println(str1.hashCode());
		MyString str3 = str1.concat(str2);
		System.out.println(str3);
		
		MyString str4 = str1.insert(str2, 0);
		System.out.println(str4);
		
//		System.out.println(str4.delete(0, 2));
		
		MyString str = new MyString("he");
		System.out.println(str4.find(str, 0));
	}

}
