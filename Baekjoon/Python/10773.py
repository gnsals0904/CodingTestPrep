import sys


K = int(input())
stack = []
for _ in range(K):
    n = int(sys.stdin.readline().rstrip())
    if n != 0:
        stack.append(n)
    else:
        stack.pop()
print(sum(stack))
