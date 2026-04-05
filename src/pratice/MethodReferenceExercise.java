package pratice;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class MethodReferenceExercise {

    public static void main(String[] args) {
        System.out.println("=== 연습 1: 정적 메서드 참조 ===");
        exercise1();

        System.out.println("\n=== 연습 2: 특정 객체의 인스턴스 메서드 참조 ===");
        exercise2();

        System.out.println("\n=== 연습 3: 임의 객체의 인스턴스 메서드 참조 ===");
        exercise3();

        System.out.println("\n=== 연습 4: 생성자 참조 ===");
        exercise4();
    }

    // 연습 1: 정적 메서드 참조
    // 아래 람다를 메서드 레퍼런스로 바꿔보세요.
    static void exercise1() {
        List<String> numbers = List.of("1", "2", "3", "4", "5");

        // TODO: 람다 -> 메서드 레퍼런스로 변경
        List<Integer> result = numbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println(result);
    }

    // 연습 2: 특정 객체의 인스턴스 메서드 참조
    // 아래 람다를 메서드 레퍼런스로 바꿔보세요.
    static void exercise2() {
        List<String> words = List.of("hello", "world", "java");
        StringBuilder sb = new StringBuilder();

        // TODO: 람다 -> 메서드 레퍼런스로 변경
        words.forEach(sb::append);

        System.out.println(sb.toString());
    }

    // 연습 3: 임의 객체의 인스턴스 메서드 참조
    // 아래 람다를 메서드 레퍼런스로 바꿔보세요.
    static void exercise3() {
        List<String> words = List.of("banana", "apple", "cherry");

        // TODO: 람다 -> 메서드 레퍼런스로 변경
        List<String> sorted = words.stream()
                .sorted(String::compareTo)
                .collect(Collectors.toList());

        System.out.println(sorted);
    }

    // 연습 4: 생성자 참조
    // 아래 람다를 메서드 레퍼런스로 바꿔보세요.
    static void exercise4() {
        List<String> numbers = List.of("1", "2", "3");

        // TODO: 람다 -> 메서드 레퍼런스로 변경
        List<Integer> result = numbers.stream()
                .map(Integer::new)
                .collect(Collectors.toList());

        System.out.println(result);
    }
}