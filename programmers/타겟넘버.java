class 타겟넘버 {
    static int N, T;
    static int result;
    static int[] inputs;
    public int solution(int[] numbers, int target) {
        N = numbers.length;
        T = target;
        inputs = numbers;
        dfs(0, 0);
        return result;
    }
    
    static void dfs(int depth, int nowNumber){
        if(depth == N){
            if(T == nowNumber) result++;
            return;
        }
        dfs(depth + 1, nowNumber + inputs[depth]);
        dfs(depth + 1, nowNumber - inputs[depth]);
    }
}
