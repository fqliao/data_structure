package introduction;

public class BubbleSort {
	
	//冒泡排序算法（升序），增加一个标志位flag,判断排序是否可以提前结束，提高排序效率
	public static void BubbleSort(int[] arr){
		int len = arr.length;
		int i,j,temp;
		boolean flag = false;//true:排序完毕,false:继续排序
 		for(i=1;i<len&&flag==false;i++){
			for(j=0;j<len-i;j++){
				flag = true;
				if(arr[j]>arr[j+1]){
					flag = false;//继续排序
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
			System.out.print("i:"+i+" ");
		}
	}
	public static void main(String[] args) {
		//注意：①冒泡排序有稳定性，第一个67和第二个67排序完顺序还是不变 稳定排序算法
		//②加入标志位，以下面数组为例，外层只需要循环5次可以提前结束，若没有标志位，则循环length-1=6
		int[] arr = {11,8,67,23,45,67,12};
		BubbleSort(arr);
		System.out.println("排序后的结果：");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}

	}

}
