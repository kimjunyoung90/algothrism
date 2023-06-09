package 검색;

import java.util.Arrays;
import java.util.Scanner;

//기본 자료형 배열에서 binarySearch로 이진검색하기
public class BinarySearchTester {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("요소수 : ");
		int num = stdIn.nextInt();
		int[] x = new int[num];
		
		System.out.println("오름차순으로 입력하세요.");
		
		System.out.print("x[0]: ");
		x[0] = stdIn.nextInt();
		
		for(int i = 1; i < num; i++) {
			do {
				System.out.print("x[" + i + "] : ");
				x[i] = stdIn.nextInt();
			}while(x[i] < x[i - 1]);
		}
		
		System.out.print("검색할 값 : ");
		int key = stdIn.nextInt();
		
		int idx = Arrays.binarySearch(x,  key);
		
		if(idx < 0) {
			//idx = -x 삽입포인트 - 1
			int 삽입포인트 = -(idx + 1);
			System.out.println(x[삽입포인트]);
		}else {
			System.out.println(key + "은(는) x[" + idx + "]에 있습니다.");
		}
	}

}
