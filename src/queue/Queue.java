package queue;

public interface Queue<T> {
	public void append(T element) throws Exception;
	public T delete() throws Exception;
	public T getFront() throws Exception;
	public boolean isEmpty();
	public int getSize();
}
