package MyString.bf_kmp;

public class KMP {

	//根据给定的模式串，求next[j]的算法
	public static int[] getNext(String sub)
	{
		int j=0,k=-1;
		int[] next = new int[sub.length()];
		next[0]=-1;
		
		while(j<sub.length()-1)
		{
			if(k == -1 || sub.charAt(j)==sub.charAt(k))
			{
				j++;
				k++;
				next[j]=k;
			}
			else
			{
				k=next[k];
			}
		}
		return next;
	}
	
	//根据给定主串和子串，采用KMP算法
	public static int kmp(String src,String sub)
	{
		//先生成模式串sub的next[j]
		int[] next = getNext(sub);
		
		//i:主串的游标
		//j:子串的游标
		int i=0,j=0,index=-1;
		while(i<src.length()&&j<sub.length())
		{
			if(src.charAt(i)==sub.charAt(j))
			{
				i++;
				j++;
 			}
			else if(j==0)
			{
				i++;
			}
			else
			{
				j=next[j]; //向右滑动
			}
				
		}
		if(j==sub.length())
		{
			index = i-sub.length();
		}
		return index;
	}
}
