package 스택;

/**
 * generic 클래스에서 서브 클래스를 생성하기 위해서는 static으로 선언해야한다.
 * @author wnsdu
 *
 * @param <E>
 */
public class Gstack<E> {
	
	private int max;
	private int ptr;
	private E[] stk;
	
	//--- 실행 시 예외 : 스택이 비어 있음 ---//
	public static class EmptyGstackException extends RuntimeException {
		public EmptyGstackException() { }
	}

	//--- 실행 시 예외 : 스택이 가득 참 ---//
	public static class OverflowGstackException extends RuntimeException {
		public OverflowGstackException() { }
	}
	
	public Gstack(int capacity) {
		ptr = 0;
		max = capacity;
		try {
			//generic 타입의 배열을 초기화 하는경우 하단과 같이 해야함
			stk = (E[])new Object[max];
		}catch(OutOfMemoryError e) {
			max = 0;
		}
	}
	
	public E push(E x) throws OverflowGstackException{
		if(ptr >= max) throw new OverflowGstackException();
		return stk[ptr++] = x;
	}
	
	public E pop() throws EmptyGstackException {
		if(ptr <= 0) throw new EmptyGstackException();
		return stk[--ptr];
	}
	
	//스택에서 정상에 있는 데이터를 들여다봄?!
	public E peek() throws EmptyGstackException {
		if(ptr <= 0) throw new EmptyGstackException();
		return stk[ptr - 1];
	}
	
	public int indexOf(E x) {
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
