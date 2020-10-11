package week04;

import java.util.*;

public class WordLadder {
    private Set<String> setBox, visited;
    Queue<String> queue;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        setBox = new HashSet<>(wordList);
        queue = new LinkedList<>();
        queue.offer(beginWord);
        visited = new HashSet<>();
        visited.add(beginWord);
        int count = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                if(findRes(queue.poll(), endWord)) return count+1;
            }
            count++;
        }
        return 0;
    }
    private boolean findRes(String beginWord, String endWord){
        char[] arr = beginWord.toCharArray();
        for(int i = 0; i < beginWord.length(); i++){
            char temp = arr[i];
            for(char k = 'a'; k <= 'z'; k++){
                if(k == temp) continue;
                arr[i] = k;
                String nextWord = String.valueOf(arr);
                if(nextWord.equals(endWord)) return true;
                if(setBox.contains(nextWord) && !visited.contains(nextWord)){
                    queue.offer(nextWord);
                    visited.add(nextWord);
                }
            }
            arr[i] = temp;
        }
        return false;
    }
}
