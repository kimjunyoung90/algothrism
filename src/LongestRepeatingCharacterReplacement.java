public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        //window에 있는 각 문자의 개수
        int[] count = new int[26];
        int left = 0, right = 0;
        int maxFreq = 0;

        for (; right < s.length(); right++) {
            //1. 문자열 개수 세기
            count[s.charAt(right) - 'A']++;

            //2. 변경 필요한 문자의 개수 확인
            //2-1. 최대 많이 나온 문자의 개수 확인(현재 추가된 문자 포함해서 지속적 갱신)
            maxFreq = Math.max(maxFreq, count[s.charAt(right) - 'A']);

            //2-2. 변경 필요한 문자 수 확인
            int windowSize = right - left + 1;
            int needToChange = windowSize - maxFreq;

            //3. 변경 필요한 문자가 k개 이하이면 우측으로 window 크기 확장
            //= k개 초과하면 left pointer 이동
            while (needToChange > k) {

                //3-1. window 범위를 벗어날 문자의 개수 조정
                count[s.charAt(left) - 'A']--;

                //3-2. left pointer 이동
                left++;

                //3-3. maxFreq 재확인
                maxFreq = Math.max(maxFreq, count[s.charAt(left - 1) - 'A']);

                //3-4. 변경 필요한 문자 수 확인
                windowSize = right - left + 1;
                needToChange = windowSize - maxFreq;

            }
        }

        return right - left + 1;
    }

    public static void main(String[] args) {
        String s = "ABAB";
        int k = 2;
        System.out.println(new LongestRepeatingCharacterReplacement().characterReplacement(s, k));
    }
}
