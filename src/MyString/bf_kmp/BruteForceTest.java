package MyString.bf_kmp;

import static org.junit.Assert.*;

import org.junit.Test;

public class BruteForceTest {

	@Test
	public void testBruteForce() {
		String source = "abceabcd";
		String sub = "abcd";
		System.out.println(BruteForce.bruteForce(source, sub));
	}

}
