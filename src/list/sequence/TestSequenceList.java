package list.sequence;

import java.util.Calendar;
import java.util.Date;

public class TestSequenceList {

	public static void main(String[] args) throws Exception {
		Calendar c = Calendar.getInstance();
		c.set(1991,1,10);
		Date d = c.getTime();
		Student s1 = new Student("10001","张三丰",'男', d,"西安市高新四路50号");
		Student s2 = new Student("10002","张三丰",'男', d,"西安市高新四路50号");
		Student s3 = new Student("10003","张三丰",'男', d,"西安市高新四路50号");
		Student s4 = new Student("10004","张三丰",'男', d,"西安市高新四路50号");
		SequenceList<Student> list = new SequenceList<Student>();
		list.add(0, s1);
		list.add(1, s2);
		list.add(2, s3);
		list.delete(1);
		list.add(0,s4);
		System.out.println(list);
		
		
	}
}


