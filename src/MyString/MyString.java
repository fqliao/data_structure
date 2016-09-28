package MyString;

import java.util.Arrays;

public class MyString {
	private char[] value;//字符数组作为串的值
	private int count;//串的长度
	
	//构造方法1 构造一个空字符串
	public MyString(){
		value = new char[0];
		count = 0;
	}
	//构造方法2 根据已有的字符数组创建字符串
	public MyString(char[] value) {
		this.value = value;
		this.count = value.length;
	}
	//构造方案3 根据已有的字符串数组并指定字符构造字符串
	public MyString(char[] value,int offset,int len){
		if(offset<0)
		{
			throw new StringIndexOutOfBoundsException(offset);
		}
		if(len<0)
		{
			throw new StringIndexOutOfBoundsException(len);
		}
		if(offset+len>value.length)
		{
			throw new StringIndexOutOfBoundsException(offset+len);
		}
		this.value = new char[len];
		this.count = len;
		arrayCopy(value, offset, this.value, 0, len);
		
	}
	
	//构造方案4 使用JDK本身的String类，构造新的字符串
	public MyString(String str){
		char[] value = str.toCharArray();
		this.value = value;
		this.count = value.length;
	}
	
	/**
	 * 字符数组拷贝
	 * @param src 原数组
	 * @param srcPos 原数组的起始位置
	 * @param dst 目的数组
	 * @param dstPos 目的数组的起始位置
	 * @param len  拷贝长度
	 */
	public static void arrayCopy(char[] src,int srcPos,char[] dst,int dstPos,int len){
		if(srcPos<0)
		{
			throw new StringIndexOutOfBoundsException(srcPos);
		}
		if(dstPos<0)
		{
			throw new StringIndexOutOfBoundsException(dstPos);
		}
		if(srcPos+len>src.length || dstPos+len>dst.length)
		{
			throw new StringIndexOutOfBoundsException(len);
		}
		for (int i = 0; i < len; i++) 
		{
			dst[dstPos++] = src[srcPos++];
		}
	}
	
	//将MyString转换为字符数组，即返回其字符数组即可
	public char[] toArrayChar(){
		return value;
	}
	
	//1 取字符
	public char charAt(int index){
		if(index<0 || index >= count)
		{
			throw new StringIndexOutOfBoundsException(index);
		}
		return value[index];
	}
	
	//2 求长度
	public int length(){
		return count;
	}

	//3 字符串比较
	public int compareTo(MyString str){
		int len1 = count;
		int len2 = str.length();
		int n = Math.min(len1, len2);
		int i = 0;
		while (i<n) {
			char c1 = value[i];
			char c2 = str.charAt(i);
			if(c1 != c2)
			{
				return c1-c2;
			}
			i++;
		}
		return len1-len2;
	}
	
	//4 取子串
	public MyString substring(int beginIndex,int endIndex){
		if(beginIndex<0)
		{
			throw new StringIndexOutOfBoundsException(beginIndex);
		}
		if(endIndex>count)
		{
			throw new StringIndexOutOfBoundsException(endIndex);
		}
		if(endIndex-beginIndex<0)
		{
			throw new StringIndexOutOfBoundsException(endIndex-beginIndex);
		}
		return (beginIndex == 0 && endIndex == count)?this:new MyString(value, beginIndex, endIndex-beginIndex);
	}
	
	//4.1 取子串
	public MyString substring(int pos){
		return substring(pos,this.count);
	}
	
	//5 连接字符串
	public MyString concat(MyString str){
		int len1 = str.length();
		if(len1 == 0){
			return this;
		}
		int len2 = this.count;
		int newLen = len1+len2;
		char[] newValue = Arrays.copyOf(this.value, newLen);//注意，变更长度后要接收改变后的字符数组
		arrayCopy(str.toArrayChar(), 0, newValue, len2, len1);
		return new MyString(newValue);
	}
	
	//6 插入子串insert(str, pos)
	public MyString insert(MyString str,int pos){
		if(pos<0 || pos>this.count)
		{
			throw new StringIndexOutOfBoundsException(pos);
		}

		//获得插入点之前的子串
		MyString str1 = this.substring(0,pos);
		//获得插入点之后的子串
		MyString str2 = this.substring(pos);
		
		return str1.concat(str).concat(str2);
	
	}
	
	//7 删除字符串
	public MyString delete(int beginIndex,int endIndex){
		if(beginIndex < 0){
			throw new StringIndexOutOfBoundsException(beginIndex);
		}
		if(endIndex > this.count){
			throw new StringIndexOutOfBoundsException(endIndex);
		}
		if(endIndex-beginIndex < 0){
			throw new StringIndexOutOfBoundsException(endIndex-beginIndex);
		}
		//获得删除字符串的前段
		MyString str1 = this.substring(0, beginIndex);
		//获得删除字符串的后段
		MyString str2 = this.substring(endIndex);

		return str1.concat(str2);
	}
	
	//8 打印串
	@Override
	public String toString() {
		String str = "";
		for (int i = 0; i < count; i++) {
			str+=value[i];
		}
		return str;
	}
	
	//9 查找子串 Brute-Force算法
	public int find(MyString str,int start){
		int len = str.length();
		MyString str2;
		for (int i = start; i < count; i++) {
			if(i+len>count){//超越了长度则没有找到
				return -1;
			}
			str2 = this.substring(i, i+len);
			if(str.compareTo(str2)==0)
			{	
				return i;//返回查到的第一个字符串的位置
			}
		}
		return -1;//没有查找到
	}
}
