package hard;

import java.util.*;

public class WordLadder2 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        Set<String> wordDict = new HashSet<>(wordList);
        if (!wordDict.contains(endWord)) return result;
        Map<String, List<String>> neighborMap = new HashMap<>();
        Set<String> startSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);
        startSet.add(beginWord);
        //这一步就是为了找到各个从beginWord到endWord的所有neighbor 图
        //建图结构
        bfs(startSet, endSet, neighborMap, wordDict, false);

        List<String> oneLadder = new ArrayList<>();
        oneLadder.add(beginWord);
        //遍历图结构，找到从节点beginWord到endWord的所有Path
        dfs(result, oneLadder, beginWord, endWord, neighborMap);
        return result;
    }


    private void dfs(List<List<String>> result, List<String> oneLadder, String word, String endWord, Map<String, List<String>> neighborMap) {
        if (word.equals(endWord)) {
            result.add(oneLadder);
            return;
        }

        if (neighborMap.get(word) == null) return;
        for (String next : neighborMap.get(word)) {
            oneLadder.add(next);
            dfs(result, oneLadder, next, endWord, neighborMap);
            oneLadder.remove(oneLadder.size() - 1);
        }
    }

    private void bfs(Set<String> startSet, Set<String> endSet, Map<String, List<String>> neighborMap, Set<String> wordDict, boolean reverse) {
        if (startSet.size() == 0) return;

        if (startSet.size() > endSet.size()) {
            bfs(endSet, startSet, neighborMap, wordDict, !reverse);
            return;
        }

        Set<String> tmp = new HashSet<>();
        wordDict.removeAll(startSet);
        boolean finish = false;

        for (String startWord : startSet) {
            char[] startWordChar = startWord.toCharArray();
            for (int i = 0; i < startWordChar.length; i++) {
                char oldChar = startWordChar[i];
                for (char newChar = 'a'; newChar <= 'z'; newChar++) {
                    startWordChar[i] = newChar;
                    String newWord = new String(startWordChar);

                    if (wordDict.contains(newWord)) {
                        if (endSet.contains(newWord)) {
                            finish = true;
                        } else {
                            tmp.add(newWord);
                        }

                        String key = reverse ? newWord : startWord;
                        String oneNeighbor = reverse ? startWord : newWord;

                        neighborMap.putIfAbsent(key, new ArrayList<>());

                        neighborMap.get(key).add(oneNeighbor);
                    }
                }

                startWordChar[i] = oldChar;
            }
        }

        if (!finish) {
            bfs(tmp, endSet, neighborMap, wordDict, reverse);
        }
    }

    public static void main(String[] args) {
        WordLadder2 wordLadder2 = new WordLadder2();
        List<String> wodList = Arrays.asList("hot","dot","dog","lot","log","cog");
        wordLadder2.findLadders("hit", "cog", wodList);
    }
}
