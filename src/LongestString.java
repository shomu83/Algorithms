import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

class LongestString {

    public static void main(String[] args) {

        LongestString solution = new LongestString();

        Stream.of("a", "abc", "abcb","aaa", "ababc", "", "  ", "zzzabcdefgz")
//        Stream.of("a")
        .forEach(x -> System.out.println(solution.lengthOfLongestSubstring(x)));
    }

    public int lengthOfLongestSubstring(String s) {

        int maxLength = 0;

        Map<Character, Integer> map = new HashMap<>();
        for (int start = 0, end = 0; end < s.length(); end++) {

            if (map.containsKey(s.charAt(end)))
                start = map.get(s.charAt(end)) + 1;

            maxLength = Math.max(maxLength, end - start + 1);

            map.put(s.charAt(end), end);
        }

        return maxLength;
    }

//    public int lengthOfLongestSubstring(String s) {
//        int n = s.length(), ans = 0;
//        Map<Character, Integer> map = new HashMap<>(); // current index of character
//        // try to extend the range [i, j]
//        for (int j = 0, i = 0; j < n; j++) {
//            if (map.containsKey(s.charAt(j))) {
//                i = Math.max(map.get(s.charAt(j)), i);
//            }
//            ans = Math.max(ans, j - i + 1);
//            map.put(s.charAt(j), j + 1);
//        }
//        return ans;
//    }

//    public int lengthOfLongestSubstring(String s) {
//
//        if (s == null)
//            return 0;
//
//        String longest = "";
//
//        for (int start =0 ;start < s.length(); start++) {
//            boolean[] letters = new boolean[128];
//            letters[s.charAt(start)] = true;
//            int length = 1;
//            for (int i = start + 1; i < s.length(); i++) {
//                if (letters[s.charAt(i)]) {
//                    break;
//                }
//                letters[(int)s.charAt(i)] = true;
//                length++;
//            }
//
//            String temp = s.substring(start, start + length);
//            if (temp.length() > longest.length())
//                longest = temp;
//        }
//
//        return longest.length();
//    }

}

