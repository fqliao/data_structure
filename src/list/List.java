package list;


public interface List<T> {
	//增加元素
		public int add(int index,T element);
		//查询元素
		public T get(int index);
		//删除元素
		public int delete(int index);
		//修改元素
		public int update(int index, T element);
		//判断线性表是否为空
		public boolean isEmpty();
		//清空线性表
		public void clear();
}
