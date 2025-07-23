package 조합;

/**
 * @link https://leetcode.com/problems/iterator-for-combination/
 * 조합 구하기
 * 문자열과, 문자열로 만들 새로운 문자열의 길이가 주어졌을때, 주어진 문자열로 만들 수 있는 새로운 모든 문자열을 구하라.
 */
class CombinationIterator {

    public CombinationIterator(String characters, int combinationLength) {

    }

    public String next() {
        return null;
    }

    public boolean hasNext() {
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        String characters = "abc";
        int combinationLength = 2;
        CombinationIterator combinationIterator = new CombinationIterator(characters, combinationLength);
    }
}