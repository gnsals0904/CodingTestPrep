import sys
from collections import deque

s = input()
len_s = len(s)
stack_count = len_s
stack = []
queue = deque()
queue_count = 0

for x in s:
    stack.append(x)
L = int(input())

for _ in range(L):
    now_input = list(map(str, sys.stdin.readline().split()))
    if now_input[0] == 'L':
        if stack_count > 0:
            queue.append(stack.pop())
            stack_count -= 1
            queue_count += 1
    elif now_input[0] == 'B':
        if stack_count > 0:
            stack.pop()
            stack_count -= 1
    elif now_input[0] == 'D':
        if queue_count > 0:
            stack.append(queue.pop())
            stack_count += 1
            queue_count -= 1
    else:
        stack.append(now_input[1])
        stack_count += 1

while queue:
    stack.append(queue.pop())
print(*stack, sep='')


