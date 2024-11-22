import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem7983 {
    static int N;
    static Task[] tasks;
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        N = Integer.parseInt(br.readLine());
        tasks = new Task[N];
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int duration = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());
            int startTime = endTime - duration + 1;
            tasks[i] = new Task(startTime, endTime);
        }
        Arrays.sort(tasks);
        System.out.println(taskCalc() - 1);
    }

    private static int taskCalc() {
        int prevStartTime = tasks[0].startT;
        for(int i = 0; i < N; i++){
            boolean flag = false;
            if(i > 0 && prevStartTime <= tasks[i].endT) {
                flag = true;
            }

            if(flag){
                int value = tasks[i].endT - prevStartTime + 1;
                prevStartTime = tasks[i].startT - value;
            }
            else{
                prevStartTime = tasks[i].startT;
            }
        }
        return prevStartTime;
    }

    static class Task implements Comparable<Task> {
        int startT;
        int endT;

        Task(int startT, int endT){
            this.startT = startT;
            this.endT = endT;
        }

        @Override
        public int compareTo(Task o) {
            return Integer.compare(o.endT, this.endT);
        }
    }
}
