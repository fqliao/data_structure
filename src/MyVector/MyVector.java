package MyVector;

import java.util.Arrays;
import java.util.List;

public class MyVector implements Collection {
	
	private Object[] data;//对象数组保存数据
	private int size;
	final static int defaultSize = 1;
	private int count;//实际大小
	
	public MyVector() {
		init(defaultSize);
	}
	
	public MyVector(int size) {
		init(size);
	}

	private void init(int size) {
		this.size = size;
		this.count = 0;
		data = new Object[this.size];
	}

	@Override
	public void add(int index, Object element) throws Exception {
		if(index<0 || index>this.size)
		{
			throw new Exception(index+"");
		}
		if(count == size){//数据个数等于空间大小了就增大一个空间
			data = Arrays.copyOf(data, size+1);
			size++;
		}
		System.arraycopy(data, index, data, index+1, size-index-1);
		data[index] = element;
		count++;
		
	}

	@Override
	public void add(Object element) throws Exception {
		add(count, element);
	}

	@Override
	public void set(int index, Object element) throws Exception {
		if(index<0 || index>this.size)
		{
			throw new Exception(index+"");
		}
		data[index] =element;

	}

	@Override
	public Object get(int index) throws Exception {
		if(index<0 || index>this.size)
		{
			throw new Exception(index+"");
		}
		return data[index];
	}

	@Override
	public int size() {
		return this.size;
	}
	
	public int count() {
		return this.count;
	}
	@Override
	public void removeByIndex(int index) throws Exception {
		if(index<0 || index>this.size)
		{
			throw new Exception(index+"");
		}
		if(get(index)!=null)
		{
			count--;	
		}
		System.arraycopy(data, index+1, data, index, size-index-1);//往前覆盖一次
		data = Arrays.copyOf(data, size-1);//删除最后重复的元素
		size--;
	}

	@Override
	public void remove(Object element) throws Exception {
		for (int i = 0; i < size; i++) {
			if(element.equals(get(i))){
				removeByIndex(i);
			}
		}
	}

	@Override
	public boolean contain(Object element) throws Exception {
		for (int i = 0; i < size; i++) {
			if(element == null && element == get(i)){
				return true;
			}
			if(element == null && element != get(i)){
				return false;
			}
			if(element != null && element.equals(get(i))){
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return Arrays.toString(data);
	}

	

}
