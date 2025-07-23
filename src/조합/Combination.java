package 조합;

public class Combination {
    public static void main(String[] args) {
        //조합 경우의 수 구하기
        //nCr = n-1Cr-1 + n-1Cr
        //n 개의 요소에서 r개를 선택한 경우 조합을 나타내는 수식

        int n = 3;
        int r = 2;

        System.out.println(getCombination(n, r));
    }

    static int getCombination(int n, int r) {
        if(n == r) return 1;
        if(r == 0) return 1;
        return getCombination(n - 1, r - 1) + getCombination(n - 1, r);
    }

    static int getCombination(int[] elements, int n, int r) {
        if(n == r) return 1;
        if(r == 0) return 1;
        return getCombination(elements, n - 1, r - 1) + getCombination(elements, n - 1, r);
    }
}
