package list.link;

import java.util.Stack;

import list.List;

/**
 * @decription:链表
 * @version:1.1
 * @date: 2016年10月30日下午5:31:32
 * @author: lfq
 * 
 * @param <T>
 */
public class LinkList<T> implements List<T> {
	
	private Node head;//头结点
	private Node current;//当前节点
	private int size;//节点数
	
	//初始化一个空链表
	public LinkList(){
		this.head = new Node(null);//头指针指向头节点
		current = this.head;//当前节点等于头结点
		this.size = 0 ;//初始大小为空
	}
	
	//定位节点，定位到当前索引节点
	public void position(int index){ //定位范围index-->[-1,size-1]
		if(index<-1 || index > size-1){
			throw new IndexOutOfBoundsException("索引越界");
		}
		//如果当前节点是头结点，则不用往前查了,结束
		if(index == -1 && this.current == this.head){
			return;
		}
		int j = 0;//循环变量
		this.current = this.head.getNext();//***将当前节点设置到第一个节点
		while(this.current!=null && j<index){
			this.current = this.current.getNext();
			j++;
		}
	}
	
	//查找节点并删除查找到的节点
	public Node find(T element){ //定位范围index-->[0,size-1]
		Node node = null;
		if(element == null)
			return null;
		int j = 0;//循环变量
		this.current = this.head.getNext();//***将当前节点设置到第一个节点
		while(this.current!=null){
			if(element.equals(this.current.getElement()))
			{
				node = this.current;
				delete(j);
			}
			this.current = this.current.getNext();
			j++;
		}
		return node;
	}
	
	//打印链表(正向打印)
	public void printPre(){
		position(0);
		while(current != null)
		{
			System.out.print(current.getElement()+" ");
			current = current.getNext();
		}
	}
	
	//打印链表(反向打印) 利用栈结构的先进后出原则
	@SuppressWarnings("unchecked")
	public void printPos(){
		position(0);
		Stack<T> stack = new Stack<>();
		while(current != null)
		{
			stack.push((T) current.getElement());
			current = current.getNext();
		}
		while(!stack.isEmpty())
		{
			System.out.print(stack.pop()+" ");
		}
	}
	
	
	@Override
	public int add(int index, T element) {//插入范围index-->[0,size]
		if(index<0 || index > size){
			throw new IndexOutOfBoundsException("索引越界");
		}
		position(index-1);//定位到该节点的前一个节点（***这句在下一句之前 否则功能实现但是多了很多指针，不可约，一定要由执行步骤画图分析）
		Node newNode = new Node(element,this.current.getNext());
		this.current.setNext(newNode);
		size++;
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(int index){
		if(index<-1 || index > size-1){
			throw new IndexOutOfBoundsException("索引越界");
		}
		position(index);
		return (T) this.current.getElement();
	}

	@Override
	public int delete(int index){//定位范围index-->[0,size-1]
		if(index<0 || index > size-1){
			throw new IndexOutOfBoundsException("索引越界");
		}
		position(index-1);
		this.current.setNext(this.current.getNext().getNext());
		size--;
		return 0;
	}

	@Override
	public int update(int index, T element) {
		if(index<-1 || index > size-1){
			throw new IndexOutOfBoundsException("索引越界");
		}
		position(index-1);
		this.current.getNext().setElement(element);
		return 0;
	}

	@Override
	public boolean isEmpty() {
		
		return this.size == 0;
	}
	
	@Override
	public void clear() {
		this.head.setNext(null);
		this.size = 0;
		
	}
	
	public int getSize(){
		return this.size;
	}

}
