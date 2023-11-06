import sys
from collections import deque

L = int(input())
for _ in range(L):
    s = sys.stdin.readline().rstrip()
    len_s = len(s)
    stack_count = 0
    stack = []
    queue = deque()
    queue_count = 0
    for x in s:
        if x == '<':
            if stack_count > 0:
                queue.append(stack.pop())
                stack_count -= 1
                queue_count += 1
        elif x == '-':
            if stack_count > 0:
                stack.pop()
                stack_count -= 1
        elif x == '>':
            if queue_count > 0:
                stack.append(queue.pop())
                stack_count += 1
                queue_count -= 1
        else:
            stack.append(x)
            stack_count += 1
    while queue:
        stack.append(queue.pop())
    print(*stack, sep='')


