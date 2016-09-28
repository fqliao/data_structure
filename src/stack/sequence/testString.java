package stack.sequence;

public class testString {
	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "abc";
		System.out.println(s1==s2);
		String s3 = new String("abc");
		String s4 = new String("abc");
		System.out.println(s3==s4);
		System.out.println(s1.hashCode()+" "+s2.hashCode());
		System.out.println(System.identityHashCode(s1)+" "+System.identityHashCode(s2));
		System.out.println(s3.hashCode()+" "+s4.hashCode());
		System.out.println(System.identityHashCode(s3)+" "+System.identityHashCode(s4));
	}
}
