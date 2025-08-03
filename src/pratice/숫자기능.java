package pratice;

public class 숫자기능 {
    public static void main(String[] args) {
        //Java에서 숫자 올림, 내림, 반올림 계산하기
        int num = 7;

//        System.out.println(7/3);

//        System.out.println(Math.ceil(7/3));
//        System.out.println(Math.floor(7/3));
//        System.out.println(Math.round(7/3));

        //Java에서 정수형 데이터끼리 나눗셈 연산을 수행하면 소수점을 버리고 정수형으로 반환
        //예) 7/3 = 2
        int a = 7;
        int b = 3;
        System.out.println(a / b);

        //소수점 정밀도 연산을 수행하기 위해서는 피 연산자 중 하나가 소수형태의 데이터이어야 한다.
        double c = 7.0;
        int d = 3;
        System.out.println(c / d);

        float e = 7.0F;
        System.out.println(e / d);

        double f = (double) 7 / 3;
        System.out.println(Math.ceil(f));
        System.out.println(Math.floor(f));
        System.out.println(Math.round(f));

    }
}
