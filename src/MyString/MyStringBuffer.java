package MyString;

public class MyStringBuffer {
	private char[] value; //字符数组
	private int count; //字符串的长度
	
	public static void arrayCopy(char[] src,int srcPos,char[] dst,int dstPos,int length)
	{   
		//如果源串起始下标+拷贝长度>源串长度或者目标串起始下标+拷贝长度>目标串长度
		if(srcPos+length>src.length||dstPos+length>dst.length)
		{
			throw new StringIndexOutOfBoundsException(length);
		}
		for(int i=0;i<length;i++)
		{
			dst[dstPos++]=src[srcPos++];
		}
	}
	
	private void expandCapacity(int newCapacity)
	{
	   char newValue[] = new char[newCapacity];
	   System.out.println(newValue.hashCode());
	   System.out.println(value.hashCode());
	   arrayCopy(value,0,newValue,0,count);
	   value=newValue; //让value指向新创建的newValue数组,改变MyString中的字符数组值
	   System.out.println(value.hashCode());
	   //count=newCapacity;
	}
	
    public MyStringBuffer(String str)
    {
    	char[] chararray = str.toCharArray();
    	value=chararray;
    	count=chararray.length;
    }
    
    public MyStringBuffer concat(MyStringBuffer str)
    {
    	int otherLen = str.length();
    	if(otherLen==0)
    	{
    		return this;
    	}
    	this.expandCapacity(count+otherLen);
    	arrayCopy(str.toCharArray(),0,this.toCharArray(),this.length(),str.length());
        count+=otherLen; //改变MyString类中的长度值
        return this;//** 因为MyString中的属性值都改变了，这里没有创建新的MyString,因此对象地址当然没有改变，String中是new的！
    }
    
    public int length()
    {
    	return count;
    }
    
    @Override
	public String toString() {
		// TODO Auto-generated method stub
		String str="";
		for(int i=0;i<count;i++)
		{
			str+=value[i];
		}
		return str;
	}
    
    public char[] toCharArray()
	{
	   
	   return value;
	}
}
