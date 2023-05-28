package 검색;

import java.util.Scanner;

/**
 * 선형검색
 * */
public class SeqSearch {
	
	//요소수가 n인 배열 a에서 key와 같은 요소를 선형검색한다.
	static int seqSearch(int[] a, int n, int key) {
//		int i = 0;
//		while(true) {
//			if(i == n)
//				return -1;
//			if(a[i] == key) 
//				return i;
//			i++;
//		}
		
		for(int i = 0; i < n; i++) {				
			if(a[i] == key) 
				return i;
		}
		
		return -1;
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("요소수 : ");
		
		int num = stdIn.nextInt();
		
		int[] x = new int[num];
		
		for(int i = 0; i < num; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = stdIn.nextInt();
		}
		
		System.out.print("검색할 값: ");
		int ky = stdIn.nextInt();
		
		int idx = seqSearch(x, num, ky);
		
		if(idx == -1) {
			System.out.println("그 값의 요소가 없습니다.");
		}else {
			System.out.println(ky + "는 x[" + idx + "]에 있습니다.");
		}

	}

}
