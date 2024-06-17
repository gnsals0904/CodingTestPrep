package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem1092 {
    static int N, M;
    static int[] cranesArray;
    static LinkedList<Integer> boxes;
    static int result;

    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        N = Integer.parseInt(br.readLine());
        cranesArray = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            cranesArray[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cranesArray);

        M = Integer.parseInt(br.readLine());
        boxes = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            boxes.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(boxes, Collections.reverseOrder());

        if(cranesArray[N - 1] < boxes.get(0)){
            System.out.println(-1);
            return;
        }

        result = 0;
        while (!boxes.isEmpty()) {
            Iterator<Integer> boxIterator = boxes.iterator();
            for (int i = N - 1; i >= 0; i--) {
                if (!boxIterator.hasNext()) break;
                while (boxIterator.hasNext()) {
                    int box = boxIterator.next();
                    if (cranesArray[i] >= box) {
                        boxIterator.remove();
                        break;
                    }
                }
            }
            result++;
        }
        System.out.println(result);
    }
}
