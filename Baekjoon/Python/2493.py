import sys
from collections import deque

N = int(input())
height_list = list(map(int, sys.stdin.readline().split()))
result_list = [0 for _ in range(N)]
stack = deque()
stack.append((height_list[0], 0))
stack_len = 1
for i in range(1, N):
    if stack[stack_len - 1][0] < height_list[i]:
        while stack[stack_len - 1][0] < height_list[i]:
            v, v_idx = stack.pop()
            stack_len -= 1
            if stack_len == 0:
                break
        if stack_len > 0:
            result_list[i] = stack[stack_len - 1][1] + 1
        stack.append((height_list[i], i))
        stack_len += 1
    else:
        result_list[i] = stack[stack_len - 1][1] + 1
        stack.append((height_list[i], i))
        stack_len += 1
while stack:
    v, v_idx = stack.pop()
    stack_len -= 1
    if stack_len > 0:
        result_list[v_idx] = stack[stack_len - 1][1] + 1
    else:
        result_list[v_idx] = 0
print(*result_list)
