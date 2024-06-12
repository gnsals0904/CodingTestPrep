package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Problem1339 {
    static int N;
    static Alpha[] alpha = new Alpha[26];
    static int[] chgNum = new int[26];
    static int result;
    static ArrayList<String> alphaList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        for (int i = 0; i < 26; i++) {
            alpha[i] = new Alpha(0, i);
        }
        N = Integer.parseInt(br.readLine());
        Arrays.fill(chgNum, -1);

        for (int i = 0; i < N; i++) {
            String tempAlpha = br.readLine();
            alphaList.add(tempAlpha);
            int len = tempAlpha.length();
            for (int j = 0; j < len; j++) {
                char c = tempAlpha.charAt(j);
                int num = c - 'A';
                int weight = (int) Math.pow(10, len - j - 1);
                alpha[num].num += weight;
            }
        }

        Arrays.sort(alpha);
        System.out.println(Arrays.toString(alpha));
        int count = 9;
        for (Alpha nowAlpha : alpha) {
            if (nowAlpha.num == 0) break;
            chgNum[nowAlpha.originIdx] = count;
            count--;
        }

        for (String nowS : alphaList) {
            int len = nowS.length();
            for (int i = 0; i < len; i++) {
                int idx = len - i - 1;
                char nowC = nowS.charAt(i);
                result += ((int) Math.pow(10, idx)) * chgNum[nowC - 'A'];
            }
        }
        System.out.println(result);
    }

    static class Alpha implements Comparable<Alpha> {
        int num;
        int originIdx;

        Alpha(int num, int originIdx) {
            this.num = num;
            this.originIdx = originIdx;
        }

        @Override
        public int compareTo(Alpha o) {
            return Integer.compare(o.num, this.num);
        }

        @Override
        public String toString() {
            return "Alpha{" +
                    "num=" + num +
                    ", originIdx=" + originIdx +
                    '}';
        }
    }
}
