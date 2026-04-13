import java.util.*;

class Anagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);

            map.computeIfAbsent(key, x -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }
}