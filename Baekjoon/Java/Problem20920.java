import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Problem20920 {
    static int N;
    static int minWord;
    static HashMap<String, Integer> maps = new HashMap<>();
    static ArrayList<Word> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        minWord = Integer.parseInt(st.nextToken());
        for(int i = 0; i < N; i++){
            String input = br.readLine();
            if(input.length() < minWord) continue;
            if(maps.containsKey(input)){
                maps.put(input, maps.get(input)+1);
            }
            else{
                maps.put(input, 1);
            }
        }
        for(String s : maps.keySet()){
            list.add(new Word(s, maps.get(s), s.length()));
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for(Word w : list){
            sb.append(w.word).append("\n");
        }
        System.out.print(sb);
    }

    static class Word implements Comparable<Word>{
        String word;
        int count;
        int length;

        Word(String word, int count, int length) {
            this.word = word;
            this.count = count;
            this.length = length;
        }

        @Override
        public int compareTo(Word o) {
            if(this.count == o.count){
                if(this.length == o.length){
                    return this.word.compareTo(o.word);
                }
                return o.length - this.length;
            }
            else{
                return o.count - this.count;
            }
        }
    }
}
