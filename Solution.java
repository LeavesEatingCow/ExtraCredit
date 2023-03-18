import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }
        int len = words[0].length();
        int total = len * words.length;
        if (s.length() < total) {
            return result;
        }
        Map<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i <= s.length() - total; i++) {
            Map<String, Integer> subFreq = new HashMap<>();
            String sub = s.substring(i, i + total);
            for (int j = 0; j < total; j += len) {
                String word = sub.substring(j, j + len);
                subFreq.put(word, subFreq.getOrDefault(word, 0) + 1);
            }
            if (freq.equals(subFreq)) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String s1 = "wordgoodgoodgoodbestword";
        String[] words = {"foo", "bar"};
        String[] words1 = {"word","good","best","word"};

        Solution solution = new Solution();
        List<Integer> result = solution.findSubstring(s, words);
        System.out.println(result);
        result = solution.findSubstring(s1, words1);
        System.out.println(result);


    }

}
