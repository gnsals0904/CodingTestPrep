import sys

N, M = map(int, input().split())
# P가 0, M이 1
arr = [[-1 for _ in range(2)] for _ in range(N)]
info = []
for _ in range(M):
    one_line = list(map(str, sys.stdin.readline().split()))
    a = int(one_line[0])
    c = int(one_line[2])
    if one_line[1] == 'P':
        arr[a - 1][0] = c
    else:
        arr[a - 1][1] = c
    info.append(one_line)
min_result = 0
max_result_minus = 0
for x in arr:
    if x[0] == 1 and x[1] == 0:
        min_result += 1
    if x[0] == 0 or x[1] == 1:
        max_result_minus += 1
print(min_result, N - max_result_minus)
