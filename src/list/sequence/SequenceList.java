package list.sequence;

import java.util.Arrays;

import list.List;

public class SequenceList<T> implements List<T>{
	private int defautSize = 6;//默认顺序表大小
	private int capacity;//顺序表的容量 maxSize
	private int count = 0;//顺序表的当前大小 count
	private Object[] list;//以对象数组来组织顺序表
	public SequenceList() {
		init(defautSize);
	}
	public SequenceList(int size) {
		init(size);
	}
	private void init(int size) {
		this.capacity = size;
		list = new Object[this.capacity];
	}
	//增加元素
	@Override
	public int add(int index,T element){
		if(index<0 || index>this.count){//注意是this.size 没有-1 包含插在了最后
			throw new IndexOutOfBoundsException("线性表索引越界");
		}
		while(this.capacity < (this.count+1)){//若增加的元素使线性表容量不够，则扩容
			this.capacity <<= 1;
			list = Arrays.copyOf(list, this.capacity);
		}
		System.arraycopy(list, index, list, index+1, this.count-index);
		list[index] = element;
		this.count++;
		return 1;
	}
	
	//查询元素
	@SuppressWarnings("unchecked")
	@Override
	public T get(int index){
		if(index<0 || index>this.count-1){
			throw new IndexOutOfBoundsException("线性表索引越界");
		}
		
		return (T) list[index];
	}
	//删除元素
	@Override
	public int delete(int index){
		if(index<0 || index>this.count-1){
			throw new IndexOutOfBoundsException("线性表索引越界");
		}
		System.arraycopy(list, index+1, list, index, this.count-index-1);
		list[this.count-1] = null;
		this.count--;
		return 1;
	}
	//修改元素
	@Override
	public int update(int index, T element){
		if(index<0 || index>this.count-1){
			throw new IndexOutOfBoundsException("线性表索引越界");
		}
		list[index] = element;
		return 1;
	}
	//判断线性表是否为空
	@Override
	public boolean isEmpty(){
		return this.count == 0;
	}
	//清空线性表
	@Override
	public void clear(){
		Arrays.fill(list, null);
		this.count = 0;
	}
	@Override
	public String toString() {
		return "List [defautSize=" + defautSize + ", capacity=" + capacity + ", count=" + count + ", list="
				+ Arrays.toString(list) + "]";
	}
	
}
