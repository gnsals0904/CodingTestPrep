import sys


N = int(input())
num_list = []
for _ in range(N):
    one_line = list(map(str, sys.stdin.readline().split()))
    num_list.append(one_line)
num_list.sort(key=lambda x: (-int(x[1]), int(x[2]), -int(x[3]), x[0]))
for i in range(N):
    print(num_list[i][0])
