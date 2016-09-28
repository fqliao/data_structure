package queue.link;

//节点类
public class Node {
	private Object element;//数据域
	private Node next;//指针域
	
	//头节点的构造方法
	public Node(Node nextVal) {
		this.next = nextVal;
	}
	
	//非头结点的构造方法
	public Node(Object element,Node nextVal){
		this.element = element;
		this.next = nextVal;
	}
	
	//获得当前节点的后继节点
	public Node getNext(){
		return this.next;
	}
	
	//获得当前节点数据域的值
	public Object getElement(){
		return this.element;
	}
	
	//设置当前节点是指针域
	public void setNext(Node nextVal){
		this.next = nextVal;
	}
	
	//设置当前节点的数据域
	public void setElement(Object element){
		this.element = element;
	}

	@Override
	public String toString() {
		return "Node [element=" + element.toString() + "]";
	}
	
}
