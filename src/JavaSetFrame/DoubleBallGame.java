package JavaSetFrame;

import java.util.HashSet;
import java.util.Set;

public class DoubleBallGame {
	
	public static final int RedNum = 33;//红球个数
	public static final int BlueNum = 16;//蓝球个数
	public static Set<Integer> setRed;//红球集合
	public static Set<Integer> setBlue;//蓝球集合
	private static Set<Integer> sysRed;//中奖红球号码
	private static Set<Integer> sysBlue;//中奖蓝球号码
	
	public DoubleBallGame() {
		// 双色球 红球1-33 篮球1-16 无顺序要求 采用HashSet
		setRed = new HashSet<Integer>();
		setBlue = new HashSet<Integer>();
		for (int i = 1; i <= RedNum; i++) {
			setRed.add(i);
			if (i <= BlueNum) {
				setBlue.add(i);
			}
		}
		sysRed = sysRed(RedNum);
		sysBlue = sysBlue(BlueNum);
		
	}
	// 随机生成6个中奖红球号码
	private static Set sysRed(int redNum){
		Set<Integer> red = new HashSet<Integer>();
		while(red.size()!= 6) {//这里不能用for循环6次，因此Set集合不允许重复，如果遇到重复就选不到6个球
			red.add(((int)(Math.random()*100%redNum))+1);
		}
		return red;
	}
	// 随机生成1个中奖蓝球号码
	private static Set sysBlue(int blueNum){
		Set<Integer> blue = new HashSet<Integer>();
		blue.add(((int)(Math.random()*100)%blueNum)+1);
		return blue;
	}
	// 随机选择6个红球号码
	private static Set chooseRed(int redNum){
		Set<Integer> red = new HashSet<Integer>();
		while(red.size()!= 6) {//这里不能用for循环6次，因此Set集合不允许重复，如果遇到重复就选不到6个球
			int num = (int)(Math.random()*100%redNum)+1;
			red.add(num);
			setRed.remove(num);
		}
		return red;
	}
	// 随机选择1个蓝球号码
	private static Set chooseBlue(int blueNum){
		Set<Integer> blue = new HashSet<Integer>();
		int num = ((int)(Math.random()*100)%blueNum)+1;
		blue.add(num);
		setBlue.remove(num);
		return blue;
	}
		
	public static void main(String[] args) {
		DoubleBallGame doubleBallGame = new DoubleBallGame();
		Set userRed = chooseRed(RedNum);
		Set userBlue = chooseBlue(BlueNum);
		if(sysRed.equals(userRed) && sysBlue.equals(userBlue)){
			System.out.println("恭喜！中大奖了100万元！！！");
		}
		else if(sysRed.equals(userRed) && !sysBlue.equals(userBlue)){
			System.out.println("恭喜！中奖了60万元！！！");
		}
		else if(!sysRed.equals(userRed) && sysBlue.equals(userBlue)){
			System.out.println("恭喜！中奖了1千元！！！");
		}
		else{
			System.out.println("没关系！期待下次！！！");
		}

	}

}
