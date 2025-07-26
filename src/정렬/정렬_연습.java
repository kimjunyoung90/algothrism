package 정렬;

import java.util.*;

public class 정렬_연습 {
    public static void main(String[] args) {
        int[] numbers = {5, 3, 8, 1, 9, 2};
        //오름차순 정렬
        //배열 정렬 시 Arrays.sort 사용한다.
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));

        String[] names = {"banana", "apple", "orange", "grape"};
        //내림차순 정렬
        //내림차순 정렬 시 Collections 사용한다.
        Arrays.sort(names, Collections.reverseOrder());
        System.out.println(Arrays.toString(names));


        //객체 정렬
        List<Student> students = new ArrayList<>(List.of(
                new Student("Alice", 85),
                new Student("Bob", 92),
                new Student("Charlie", 85),
                new Student("David", 75)
        ));
        //List 정렬 시 Collections 사용한다.
        //점수 기준 내림차순.. 이름 기준 오름차순
        students.sort(Comparator.comparing(Student::getScore).reversed()
                .thenComparing(Student::getName));
        //Collections를 사용하려면 Comparable 인터페이스를 상속하고 있어야 한다.
        //다중 조건 정렬 후 TopN 추출

        List<Product> products = new ArrayList<>(List.of(
                new Product("A", 5000, 4),
                new Product("B", 3000, 5),
                new Product("C", 7000, 3),
                new Product("D", 2000, 5),
                new Product("E", 6000, 4)
        ));
        //Collections 를 사용하려면 대상이 내부적으로 Comparable를 구현하고 있어야 한다.
    }

    static class Student {
        String name;
        int score;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }
    }

    static class Product {
        String name;
        int price;
        int rating;

        public Product(String name, int price, int rating) {
            this.name = name;
            this.price = price;
            this.rating = rating;
        }

        public String getName() {
            return name;
        }

        public int getPrice() {
            return price;
        }

        public int getRating() {
            return rating;
        }
    }
}
