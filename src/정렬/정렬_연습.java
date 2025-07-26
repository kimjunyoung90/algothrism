package 정렬;

import java.util.*;

public class 정렬_연습 {
    public static void main(String[] args) {
        int[] numbers = {5, 3, 8, 1, 9, 2};
        //오름차순 정렬
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));

        String[] names = {"banana", "apple", "orange", "grape"};
        //내림차순 정렬
        Arrays.sort(names, Collections.reverseOrder());
        System.out.println(Arrays.toString(names));

        //객체 정렬
        List<Student> students = new ArrayList<>(List.of(
                new Student("Alice", 85),
                new Student("Bob", 92),
                new Student("Charlie", 85),
                new Student("David", 75)
        ));
        students.sort(Comparator.comparing((Student s) -> s.score).reversed()
                .thenComparing(s -> s.name));
        students.forEach(student -> System.out.println(student.name));

        //다중 조건 정렬 후 TopN 추출

        List<Product> products = new ArrayList<>(List.of(
                new Product("A", 5000, 4),
                new Product("B", 3000, 5),
                new Product("C", 7000, 3),
                new Product("D", 2000, 5),
                new Product("E", 6000, 4)
        ));

        products.sort(Comparator.comparing(Product::getRating).reversed()
                .thenComparing(Product::getPrice));

        List<Product> top3 = products.subList(0, Math.min(3, products.size()));
        top3.forEach(s -> System.out.println(s.name));
    }
    static class Student {
        String name;
        int score;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
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
