package stack.application;

import stack.link.LinkStack;

public class testCalculate {
	
	public static int calculate(String exp) throws Exception{
		LinkStack stack = new LinkStack();
		char[] c = exp.toCharArray();
		int x1 = 0,x2 = 0;//用于计算的临时值
		for (int i = 0; i < c.length; i++) {
			if(Character.isDigit(c[i])){
				stack.push(c[i]);
			}else{
				 x1 = Integer.parseInt(stack.pop().toString());
				 x2 = Integer.parseInt(stack.pop().toString());
				switch(c[i]){
					case '+':
						x2 = x2 + x1;
						break;
					case '-':
						x2 = x2 - x1;
						break;
					case '*':
						x2 = x2 * x1;
						break;
					case '/':
						if(x1==0){
							throw new Exception("分母不能为0");
						}else{
							x2 = x2 / x1;
						}
						break;
				}
				stack.push(x2);	
			}
		}
		return Integer.parseInt(stack.getTop().toString());
	}
	public static void main(String[] args) throws Exception {
		String exp = "3642/-5*+";
		int result = calculate(exp);
		System.out.println(result);
	}

}
