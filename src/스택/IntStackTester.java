package 스택;

import java.util.Scanner;

public class IntStackTester {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		IntStack s = new IntStack(64);
		
		while(true) {
			System.out.println("현재 데이터 수 : " + s.size() + " / " + s.capacity());
			System.out.print("(1)푸시 (2)팝 (3)피크 (4)덤프 (5)요소 찾기 (6)스택 비우기 (7) 스택 용량 체크하기 (8) 스택 현재 사이즈 확인하기 (9) 스택 비었는지 확인하기 (10) 스택 꽉차있는지 확인하기 (0)종료");
			
			int menu = stdIn.nextInt();
			if(menu == 0) break;
			
			int x;
			switch(menu) {
				case 1:
					System.out.print("데이터 : ");
					x = stdIn.nextInt();
					try {
						s.push(x);
					}catch (IntStack.OverflowIntStackException e) {
						System.out.println("스택이 가득 찼습니다.");
					}
					break;
				
				case 2:
					try {
						x = s.pop();
						System.out.println("팝한 데이터는 " + x + "입니다.");
					}catch(IntStack.EmptyInStackException e) {
						System.out.println("스택이 비어 있습니다.");
					}
					break;
				
				case 3:
					try {
						x = s.peek();
						System.out.println("피크한 데이터는 " + x + "입니다.");
					}catch(IntStack.EmptyInStackException e) {
						System.out.println("스택이 비어 있습니다.");
					}
					break;
				
				case 4:
					s.dump();
					break;
				
				case 5:
					System.out.print("찾을 데이터 : ");
					x = stdIn.nextInt();
					int idx = s.indexOf(x);
					if(idx == -1) {
						System.out.println("찾는 데이터가 없습니다.");
					}else { 
						System.out.println("x[" + idx + "]에 있습니다.");
					}
					break;
					
				case 6:
					s.clear();
					System.out.println("스택이 비워졌습니다." + s.size());
					break;
					
				case 7:
					System.out.println("현재 용량은 " + s.capacity() +"입니다.");
					break;
					
				case 8:
					System.out.println("현재 크기는 " + s.size() + "입니다.");
					break;
					
				case 9:
					if(s.isEmpty()) {
						System.out.println("현재 스택이 비워져 있습니다.");
					}else {
						System.out.println("현재 스택이 비워져 있지 않습니다.");
					}
					break;
					
				case 10:
					if(s.isFull()) {
						System.out.println("현재 스택이 가득차 있습니다.");
					}else {
						System.out.println("현재 스택이 가득차 있지 않습니다.");
					}
			}
		}
		

	}

}
