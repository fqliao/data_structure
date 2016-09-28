package stack.application;

import java.util.Stack;

import stack.link.LinkStack;

/**
 * 中缀表达式转后缀表达式
 * @author Administrator
 *
 */
public class testInffixToSuffix {
	
	/**
	 * 传入前缀表达式转换为后缀表达式
	 * @param inffixExp
	 * @return
	 */
	public static String translate(String inffixExp){
		StringBuilder suffixExp = new StringBuilder("");
		//用Java自带的栈数据结构 注意Java的栈结构利用了泛型特性，线性表也一样，ArrayList都用了泛型 因此方便使用，不用以后强转
		Stack<Character> stack = new Stack<Character>();
		char[] exp = inffixExp.toCharArray();
		char[] ope = {'(',')','[',']','{','}','+','-','*','/'};
		for (int i = 0; i<exp.length; i++) {
			if(exp[i] == ' '){//若是空格则忽略
				
			}
			if(Character.isDigit(exp[i])){//是数字则加入队列
				suffixExp.append(exp[i]);
			}
			if(exp[i] == ope[6] || exp[i] == ope[7]){//符号是+ 或 - 若栈顶为括号则加入符号，否则弹出栈中符号加入队列，再将该符号入栈
				while(!stack.isEmpty() && (stack.peek() != ope[0] && stack.peek() != ope[2]  && stack.peek() != ope[4])){
					suffixExp.append(stack.pop());
				}
				stack.push(exp[i]);
			}
			if(exp[i] == ope[8] || exp[i] == ope[9]){//符号是* 或 / 若栈顶为括号则加入符号，否则弹出栈中符号优先级高于或等于该符号的符号（* /）加入队列，再将该符号入栈
				while(!stack.isEmpty() && (stack.peek() == ope[8] || stack.peek() == ope[9])){
					suffixExp.append(stack.pop());
				}
				stack.push(exp[i]);
			}
			if(exp[i] == ope[0] || exp[i] == ope[2] || exp[i] == ope[4]){//若是左括号，则直接入栈
				stack.push(exp[i]);
			}
			if(exp[i] == ope[1]){//如果是右小括号，则将栈中的符号依次弹出放入输出队列，直到遇到左小括号
				while((char)stack.peek() != ope[0]){
					suffixExp.append(stack.pop());
				}
				stack.pop();//弹出左小括号
			}
			if(exp[i] == ope[3]){//如果是右中括号，则将栈中的符号依次弹出放入输出队列，直到遇到左中括号
				while(stack.peek() != ope[2]){
					suffixExp.append(stack.pop());
				}
				stack.pop();//弹出左中括号
			}
			if(exp[i] == ope[5]){//如果是右大括号，则将栈中的符号依次弹出放入输出队列，直到遇到左大括号
				while(stack.peek() != ope[4]){
					suffixExp.append(stack.pop());
				}
				stack.pop();//弹出左大括号
			}
		}
		//最后，若栈中还有符号，则将所有符号弹出，放入队列
		while(!stack.isEmpty()){
			suffixExp.append(stack.pop());
		}
		return suffixExp.toString();
	}
	
	/**
	 * 传入后缀表达式计算
	 * @param suffixExp
	 * @return
	 * @throws Exception
	 */
	public static int calculate(String suffixExp) throws Exception{
		LinkStack stack = new LinkStack();
		char[] c = suffixExp.toCharArray();
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
		String inffixExp1 = "3+(2-5)*6/3";
		String inffixExp2 = "(2+1)*3-5";
		String inffixExp3 = "2-{[3+(5-2)]*3-1}";
		String suffixExp1 = translate(inffixExp1);
		String suffixExp2 = translate(inffixExp2);
		String suffixExp3 = translate(inffixExp3);
		int r1 = calculate(suffixExp1);
		int r2 = calculate(suffixExp2);
		int r3 = calculate(suffixExp3);
		System.out.println(inffixExp1+" --> "+suffixExp1+" = "+r1);
		System.out.println(inffixExp2+" --> "+suffixExp2+" = "+r2);
		System.out.println(inffixExp3+" --> "+suffixExp3+" = "+r3);
	}

}
