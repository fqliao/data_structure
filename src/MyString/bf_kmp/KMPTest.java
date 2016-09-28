package MyString.bf_kmp;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class KMPTest {

	@Test
	public void test() {
		String src = "ababcababa";
		String sub = "ababa";
		System.out.println(Arrays.toString(KMP.getNext(sub)));
		System.out.println(KMP.kmp(src, sub));
	}

}
