import sys


n = int(input())
n_list = list()
for _ in range(n):
    one_line = list(map(int, sys.stdin.readline().split()))
    n_list.append(one_line)
n_list.sort(key=lambda x: (x[1], x[0]))
for i in range(n):
    print(f'{n_list[i][0]} {n_list[i][1]}')
