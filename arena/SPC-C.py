import sys

N = int(input())
people_list = list(map(int, sys.stdin.readline().split()))
M = int(input())
for _ in range(M):
    result_list = people_list.copy()
    L, R = map(int, sys.stdin.readline().split())
    count = L
    for i in range(N):
        if L <= result_list[i] <= R:
            result_list[i] = count
            count += 1
    print(*result_list)
