package MyVector;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class MySetTest {

	@Test
	public void test() throws Exception {
		MySet s = new MySet();
		s.add(1);
		s.add(2);
		s.add(2);
		s.add(3);
		s.remove(2);
		
		MySet otherSet = new MySet();
		otherSet.add(1);
		System.out.println(s.include(otherSet));
		System.out.println(otherSet.include(s));
		System.out.println(s.equals(otherSet));
		
		System.out.println("====");
		otherSet.add(3);
		System.out.println(otherSet.include(s));
		System.out.println(s.equals(otherSet));
		
		System.out.println(s.size()+" "+s.isEmpty());
		s.remove(1);
		s.remove(3);
		System.out.println(s.size()+" "+s.isEmpty());
		
		
	}

}
