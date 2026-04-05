package pratice;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class MethodReferencePractice {

    public static void main(String[] args) {
        System.out.println("=== Q1: 정적 메서드 참조 ===");
        q1();

        System.out.println("\n=== Q2: 특정 객체의 인스턴스 메서드 참조 ===");
        q2();

        System.out.println("\n=== Q3: 임의 객체의 인스턴스 메서드 참조 ===");
        q3();

        System.out.println("\n=== Q4: 생성자 참조 ===");
        q4();

        System.out.println("\n=== Q5: 조합 - merge에서 메서드 레퍼런스 ===");
        q5();

        System.out.println("\n=== Q6: Comparator에서 메서드 레퍼런스 ===");
        q6();

        System.out.println("\n=== Q7: BiFunction과 메서드 레퍼런스 ===");
        q7();
    }

    // Q1: Math.abs를 메서드 레퍼런스로 바꿔보세요.
    // 기대 결과: [3, 1, 4, 1, 5]
    static void q1() {
        List<Integer> nums = List.of(-3, -1, 4, -1, 5);

        //람다식에서 파라미터와 본문에서 실행할 표현식이 1개인 이면서 인자가 동일한 경우 메서드 참조로 변경이 가능하다.
        List<Integer> result = nums.stream()
                .map(Math::abs)  // TODO: 메서드 레퍼런스로 변경
                .collect(Collectors.toList());

        System.out.println(result);
    }

    // Q2: System.out.println을 메서드 레퍼런스로 바꿔보세요.
    // 기대 결과: 각 과일이 한 줄씩 출력
    static void q2() {
        List<String> fruits = List.of("apple", "banana", "cherry");

        fruits.forEach(System.out::println);  // TODO: 메서드 레퍼런스로 변경
    }

    // Q3: String::toUpperCase를 활용해보세요.
    // 기대 결과: [HELLO, WORLD]
    static void q3() {
        List<String> words = List.of("hello", "world");

        List<String> result = words.stream()
                .map(String::toUpperCase)  // TODO: 메서드 레퍼런스로 변경
                .collect(Collectors.toList());

        System.out.println(result);
    }

    // Q4: ArrayList 생성자를 메서드 레퍼런스로 바꿔보세요.
    // 기대 결과: 빈 ArrayList 3개 생성
    static void q4() {
        List<List<String>> lists = new ArrayList<>();
        Supplier<List<String>> listFactory = ArrayList::new;  // TODO: 메서드 레퍼런스로 변경

        for (int i = 0; i < 3; i++) {
            lists.add(listFactory.get());
        }

        System.out.println("생성된 리스트 수: " + lists.size());
    }

    // Q5: Map.merge에서 Integer::sum처럼 메서드 레퍼런스를 활용해보세요.
    // 기대 결과: {apple=3, banana=2}
    static void q5() {
        String[] items = {"apple", "banana", "apple", "apple", "banana"};
        Map<String, Integer> countMap = new HashMap<>();

        for (String item : items) {
            countMap.merge(item, 1, Integer::sum);  // TODO: 메서드 레퍼런스로 변경
        }

        System.out.println(countMap);
    }

    // Q6: Comparator.comparing에서 메서드 레퍼런스를 활용해보세요.
    // 기대 결과: 문자열 길이 순 정렬 [hi, cat, hello, banana]
    static void q6() {
        List<String> words = List.of("banana", "hi", "cat", "hello");

        List<String> sorted = words.stream()
                .sorted(Comparator.comparing(String::length))  // TODO: 메서드 레퍼런스로 변경
                .collect(Collectors.toList());

        System.out.println(sorted);
    }

    // Q7: String::concat을 BiFunction으로 활용해보세요.
    // 기대 결과: "HelloWorld"
    static void q7() {
        BiFunction<String, String, String> concat = String::concat;  // TODO: 메서드 레퍼런스로 변경

        System.out.println(concat.apply("Hello", "World"));
    }
}
