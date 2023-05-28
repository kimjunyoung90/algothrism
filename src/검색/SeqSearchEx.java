package 검색;

import java.util.Scanner;

//선형검색 연습문제
public class SeqSearchEx {
	
	static void printAns(int num) {
		System.out.print("   |");
		for(int i = 0; i < num; i++) {
			System.out.print("  " + i);
		}
		System.out.println();
		
		System.out.print("---+");
		for(int i = 0; i < num; i++) {
			System.out.print("---");
		}
		System.out.println();
	}
	
	static int seqSearch(int[] a, int num, int key) {
		for(int i = 0; i < num; i++) {
			System.out.print("   |");
			for(int j = 0; j < i; j++) {
				System.out.print("   ");
			}
			System.out.print("*\n");
			System.out.print("  " + i+"|");
			for(int j = 0; j < num; j++) {
				System.out.print(a[j] + "  ");
			}
			System.out.println();
			System.out.println("   |");
			if(a[i] == key) {
				return i;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		//요소수
		Scanner stdIn = new Scanner(System.in);
		System.out.print("요소수 : ");
		int num = stdIn.nextInt();
		
		int[] a = new int[num];
		
		for(int i = 0; i < num; i++) {
			System.out.print("x[" + i + "] : ");
			a[i] = stdIn.nextInt();
		}
		
		System.out.print("찾으려는 값은?");
		int key = stdIn.nextInt();
		
		printAns(num);
		
		int idx = seqSearch(a, num, key); 
		
		if(idx == -1) {
			System.out.println("찾는 값이 없습니다.");
		}else {
			System.out.println(key + "은(는) n[" + idx + "]에 있습니다.");
		}
	}
}
