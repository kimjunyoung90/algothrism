/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42577?language=java
 * 한 전화번호가 다른 전화번호의 접두어인지 확인하는 알고리즘
 * - phone_book의 길이는 1 이상 1,000,000 이하
 * - 각 전화번호의 길이는 1 이상 20 이하
 * - 같은 전화번호가 중복해서 들어있지 않습니다.
 * - 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return
 */
public class 전화번호_접두어 {
    public static void main(String[] args) {
        String[] phone_book = { "119", "97674223", "1195524421" };

        Boolean hasPrefix = !solution(phone_book);

        System.out.println(hasPrefix);
    }

    private static boolean solution(String[] phone_book) {

        if(phone_book.length == 1) return true;

        for (int i = 0; i < phone_book.length; i++) {

            String prefix = phone_book[i];

            for (int j = 0; j < phone_book.length; j++) {

                if(i == j) continue;
                String prefixCheckTarget = phone_book[j];
                if(prefixCheckTarget.indexOf(prefix) == 0) return false;

            }
        }

        return true;
    }
}
