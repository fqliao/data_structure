package MyVector;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class MyVectorTest {

	@Test
	public void test() throws Exception {
		MyVector v = new MyVector(5);
		v.add(0,1);
		v.add(1,3);
		v.add(1,2);
		v.add(4);
		v.add(0,5);
		v.add(1,6);
		System.out.println(v+" size:"+v.size()+" count:"+v.count());
		System.out.println(v.get(1));
		
		System.out.println(v.contain(3));
		v.remove(3);
		System.out.println(v.contain(3));
		System.out.println(v);
	}

}
