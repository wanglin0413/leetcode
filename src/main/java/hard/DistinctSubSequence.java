package hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DistinctSubSequence {
    public int numDistinct(String s, String t) {
        if (t.length() > s.length()) return 0;

        int N = t.length();

        int[] ctr = new int[N+1];
        ctr[0] = 1;

        Map<Character, List<Integer>> charMap = new HashMap<>();
        for (int i = N-1; i >= 0; i--) {
            char c = t.charAt(i);
            if (!charMap.containsKey(c)) {
                charMap.put(c, new ArrayList<>());
            }
            charMap.get(c).add(i);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            List<Integer> tIndices = charMap.get(c);
            if (tIndices == null) continue;
            for (Integer idx: tIndices) {
                ctr[idx+1] += ctr[idx];
            }
        }

        return ctr[N];
    }

    public static void main(String[] args) {
        DistinctSubSequence ds = new DistinctSubSequence();
        System.out.println(ds.numDistinct("babgbag", "bag"));
    }
}
