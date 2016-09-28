package list.link;

import list.List;

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
	public void position(int index){
		if(index<-1 || index > size-1){
			throw new IndexOutOfBoundsException("索引越界");
		}
		//如果当前节点是头结点，则不用往前查了,结束
		if(index == -1){
			return;
		}
		int j = 0;//循环变量
		this.current = this.head.getNext();//***将当前节点设置到第一个节点
		while(this.current!=null && j<index){
			this.current = this.current.getNext();
			j++;
		}
	}
	@Override
	public int add(int index, T element) {
		if(index<-1 || index > size){
			throw new IndexOutOfBoundsException("索引越界");
		}
		position(index-1);//定位到该节点的前一个节点（***这句在下一句之前 否则功能实现但是多了很多指针，不可约，一定要由执行步骤画图分析）
		Node newNode = new Node(element,this.current.getNext());
		this.current.setNext(newNode);
		size++;
		return 0;
	}

	@Override
	public T get(int index){
		if(index<-1 || index > size-1){
			throw new IndexOutOfBoundsException("索引越界");
		}
		position(index);
		return (T) this.current.getElement();
	}

	@Override
	public int delete(int index){
		if(index<-1 || index > size-1){
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
