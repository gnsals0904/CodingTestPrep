import java.util.*;

class K번째수 {
    static int N;
    public int[] solution(int[] array, int[][] commands) {
        N = commands.length;
        int[] answer = new int[N];
        for(int i = 0; i < N; i++){
            answer[i] = sliceArray(array, commands[i]);
        }
        return answer;
    }
    
    static int sliceArray(int[] array, int[] command){
        int size = command[1] - command[0] + 1;
        int[] tempArray = new int[size];
        int cur = command[0] - 1;
        for(int i = 0; i < size; i++){
            tempArray[i] = array[cur++];
        }
        Arrays.sort(tempArray);
        return tempArray[command[2] - 1];
    }
}
