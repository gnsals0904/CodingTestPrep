import sys

N = int(input())
all_line = []
for _ in range(N):
    one_line = list(map(int, sys.stdin.readline().split()))
    all_line.append(one_line)
all_line.sort()
for i in range(N):
    print(*all_line[i])
