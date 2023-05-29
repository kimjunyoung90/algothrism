package 스택;
/**
 * 스택 구현하기
 * @author wnsdu
 *
 */
public class IntStack {
	private int max; // 스택 용량
	private int ptr; // 스택 포인터
	private int[] stk; // 스택 본체
	
	//실행 시 예외 : 스택이 비어있음
	public class EmptyInStackException extends RuntimeException {
		public EmptyInStackException() {}
	}
	
	//실행 시 예외 : 스택이 가득 참
	public class OverflowIntStackException extends RuntimeException {
		public OverflowIntStackException() { }
	}
	
	public IntStack(int capacity) {
		ptr = 0;
		max = capacity;
		try {
			stk = new int[max];
		}catch(OutOfMemoryError e) {
			max = 0;
		}
	}
	
	public int push(int x) throws OverflowIntStackException{
		if(ptr >= max) throw new OverflowIntStackException();
		return stk[ptr++] = x;
	}
	
	public int pop() throws EmptyInStackException {
		if(ptr <= 0) throw new EmptyInStackException();
		return stk[--ptr];
	}
	
	//스택에서 정상에 있는 데이터를 들여다봄?!
	public int peek() throws EmptyInStackException {
		if(ptr <= 0) throw new EmptyInStackException();
		return stk[ptr - 1];
	}
	
	public int indexOf(int x) {
		for(int i = ptr - 1; i >= 0; i--) {
			if(stk[i] == x) 
				return i;
		}
		return -1;
	}
	
	public void clear() {
		ptr = 0;
	}
	
	//statck의 용량을 반환
	public int capacity() {
		return max;
	}
	
	//스택에 쌓여있는 데이트 수를 반환
	public int size() {
		return ptr;
	}
	
	//스택이 비어 있는가?
	public boolean isEmpty() {
		return ptr <= 0;
	}
	
	public boolean isFull() {
		return ptr >= max;
	}
	
	//스택 안의 모든 데이터를 바닥 -> 꼭대기 순서로 출력
	public void dump() {
		if(ptr <= 0) {
			System.out.println("스택이 비어 있습니다.");
		}else {
			for(int i = 0; i < ptr; i++) {
				System.out.print(stk[i] + " ");
			}
			System.out.println();
		}
	}
}
