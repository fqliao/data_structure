package JavaSetFrame;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapDemo {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer,String>();
		map.put(1, "a");
		map.put(2, "b");
		map.put(1, "c");
		
		//用entrySet遍历
		Set<Entry<Integer, String>> entrySet = map.entrySet();//map中Entry[]集合Set
		Iterator<Entry<Integer, String>> itEntry = entrySet.iterator();
		while(itEntry.hasNext()){
			System.out.println(itEntry.next().getValue());
		}
		
		//用keySet遍历
		Set<Integer> set = map.keySet();//键的集合Set
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()){
			System.out.println(map.get(it.next()));
		}
	}
}
