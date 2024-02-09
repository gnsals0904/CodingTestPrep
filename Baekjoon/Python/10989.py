import sys


N = int(input())
num_list = [0 for _ in range(10001)]
for _ in range(N):
    v = int(sys.stdin.readline().strip())
    num_list[v] += 1
for i in range(10001):
    if num_list[i] != 0:
        for _ in range(num_list[i]):
            print(i)
