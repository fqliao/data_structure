package introduction;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//设计一个学生类
public class Student {

	private String sid;//学号
	private String name;//姓名
	private char gender;//性别
	private Date birthdany;//生日
	private String address;//地址
	
	public Student(String sid, String name, char gender, Date birthdany, String address) {
		super();
		this.sid = sid;
		this.name = name;
		this.gender = gender;
		this.birthdany = birthdany;
		this.address = address;
	}



	public String getSid() {
		return sid;
	}



	public void setSid(String sid) {
		this.sid = sid;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public char getGender() {
		return gender;
	}



	public void setGender(char gender) {
		this.gender = gender;
	}



	public Date getBirthdany() {
		return birthdany;
	}



	public void setBirthdany(Date birthdany) {
		this.birthdany = birthdany;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}


	//答应学生信息
	public void printStudentInfo(Student s){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("学号："+s.getSid());
		System.out.println("姓名："+s.getName());
		System.out.println("性别："+s.getGender());
		System.out.println("生日："+sdf.format(s.getBirthdany()));
		System.out.println("地址："+s.getAddress());
	}
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		c.set(1995, 5, 30);
		Date d = c.getTime();
		Student s = new Student("10001","张三丰",'男', d,"西安市高新四路50号");
		s.printStudentInfo(s);
	}



	@Override
	public String toString() {
		return "sid=" + sid + "";
	}
	

}
