package com.bilgeadam.egitim.hql;

public class RememberMe {
	
	// dizi
	public static void array(int[] dizi) {
		for (int temp : dizi) {
			System.out.print(temp + " ");
		}
	}
	
	public static void array2(int... dizi) {
		for (int temp : dizi) {
			System.out.print(temp + " ");
		}
	}
	
	public static void main(String[] args) {
		int[] dizi = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		
		array(dizi);
		
		System.out.println("");
		array2(dizi);
	}
	
}
