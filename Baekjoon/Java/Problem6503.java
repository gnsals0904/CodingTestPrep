import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Problem6503 {
    static Map<Character, Integer> map = new HashMap<>();
    static StringBuilder result = new StringBuilder();
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        int m = Integer.parseInt(br.readLine());
        while(m != 0) {
            String input = br.readLine();
            result.append(findMax(input, m)).append("\n");
            map.clear();
            m = Integer.parseInt(br.readLine());
        }
        System.out.print(result);
    }

    static int findMax(String s, int m) {
        int max = 0;
        int left = 0, right = 0;
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);
            right++;

            while (map.size() > m) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }
            max = Math.max(max, right - left);
        }
        return max;
    }
}
