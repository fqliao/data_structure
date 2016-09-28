package list.doubleLink;

//节点类
public class Node {
	private Object element;//数据域
	private Node next;//后继指针域
	private Node prior;//前驱指针域
	
	//头节点的构造方法
	public Node(Node nextVal) {
		this.next = nextVal;
	}
	
	//非头结点的构造方法
	public Node(Object element,Node nextVal){
		this.element = element;
		this.next = nextVal;
	}
	
	//获取当前节点的前驱节点
	public Node getPrior(){
		return this.prior;
	}
	//获得当前节点的后继节点
	public Node getNext(){
		return this.next;
	}
	
	//获得当前节点数据域的值
	public Object getElement(){
		return this.element;
	}
	
	//设置当前节点的前驱指针域
	public void setPrior(Node priorVal){
		this.prior = priorVal;
	}
	
	//设置当前节点是后继指针域
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
