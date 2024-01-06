import sys

N = int(input())
num_list = set(map(int, sys.stdin.readline().split()))
M = int(input())
find_list = list(map(int, sys.stdin.readline().split()))
for i in range(M):
    now_value = find_list[i]
    if now_value in num_list:
        print(1)
    else:
        print(0)
