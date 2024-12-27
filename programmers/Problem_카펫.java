class Problem_카펫 {
    public int[] solution(int brown, int yellow) {
        for(int i = 1; i < brown / 2; i++){
            if(yellow%i==0){
                int y = yellow/i;
                if((2*y + 2*i + 4) == brown){
                    if(Math.max(i+2, y+2) == i+2){
                        int[] answer = {i+2, y+2};
                        return answer;
                    } else{
                        int[] answer = {y+2, i+2};
                        return answer;
                    }
                }
            }
        }
        return null;
    }
}
