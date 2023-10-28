import sys

N = int(input())
all_list = []
for _ in range(N):
    one_line = list(map(str, sys.stdin.readline().split()))
    all_list.append(one_line)
all_list.sort(key=lambda x: int(x[0]))
for i in range(N):
    print(all_list[i][0], all_list[i][1])
