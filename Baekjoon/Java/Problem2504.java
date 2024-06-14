package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Problem2504 {
    static Stack<String> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        String input = br.readLine();
        int result = 0;
        for (int i = 0; i < input.length(); i++) {
            char nowInput = input.charAt(i);
            int howGo = check(nowInput);
            if (howGo == 1) {
                stack.add(String.valueOf(nowInput));
            } else if (howGo == 2) {
                if (!stack.isEmpty()) {
                    int check = check(stack.peek().charAt(0));
                    if (nowInput == ')') {
                        if (stack.peek().equals("(")) {
                            stack.pop();
                            if (stack.isEmpty()) {
                                result += 2;
                            } else {
                                stack.add("2");
                            }
                        } else if (check == 0) {
                            int temp = Integer.parseInt(stack.pop());
                            while (!stack.isEmpty() && check(stack.peek().charAt(0)) == 0) {
                                temp += Integer.parseInt(stack.pop());
                            }
                            if (!stack.isEmpty() && stack.peek().equals("(")) {
                                stack.pop();
                                temp *= 2;
                                if (stack.isEmpty()) {
                                    result += temp;
                                } else {
                                    stack.add(String.valueOf(temp));
                                }
                            } else {
                                System.out.println(0);
                                return;
                            }
                        } else {
                            System.out.println(0);
                            return;
                        }
                    } else { // nowInput == ']'
                        if (stack.peek().equals("[")) {
                            stack.pop();
                            if (stack.isEmpty()) {
                                result += 3;
                            } else {
                                stack.add("3");
                            }
                        } else if (check == 0) {
                            int temp = Integer.parseInt(stack.pop());
                            while (!stack.isEmpty() && check(stack.peek().charAt(0)) == 0) {
                                temp += Integer.parseInt(stack.pop());
                            }
                            if (!stack.isEmpty() && stack.peek().equals("[")) {
                                stack.pop();
                                temp *= 3;
                                if (stack.isEmpty()) {
                                    result += temp;
                                } else {
                                    stack.add(String.valueOf(temp));
                                }
                            } else {
                                System.out.println(0);
                                return;
                            }
                        } else {
                            System.out.println(0);
                            return;
                        }
                    }
                } else {
                    System.out.println(0);
                    return;
                }
            }
        }
        while (!stack.isEmpty()) {
            if (check(stack.peek().charAt(0)) == 0) {
                result += Integer.parseInt(stack.pop());
            } else {
                System.out.println(0);
                return;
            }
        }
        System.out.println(result);
    }

    static int check(char c) {
        if (c == '(' || c == '[') return 1;
        else if (c == ')' || c == ']') return 2;
        else return 0; // 숫자
    }
}
