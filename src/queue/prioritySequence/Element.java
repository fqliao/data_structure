package queue.prioritySequence;
/**
 * 优先级队列节点类
 * @author Administrator
 *
 */
public class Element {
	private Object element;//节点内容
	private int priority;//优先级
	
	public Element(Object element, int priority) {
		super();
		this.element = element;
		this.priority = priority;
	}
	public Object getElement() {
		return element;
	}
	public void setElement(Object element) {
		this.element = element;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
}
