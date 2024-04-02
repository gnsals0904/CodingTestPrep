import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Problem11401 {
    static long[] fac;
    // p 는 고정이다.
    static int p = 1000000007;

    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        // factorial 먼저 계산
        fac = new long[N + 1];
        fac[0] = 1;
        fac[1] = 1;
        for (int i = 2; i < N + 1; i++) {
            fac[i] = (fac[i - 1] * i) % p;
        }
        // 조합 조건에 맞게 계산한다.
        long result = ((long) fac[N] * (long) calc(N, R)) % p;
        System.out.println(result);
    }

    // 페르마의 소정리를 이용해서 p-2 를 계산하도록 바꾸어 준다.
    // r! * (n - r)! ^ (p-2) 을 계산하는 함수
    static long calc(int n, int r) {
        long result = ((long) fac[r] * (long) fac[n - r]) % p;
        result = calc2(result, p - 2) % p;
        return result;
    }

    // p - 2 의 거듭제곱을 계산하는 함수
    static long calc2(long x, int n) {
        if (n == 1) return x;
        long result = calc2(x, n / 2);
        result = (result * result) % p;
        return n % 2 == 0 ? result : (result * x) % p;
    }
}
