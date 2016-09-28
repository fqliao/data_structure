package stack.application;

import stack.sequence.SequenceStack;


public class testBracket {
	
	//这里没有转换为char[]数组，是因为比较时时字符串而不是字符，字符串不等于字符，即使内容一样
	public static String[] expToCharArray(String exp){
		int n = exp.length();
		String[] arr = new String[n];
		for(int i=0;i<arr.length;i++)
		{
			arr[i]= exp.substring(i, i+1);
		}
		return arr;
	}
	
	public static boolean signCheck(String exp) throws Exception{
		SequenceStack stack = new SequenceStack();
		String[] arr = expToCharArray(exp);
		for (int i = 0; i < arr.length; i++) {
			if("(".equals(arr[i])||"[".equals(arr[i])||"{".equals(arr[i])){
				stack.push(arr[i]);
			}
			//判断小括号是否匹配
			else if(!stack.isEmpty() && stack.getTop().equals("(") && ")".equals(arr[i])){
				stack.pop();
			}
			//要根据右括号，来匹配弹出的左括号，顺序不能反
			else if(!stack.isEmpty() && !stack.getTop().equals("(") && ")".equals(arr[i])){
				System.out.println("左右小括号匹配次序不正确");
				return false;
			}
			//判断中括号是否匹配
			else if(!stack.isEmpty() && stack.getTop().equals("[") && "]".equals(arr[i])){
				stack.pop();
			}
			
			else if(!stack.isEmpty() && !stack.getTop().equals("[") && "]".equals(arr[i])){
				System.out.println("左右中括号匹配次序不正确");
				return false;
			}
			//判断大括号是否匹配
			else if(!stack.isEmpty() && stack.getTop().equals("{") && "}".equals(arr[i])){
				stack.pop();
			}
			else if(!stack.isEmpty() && !stack.getTop().equals("{") && "}".equals(arr[i])){
				System.out.println("左右大括号匹配次序不正确");
				return false;
			}
			//若栈为空，判断右括号多于左括号
			else if(stack.isEmpty() && (")".equals(arr[i]) || "]".equals(arr[i]) || "}".equals(arr[i]))){
				System.out.println("右括号多于左括号");
				return false;
			}
		}
		//若遍历完栈不为空，判断左括号对于右括号
		if(!stack.isEmpty()){
			System.out.println("左括号多于右括号");
			return false;
		}
		else{
			System.out.println("括号匹配正确");
			return true;
		}
	}
	
	public static void main(String[] args) throws Exception {
		String exp1 = "{a+[b+(c*a)/(d-e)]}";
		String exp2 = "([a+b)-(c*e)]+{a+b}";
		String exp3 = "{a+[b+(c*a)/(d-e)]}}";
		String exp4 = "({a+[b+(c*a)/(d-e)]}";
		signCheck(exp1);
		signCheck(exp2);
		signCheck(exp3);
		signCheck(exp4);

	}

}
