package MyString.bf_kmp;

public class BruteForce {
	
	public static int bruteForce(String source ,String sub){
		int i=0,j=0,index=-1;
		while (i<source.length() && j<sub.length()) 
		{	//逐字符匹配 
			if(source.charAt(i) == sub.charAt(j))
			{
				i++;
				j++;
			}else{
				i = i-j+1;//不等则在主串上移动一位再匹配
				j=0;//从第一位再重新开始匹配
			}
			
		}
		if(j == sub.length())
		{
			index = i-j;
		}
		return index;
	}
}
