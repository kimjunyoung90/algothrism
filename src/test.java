import java.util.*;

public class test {
    public static void main(String[] args) {
        Integer[] arr = {5, 3, 1, 4};
        //내림차순
        Arrays.sort(arr, Collections.reverseOrder());
        System.out.println(Arrays.toString(arr));
        //객체 정렬
        class Person {
            String name;
            int age;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getAge() {
                return age;
            }

            public void setAge(int age) {
                this.age = age;
            }
        }

        List<Person> people = new ArrayList<>();
        people.sort(Comparator.comparing(p -> p.age));
        people.sort(Comparator.comparing(Person::getAge).reversed());

        // Map 정렬
        Map<String, Integer> map = new HashMap<>();
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
        entries.sort(Map.Entry.comparingByValue());

        //배열 자르기
        int[] original = {10, 20, 30, 40, 50};

        //인덱스 1부터 4전까지
        int[] sliced = Arrays.copyOfRange(original, 1, 4);
        System.out.println(Arrays.toString(sliced));

        //숫자를 문자열로 변환하는 방법
        int num = 123;
        String str;
        str = String.valueOf(num);
        str = Integer.toString(num);
        str = "" + num;
        System.out.println(str instanceof String);
    }
}
