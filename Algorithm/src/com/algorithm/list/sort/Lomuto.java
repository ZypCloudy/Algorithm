package com.algorithm.list.sort;

public class Lomuto {
	public static void main(String[] args) {
		int[] a = {2,7,2,5,6,4,9,10};
		int k = 6;
		int min = quickSelsct(a,0,a.length-1,k);
		System.out.print("第" + k + "小元素是:" + min);
	}
	public static int lomutoPartition(int[] array,int left,int right){
		int p = array[left];
		int s = left;
		for(int i = left + 1; i <= right; i++){
			if(array[i]<p){
				s++;
				swap(array,s,i);
			}
		}
		swap(array,left,s);
  		return s;
	}
	private static void swap(int[] arr, int last, int left) {
		int temp = arr[last];
		arr[last] = arr[left];
		arr[left] = temp;
	}
	public static int quickSelsct(int[] arr,int left,int right,int k){
		int s = lomutoPartition(arr,left,right);
		if(s == left+k-1)
			return arr[s];
		else if(s > left+k-1){
			return quickSelsct(arr,left,s-1,k);
		}else
			return quickSelsct(arr,s+1,right,left+k-1-s);
	}
}