import sys

N, M = map(int, input().split())
num_list = list(map(int, sys.stdin.readline().split()))
for i in range(1, N):
    num_list[i] = num_list[i] + num_list[i - 1]
for _ in range(M):
    a, b = map(int, sys.stdin.readline().split())
    if a >= 2:
        print(num_list[b - 1] - num_list[a - 2])
    else:
        print(num_list[b - 1])
