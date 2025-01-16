import java.io.*;
import java.util.*;

class 단어변환 {
    static Queue<String> queue = new LinkedList<>();
    static boolean[] isUsed;
    public int solution(String begin, String target, String[] words) {
        isUsed = new boolean[words.length];
        String b = begin;
        queue.add(b);
        int time = 0;
        int size = queue.size();
        while(!queue.isEmpty()){
            for(int t = 0; t < size; t++){
                String nowWord = queue.poll();
                if(target.equals(nowWord)){
                    return time;
                }
                for(int i = 0; i < words.length; i++){
                    if(isUsed[i]) continue;
                    int diff = isDiff(nowWord, words[i]);
                    if(diff == 1){
                        isUsed[i] = true;
                        queue.add(words[i]);
                    }
                }                 
            }
            time++;
            size = queue.size();
 
        }
        return 0;
    }
    
    // 0 => same
    // 1 => one diff
    // 2 => more diff
    static int isDiff(String origin, String target){
        int count = 0;
        for(int i = 0; i < origin.length(); i++){
            if(origin.charAt(i) != target.charAt(i)) count++;
            if(count >= 2) return 2;
        }
        if(count == 0) return 0;
        return 1;
    }
}
