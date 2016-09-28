package list.jiguchuanhua;

import list.cycleLink.CycleLinkList;
import list.cycleLink.Node;
/**
 * 数据结构+算法（变量和逻辑（条件+操作））
 * @author lfq
 *
 */
public class Game {
	private CycleLinkList<Integer> list;//利用单向循环链表作为数据结构
	private int total;//玩家总数
	private int key;//数数 数到几退出，这里退出将节点数据设置为-1
	
	public Game(int total, int key) {
		super();
		this.list = new CycleLinkList<Integer>();
		this.total = total;
		this.key = key;
	}
	
	public void play(){
		//构造链表，将游戏的数据结构组织起来
		for (int i = 0; i < total; i++) {
			list.add(i, i);
		}
		for (int i = 0; i < list.getSize(); i++) {
			System.out.print(list.get(i)+" ");
		}
		System.out.println("\n======游戏开始======");
		
		//设置一个变量，记录当前人数 刚开始为total  变量设置考虑清楚***
		int count = total;
		//设置一个循环变量，当变量的值整除key值时，对于的节点的值设置为-1 表示退出，不参与下次数数
		int j = 0;
		Node node = list.getHead();
		//注意while和if中判断条件 逻辑关系要清楚****
		while (count!=1) {//人数不到1 就得继续玩
			node = node.getNext();
			//头结点和值被设置为-1的节点不参与游戏数数了
			if(node.getElement()!= null && (Integer.parseInt(node.getElement().toString()))!=-1){
				j++;
				if(j%key==0){
					node.setElement(-1);
					count--;
					for (int i = 0; i < list.getSize(); i++) {
						System.out.print(list.get(i)+" ");
					}
					System.out.println();
				}
			}
		}
		for (int i = 0; i < list.getSize(); i++) {
			if(list.get(i)!=-1){
				System.out.print("最后保留的元素为："+list.get(i)+" ");
			}
		}
		
	}
	
	public static void main(String[] args) {
		Game game = new Game(10,3);
		game.play();
	}
}
