import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		String[] test1 = new String[1];
		test1[0] = "1234";
		//method 참조는
		//메서드 매개변수가 static 메서드의 인자로 사용되는 경우 축약할 수 있는 문법이지.
		Arrays.stream(test1).forEach(s -> {System.out.println(s);});
	}
}
