import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem1700 {
    static int N, K;
    static Set<Integer> pages = new HashSet<>();
    static ArrayList<Integer>[] lists;
    static int[] listPoints;
    static int[] inputs;
    static int result;

    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        lists = new ArrayList[K + 1];
        listPoints = new int[K + 1];
        for (int i = 0; i < K + 1; i++) {
            lists[i] = new ArrayList<>();
        }
        inputs = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int now = Integer.parseInt(st.nextToken());
            lists[now].add(i);
            inputs[i] = now;
        }

        for (int i = 0; i < K; i++) {
            if (pages.size() == N) {
                if (!pages.contains(inputs[i])) {
                    int chgIdx = -1;
                    int maxValue = -1;

                    for (int num : pages) {
                        if (listPoints[num] >= lists[num].size()) {
                            chgIdx = num;
                            break;
                        } else if (maxValue < lists[num].get(listPoints[num])) {
                            maxValue = lists[num].get(listPoints[num]);
                            chgIdx = num;
                        }
                    }
                    pages.remove(chgIdx);
                    pages.add(inputs[i]);
                    result++;
                }
                listPoints[inputs[i]]++;
            } else {
                pages.add(inputs[i]);
                listPoints[inputs[i]]++;
            }
        }
        System.out.println(result);
    }
}
