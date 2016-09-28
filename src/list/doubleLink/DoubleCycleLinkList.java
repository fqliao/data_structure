package list.doubleLink;

import list.List;

public class DoubleCycleLinkList<T> implements List<T> {
	
	private Node head;//头结点
	private Node current;//当前节点
	private int size;//节点数
	
	//初始化一个空链表
	public DoubleCycleLinkList(){
		this.head = new Node(null);//头指针指向头节点
		current = this.head;//当前节点等于头结点
		//循环链表的尾节点指向头节点 与单节点不同之处
		this.head.setNext(this.head);
		this.head.setPrior(this.head);
		this.size = 0 ;//初始大小为空
	}
	
	//定位节点，定位到当前节点的前一个节点
	public void position(int index){
		if(index<-1 || index > size-1){
			throw new IndexOutOfBoundsException("索引越界");
		}
		//如果当前节点是头结点，则不用往前查了,结束
		if(index == -1){
			return;
		}
		int j = 0;//循环变量
		this.current = this.head.getNext();//将当前节点设置到第一个节点
		while(this.current!=head && j<index){//当前对象不等于头结点 与单链表的不同
			this.current = this.current.getNext();
			j++;
		}
	}
	@Override
	public int add(int index, T element) {
		if(index<-1 || index > size){
			throw new IndexOutOfBoundsException("索引越界");
		}
		//先定位到该节点的前一个节点
		position(index-1);
		//创建新节点，并设置新节点的后继指针域为当前节点的下一个节点
		Node newNode = new Node(element,this.current.getNext());
		//设置当前节点的后继指针域为新节点
		this.current.setNext(newNode);
		//设置新节点的前驱指针域
		newNode.setPrior(this.current);
		//设置新节点的后面节点的前驱指针域为新节点
		newNode.getNext().setPrior(newNode);
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
		//当前节点的后继指针域设置为当前节点下下一个节点
		//注意：这样设置之后当前节点的下一个节点就不是删除的那个节点了，而是删除节点的下一个节点
		this.current.setNext(this.current.getNext().getNext());
		//当前节点的指针域已设置为了原来当前节点的下下一个节点了
		// ****注意这种错误：this.current.getNext().getNext().setPrior(this.current);
		this.current.getNext().setPrior(this.current);
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
		this.head.setNext(this.head);
		this.head.setPrior(this.head);
		this.current = this.head;
		this.size = 0;
		
	}
	
	public int getSize(){
		return this.size;
	}
	
	public Node getHead(){
		return this.head;
	}
	
}
